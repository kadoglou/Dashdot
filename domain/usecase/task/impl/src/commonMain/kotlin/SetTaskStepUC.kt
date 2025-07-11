import data.Step

interface SetTaskStepUC {

    suspend operator fun invoke(taskId: String, step: Step)

}

internal class SetTaskStepUCImpl(
    private val taskRepository: TaskRepository,
) : SetTaskStepUC {

    override suspend fun invoke(taskId: String, step: Step) {
        val task = taskRepository.getTaskOnce(taskId)
        if (task == null) return
        val updatedTask = task.copy(steps = task.steps.plus(step))
        taskRepository.updateTask(updatedTask)
    }

}