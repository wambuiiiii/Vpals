package com.joy.vpals.ui.theme.screens.RegisterScreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.joy.vpals.navigation.ROUTE_HOME
import com.joy.vpals.data.AuthviewModel
import com.joy.vpals.navigation.ROUTE_REGISTER

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegisterScreen(navController:NavHostController) {
    var email by remember { mutableStateOf(("")) }
    var pass by remember { mutableStateOf(("")) }
    var confpass by remember { mutableStateOf(("")) }
    var context= LocalContext.current
    Column (
        modifier= Modifier.fillMaxSize()
        .padding(16.dp),
    verticalArrangement = Arrangement.Center,
    horizontalAlignment = Alignment.CenterHorizontally


    )
    {
//        Text(
//            text = "Register Here!",
//            color = Color.Cyan,
//            fontFamily = FontFamily.Cursive,
//            fontSize = 40.sp
//        )

        Spacer(modifier= Modifier.height(19.dp))


        OutlinedTextField(
            value = email ,
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Email,
                    contentDescription = "emailIcon"
                )
            },
            label = { Text(text = "Enter Email Address", fontWeight = FontWeight.Bold)},
            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Next),
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            textStyle = LocalTextStyle.current.copy(
                color = MaterialTheme.colorScheme.background// Set text color to primary color
            ),
            onValueChange = {
                email=it
            }
        )

        Spacer(modifier= Modifier.height(19.dp))

        OutlinedTextField(
            value = pass ,
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Lock,
                    contentDescription = "emailIcon",
                    modifier = Modifier.weight(1f).then(
                        Modifier.padding(end = 4.dp).graphicsLayer(
                            scaleX = 1.2f, // Increase the scale to make it look bold
                            scaleY = 1.2f  // Increase the scale to make it look bold
                        )
                    )
                )
            },
            label = { Text(text = "Enter Password",fontWeight = FontWeight.Bold)},
            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Next),
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            textStyle = LocalTextStyle.current.copy(
                color = MaterialTheme.colorScheme.background// Set text color to primary color
            ),
            onValueChange = {
                pass=it
            }
        )

        Spacer(modifier= Modifier.height(19.dp))

        OutlinedTextField(
            value = confpass ,
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Lock,
                    contentDescription = "emailIcon"
                )
            },
            label = { Text(text = "Confirm Password",fontWeight = FontWeight.Bold)},
            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Next),
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            textStyle = LocalTextStyle.current.copy(
                color = MaterialTheme.colorScheme.background// Set text color to primary color
            ),
            onValueChange = {
                confpass=it
            }
        )

        Spacer(modifier= Modifier.height(19.dp))

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Button(
                onClick = {
                    var myregister = AuthviewModel(navController, context)
                    myregister.signup(email,pass,confpass)
                    navController.navigate(ROUTE_HOME)
                },

//                    if (isSignUp) {
//                        // Perform sign up action
//                    } else {
//                        // Perform login action
//                    }


                modifier = Modifier
                    .weight(1f)
            ) {
                Text("Sign Up")
            }
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier
                .padding(top = 16.dp)
        ) {
            Text(text = "Already have an account?")
            TextButton(
                onClick = {
                    navController.navigate(ROUTE_REGISTER)
                }
            ) {

                Text(text =   "Login")
            }
        }
    }

}
@Preview
@Composable
fun RegisterPreview() {
    RegisterScreen(rememberNavController())

}