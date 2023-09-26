import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.joy.vpals.R
import com.joy.vpals.data.FormViewModel
import com.joy.vpals.navigation.ROUTE_REGISTER


@OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class)
@Composable
fun UserForm(navController: NavHostController,formViewModel: FormViewModel){
    var officialname by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var phoneNo by remember { mutableStateOf("") }
    val context = LocalContext.current

    var description by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "APPLICATIONS",
            style = TextStyle(fontSize = 24.sp, fontWeight = FontWeight.Bold)
        )

//        Spacer(modifier = Modifier.height(16.dp))
//
//        BasicTextField(
//            value = searchText,
//            onValueChange = { searchText = it },
//            singleLine = true,
//            modifier = Modifier.fillMaxWidth()
//        )

        Spacer(modifier = Modifier.height(16.dp))


        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Text(
                text = "Tell us more about yourself",
                style = MaterialTheme.typography.bodyMedium,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 16.dp)
            )
            OutlinedTextField(
                value = officialname,
                onValueChange = { officialname = it },
                label = { Text("Fullname") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp)
            )
            Spacer(modifier = Modifier.height(16.dp))

            OutlinedTextField(
                value = email,
                onValueChange = { email = it },
                label = { Text("Enter your E-mail") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp)
            )

            Spacer(modifier = Modifier.height(16.dp))

            OutlinedTextField(
                value = phoneNo,
                onValueChange = { phoneNo = it },
                label = { Text("Phone Number") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp)
            )
            Spacer(modifier = Modifier.height(16.dp))
            OutlinedTextField(
                value = description,
                onValueChange = { description = it },
                label = { Text("Description") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp)
            )
            Spacer(modifier = Modifier.height(16.dp))


            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween, // Use SpaceBetween here
                modifier = Modifier
                    .fillMaxWidth() // Ensure the Row occupies the entire width
                    .padding(top = 16.dp)
            ) {
                Button(
                    onClick = {
                        formViewModel.formSubmit(officialname, email, phoneNo, description)
                    }
                ) {
                    Text(text = "Submit")
                }

                Spacer(modifier = Modifier.width(16.dp)) // Add space between the buttons

                Button(
                    onClick = {
                        formViewModel.formSubmit(officialname, email, phoneNo, description)
                    }
                ) {
                    Text(text = "Clear")
                }
            }
            Spacer(modifier = Modifier.height(20.dp))

//            Box(
//                modifier = Modifier
//                    .fillMaxSize()
//                    .padding(16.dp),
//                contentAlignment = Alignment.BottomCenter
//            ) {
//
//
//                // Floating action button with home icon
//                FloatingActionButton(
//                    onClick = {
//                        // Navigate to another page when the button is clicked
//                        navController.navigate("YourDestinationRoute")
//                    },
//
//                    modifier = Modifier
//
//                        .padding(16.dp),
//
//
//                    ) {
//                    Icon(
//                        painter = painterResource(id = R.drawable.img_5),
//                        contentDescription = "Home Icon"
//                    )
//                }
//            }


        }

        }}



