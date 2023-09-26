package com.joy.vpals.ui.theme.screens.LoginScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.joy.vpals.R
import com.joy.vpals.data.AuthviewModel
import com.joy.vpals.navigation.ROUTE_HOME
import com.joy.vpals.navigation.ROUTE_REGISTER
//import kotlin.coroutines.jvm.internal.CompletedContinuation.context

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(navController: NavHostController) {
    var name by remember { mutableStateOf(TextFieldValue("")) }
    var email by remember { mutableStateOf(TextFieldValue("")) }
    var pass by remember { mutableStateOf(TextFieldValue("")) }
    var context= LocalContext.current


    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.img),
            contentDescription = "Andy Rubin",
            modifier = Modifier.size(150.dp)

        )

//        OutlinedTextField(value = name,
//            label = { Text(text = "Enter Your Name") },
//            leadingIcon = {
//                Icon(
//                    imageVector = Icons.Default.Person,
//                    contentDescription = "emailIcon"
//                )
//            },
//            keyboardOptions = KeyboardOptions(
//                keyboardType = KeyboardType.Text,
//                imeAction = ImeAction.Next
//            ),
//            onValueChange = {
//                name = it
//            })

        OutlinedTextField(value = email,
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Email,
                    contentDescription = "emailIcon",
                    modifier = Modifier.weight(1f)
                )
            },
            label = { Text(text = "Email address",fontWeight = FontWeight.Bold) },
            placeholder = { Text(text = "Enter your e-mail",fontWeight = FontWeight.Bold) },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email,
                imeAction = ImeAction.Next
            ),
            textStyle = LocalTextStyle.current.copy(
                color = MaterialTheme.colorScheme.background// Set text color to primary color
            ),

            onValueChange = {
                email = it
            })
        OutlinedTextField(value = pass,
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Lock,
                    contentDescription = "emailIcon",
                    modifier = Modifier.weight(1f)
                )
            },
            label = { Text(text = "Password",fontWeight = FontWeight.Bold) },
            placeholder = { Text(text = "Enter your password",fontWeight = FontWeight.Bold) },
            keyboardOptions = KeyboardOptions.Default.copy(

                imeAction = ImeAction.Next
            ),
            textStyle = LocalTextStyle.current.copy(
                color = MaterialTheme.colorScheme.background// Set text color to primary color
            ),

            onValueChange = {
                pass = it
            })
        Spacer(modifier= Modifier.height(19.dp))
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Button(
                onClick = {
                    val mylogin=AuthviewModel(navController, context)
                    mylogin.login(email.text,pass.text)
                    navController.navigate(ROUTE_HOME)

//                    if (isSignUp) {
//                        // Perform sign up action
//                    } else {
//                        // Perform login action
//                    }

                },
                shape= RoundedCornerShape(20.dp),
                modifier = Modifier
                    .weight(1f)

                        .width(120.dp),

            ) {
                Text( "Log In")
            }
        }

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier
                .padding(top = 16.dp)
        ) {
            Text(text = "Don't have an account?")
            TextButton(

                onClick = {
                    navController.navigate(ROUTE_REGISTER)
                }
            ) {

                Text(text =   "Sign Up")
            }
        }


    }}




@Preview(showBackground = true)
@Composable
fun LoginPreview() {
    LoginScreen(rememberNavController())


}