import data.TaskDto
import dev.gitlive.firebase.Firebase
import dev.gitlive.firebase.auth.auth
import dev.gitlive.firebase.firestore.firestore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

interface TaskRepository {

    suspend fun saveTask(taskDto: TaskDto)

    suspend fun getTaskOnce(id: String): TaskDto?

    fun getTask(id: String): Flow<TaskDto?>

    fun getTasks(): Flow<List<TaskDto>>

    suspend fun updateTask(taskDto: TaskDto)

}

@OptIn(ExperimentalUuidApi::class)
internal class TaskRepositoryImpl() : TaskRepository {

    override suspend fun saveTask(taskDto: TaskDto) {
        val userId = Firebase.auth.currentUser?.uid ?: return
        val taskId = Uuid.random()
        Firebase.firestore
            .collection("users")
            .document(userId)
            .collection("tasks")
            .document(taskId.toString())
            .set(taskDto.copy(id = taskId.toString()))

    }

    override suspend fun getTaskOnce(id: String): TaskDto? {
        val userId = Firebase.auth.currentUser?.uid ?: return null

        return try {
            Firebase.firestore
                .collection("users")
                .document(userId)
                .collection("tasks")
                .document(id)
                .snapshots
                .map { snapshot ->
                    snapshot.data<TaskDto>()
                }
                .firstOrNull()
        } catch (e: Exception) {
            println("⚠️ Failed to get task: ${e.message}")
            null
        }
    }

    override fun getTask(id: String): Flow<TaskDto?> = flow {
        val userId = Firebase.auth.currentUser?.uid
        if (userId == null) {
            emit(null)
            return@flow
        }

        Firebase.firestore
            .collection("users")
            .document(userId)
            .collection("tasks")
            .document(id)
            .snapshots
            .collect { querySnapshot ->
                val taskDto = querySnapshot.data<TaskDto>()
                emit(taskDto)
            }
    }

    override fun getTasks(): Flow<List<TaskDto>> = flow {
        val userId = Firebase.auth.currentUser?.uid
        if (userId == null) {
            emit(emptyList())
            return@flow
        }

        Firebase.firestore
            .collection("users")
            .document(userId)
            .collection("tasks")
            .snapshots
            .collect { querySnapshot ->
                val taskDtos = querySnapshot.documents.map { it.data<TaskDto>() }
                emit(taskDtos)
            }
    }

    override suspend fun updateTask(taskDto: TaskDto) {
        val userId = Firebase.auth.currentUser?.uid
        if (userId != null && taskDto.id != null) {
            Firebase.firestore
                .collection("users")
                .document(userId)
                .collection("tasks")
                .document(taskDto.id)
                .set(taskDto)
        }
    }


}