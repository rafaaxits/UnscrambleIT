package com.interaction.acitivity.unscrambleit.view.activities

import android.app.ListActivity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import com.facebook.AccessToken
import com.facebook.CallbackManager
import com.google.firebase.auth.FirebaseAuth
import com.interaction.acitivity.unscrambleit.R
import kotlinx.android.synthetic.main.activity_unscramble_it__sign_in.*
import com.facebook.FacebookException
import com.facebook.login.LoginResult
import com.facebook.FacebookCallback
import com.facebook.login.LoginManager
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.firebase.auth.FacebookAuthProvider
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import android.support.v4.app.FragmentActivity
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthCredential
import com.google.firebase.auth.GoogleAuthProvider


class UnscrambleIT_SignIn : AppCompatActivity() {
    var mAuth: FirebaseAuth? = null
    var mAuthListener: FirebaseAuth.AuthStateListener? = null
    private lateinit var callbackManager: CallbackManager
    private var TAGGOOGLE = "GoogleActivity"
    private var RC_SIGN_IN = 9001
    private var mGoogleSignInClient: GoogleSignInClient? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_unscramble_it__sign_in)

        mAuth = FirebaseAuth.getInstance()
        mAuthListener = FirebaseAuth.AuthStateListener {  }
        callbackManager = CallbackManager.Factory.create()

        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build()
        mGoogleSignInClient = GoogleSignIn.getClient(this, gso)

        signInButton.setOnClickListener() {
            val signInIntent = mGoogleSignInClient!!.signInIntent
            startActivityForResult(signInIntent, RC_SIGN_IN)
        }

        login_button.setReadPermissions("email", "public_profile")

        login_button.setOnClickListener {
            login_button.registerCallback(callbackManager, object : FacebookCallback<LoginResult> {
                override fun onSuccess(loginResult: LoginResult) {
                    Log.d(TAG, "facebook:onSuccess:$loginResult")
                    handleFacebookAccessToken(loginResult.accessToken)
                }

                override fun onCancel() {
                    Log.d(TAG, "facebook:onCancel")
                }

                override fun onError(exception: FacebookException) {
                    Log.d(TAG, "facebook:onError", exception)
                    Toast.makeText(applicationContext, exception.localizedMessage, Toast.LENGTH_SHORT).show()
                }
            })
        }

    }

    fun signIn(view: View){
        mAuth!!.signInWithEmailAndPassword(edtMail.text.toString(), edtPassword.text.toString())
            .addOnCompleteListener { task ->
                if(task.isSuccessful){
                    Toast.makeText(applicationContext, "User Signed!!", Toast.LENGTH_SHORT).show()
                    val intent = Intent(applicationContext, UnscrambleIT_Home::class.java)
                    startActivity(intent)
                }
            }

            .addOnFailureListener { exception ->
                Toast.makeText(applicationContext, exception.localizedMessage, Toast.LENGTH_SHORT).show()
            }
    }

    fun signUp(view: View){
        mAuth!!.createUserWithEmailAndPassword(edtMail.text.toString(), edtPassword.text.toString())
            .addOnCompleteListener{ task ->
                if(task.isSuccessful){
                    Toast.makeText(applicationContext, "User Created!!", Toast.LENGTH_SHORT).show()
                }
            }
            .addOnFailureListener { exception ->
                Toast.makeText(applicationContext, exception.localizedMessage, Toast.LENGTH_SHORT).show()
            }
    }

    private fun handleFacebookAccessToken(token: AccessToken) {
        Log.d(TAG, "handleFacebookAccessToken:$token")

        val credential = FacebookAuthProvider.getCredential(token.token)
        mAuth!!.signInWithCredential(credential)
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        Log.d(TAG, "signInWithCredential:success")
                        Toast.makeText(applicationContext, "User Signed!!", Toast.LENGTH_SHORT).show()
                        val intent = Intent(applicationContext, UnscrambleIT_Home::class.java)
                        startActivity(intent)
                    } else {
                        Log.w(TAG, "signInWithCredential:failure", task.exception)
                        Toast.makeText(baseContext, "Authentication failed.",
                                Toast.LENGTH_SHORT).show()
                    }
                }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(requestCode == RC_SIGN_IN){
            val result = GoogleSignIn.getSignedInAccountFromIntent(data)
             try {
                var account:GoogleSignInAccount = result.getResult(ApiException::class.java)
                 firebaseAuthWithGoogle(account)
             } catch (exception: Exception) {
                Log.w(TAG, "Google sign in failed", exception)
             }
        } else {
            callbackManager.onActivityResult(requestCode, resultCode, data)
        }

    }

    private fun firebaseAuthWithGoogle(acct: GoogleSignInAccount) {
        Log.e(TAG, "firebaseAuthWithGoogle():" + acct.id!!)
        val credential = GoogleAuthProvider.getCredential(acct.idToken, null)
        mAuth!!.signInWithCredential(credential)
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        Log.d(TAGGOOGLE, "signInWithCredential:success")
                        Toast.makeText(applicationContext, "User Signed!!", Toast.LENGTH_SHORT).show()
                        val intent = Intent(applicationContext, UnscrambleIT_Home::class.java)
                        startActivity(intent)
                    } else {
                        Log.w(TAGGOOGLE, "signInWithCredential:failure", task.exception)
                        Toast.makeText(baseContext, "Authentication failed.",
                                Toast.LENGTH_SHORT).show()
                    }
                }
    }

    public override fun onStart() {
        super.onStart()
        // Check if user is signed in (non-null) and update UI accordingly.
        val currentUser = mAuth!!.currentUser
        if(currentUser != null){
            Toast.makeText(applicationContext, "User already Signed!!", Toast.LENGTH_SHORT).show()
            val intent = Intent(applicationContext, UnscrambleIT_Home::class.java)
            startActivity(intent)
        }
    }

    companion object {
        private const val TAG = "FacebookLogin"
    }
}
