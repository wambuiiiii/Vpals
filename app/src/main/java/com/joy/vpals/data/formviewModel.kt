package com.joy.vpals.data




import android.widget.Toast
import androidx.navigation.NavController

import com.google.firebase.database.FirebaseDatabase
import com.joy.vpals.MainActivity
import com.joy.vpals.models.UserInfo
import com.joy.vpals.navigation.ROUTE_HOME


class FormViewModel(var navController: NavController, var context: MainActivity) {

    fun formSubmit(officialname: String, email: String, phoneNo: String, description: String) {
        if (officialname.isNotEmpty() && email.isNotEmpty() && phoneNo!= null && description.isNotEmpty()) {
            val formsRef = FirebaseDatabase.getInstance().getReference("Forms")
            val formKey = formsRef.push().key
            val form = UserInfo(officialname,email,phoneNo,description)
            formsRef.child(formKey!!).setValue(form).addOnCompleteListener {
                if (it.isSuccessful) {
                    Toast.makeText(context, "Form submitted successfully", Toast.LENGTH_SHORT).show()
                    navController.navigate(ROUTE_HOME)
                } else {
                    Toast.makeText(context, "Error submitting form", Toast.LENGTH_SHORT).show()
                }
            }

        } else {
            Toast.makeText(context, "Please fill out all fields", Toast.LENGTH_SHORT).show()
        }
    }
}


