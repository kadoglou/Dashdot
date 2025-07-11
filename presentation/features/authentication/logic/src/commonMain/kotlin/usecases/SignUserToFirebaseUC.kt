package usecases

import dev.gitlive.firebase.Firebase
import dev.gitlive.firebase.auth.GoogleAuthProvider
import dev.gitlive.firebase.auth.auth

interface SignUserToFirebaseUC {
    suspend fun execute(idToken: String?, accessToken: String?)
}

internal class SignUserToFirebaseUCImpl() : SignUserToFirebaseUC {

    override suspend fun execute(idToken: String?, accessToken: String?) {
        val firebaseAuth = Firebase.auth
        val credential = GoogleAuthProvider.credential(idToken, accessToken)
        firebaseAuth.signInWithCredential(credential)
    }

}