package com.joy.vpals.data


import android.content.Context
import android.widget.Toast
import androidx.compose.ui.text.input.TextFieldValue
import androidx.navigation.NavController
//import androidx.swiperefreshlayout.widget.CircularProgressDrawable.ProgressDrawableSize
//import com.joy.vpals.navigation.ROUTE_HOME
//import com.example.firebase_auth.navigation.ROUTE_LOGIN
//import com.example.firebase_auth.navigation.ROUTE_REGISTER
//import com.example.firebaseauth.models.User
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import com.joy.vpals.models.User
import com.joy.vpals.navigation.ROUTE_HOME
import com.joy.vpals.navigation.ROUTE_LOGIN

class AuthviewModel(var navController: NavController,var context: Context){
    var mAuth:FirebaseAuth
//    val progress:ProgressDialog
    init {
        mAuth= FirebaseAuth.getInstance()
//        progress=ProgressDialog(context)
//        progress.setTitle("Loading")
//        progress.setMessage("Please wait...")
    }
    fun signup(email: String, pass: String, confpass: String) {
//        progress.show()
        if (email.isEmpty() || pass.isBlank() || confpass.isBlank()) {
            Toast.makeText(context, "Please email and password cannot be blank", Toast.LENGTH_LONG)
                .show()
            return
        } else if (pass != confpass) {
            Toast.makeText(context, "Password do not match", Toast.LENGTH_LONG).show()
            return
        } else {
            mAuth.createUserWithEmailAndPassword(email.toString(), pass.toString()).addOnCompleteListener {
                if (it.isSuccessful) {
                    val userdata= User(email, pass, mAuth.currentUser!!.uid)
                    val regRef=FirebaseDatabase.getInstance().getReference()
                        .child("Users/"+mAuth.currentUser!!.uid)
                    regRef.setValue(userdata).addOnCompleteListener {
                        if (it.isSuccessful){
                            Toast.makeText(context, "Registered sucessfully", Toast.LENGTH_LONG).show()

                        }
                    }
                    Toast.makeText(context, "Registered sucessfully", Toast.LENGTH_LONG).show()
                    navController.navigate(ROUTE_HOME)
                } else {
                    Toast.makeText(context, "${it.exception!!.message}", Toast.LENGTH_LONG).show()
                    navController.navigate(ROUTE_LOGIN)
                }
            }

        }

    }
    //    if you want the code to take you to anther page use navigation...navcontroller
    fun login(email:String, pass:String){
//        progress.show()
        mAuth.signInWithEmailAndPassword(email, pass).addOnCompleteListener {
            if(it.isSuccessful)  {
                Toast.makeText(context,"logged in",Toast.LENGTH_LONG).show()
                navController.navigate(ROUTE_HOME)
//             takes you to diff page
            }else{
                Toast.makeText(context,"${it.exception!!.message}",Toast.LENGTH_LONG).show()
            }
        }

    }
    fun logout(){
        mAuth.signOut()
        navController.navigate(ROUTE_LOGIN)
    }
    //    Function to check if user is logged in
    fun loggedin():Boolean{
        return mAuth.currentUser!=null
    }
}