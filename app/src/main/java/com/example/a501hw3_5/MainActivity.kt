package com.example.a501hw3_5

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
// Importing the custom M3 theme for my app
import com.example.a501hw3_5.ui.theme._501hw3_5Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // Wrapping everything in my app's theme, like we saw on slide 36.
            // This makes sure all the M3 components get the right colors and fonts.
            _501hw3_5Theme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    LoginFormScreen()
                }
            }
        }
    }
}

@Composable
fun LoginFormScreen() {
    // These `remember` blocks hold the text for my input fields.
    // It's how Compose keeps track of state.
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    // State for validation. Will set these to true if a field is empty.
    var isUsernameError by remember { mutableStateOf(false) }
    var isPasswordError by remember { mutableStateOf(false) }

    // Using a Column to stack everything vertically, just like on slide 8.
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 32.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Just a simple Text composable for the title.
        Text(
            text = "Login",
            // Styling the text using M3 typography from the theme (slides 39, 41).
            // This is better than hardcoding a font size.
            style = MaterialTheme.typography.headlineLarge,
            modifier = Modifier.padding(bottom = 32.dp)
        )

        // This is one of the basic input components mentioned on slide 43.
        OutlinedTextField(
            value = username,
            onValueChange = {
                username = it
                // If the user starts typing, get rid of the error message.
                if (isUsernameError) isUsernameError = false
            },
            label = { Text("Username") },
            modifier = Modifier.fillMaxWidth(),
            // When `isError` is true, M3 automatically uses the 'error' color from the theme (slide 38).
            isError = isUsernameError,
            singleLine = true,
            // This part shows the error message text only when there's an error.
            supportingText = {
                if (isUsernameError) {
                    Text("Username cannot be empty")
                }
            }
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Another TextField, but this one is for the password.
        OutlinedTextField(
            value = password,
            onValueChange = {
                password = it
                if (isPasswordError) isPasswordError = false
            },
            label = { Text("Password") },
            modifier = Modifier.fillMaxWidth(),
            isError = isPasswordError,
            singleLine = true,
            // This hides the password text with dots.
            visualTransformation = PasswordVisualTransformation(),
            // This tells the keyboard to be in password mode.
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            supportingText = {
                if (isPasswordError) {
                    Text("Password cannot be empty")
                }
            }
        )

        Spacer(modifier = Modifier.height(32.dp))

        // A standard M3 Button, also mentioned on slide 43.
        Button(
            onClick = {
                // This is the validation logic.
                // Just checking if the text fields are blank.
                isUsernameError = username.isBlank()
                isPasswordError = password.isBlank()
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Submit")
        }
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview() {
    _501hw3_5Theme {
        LoginFormScreen()
    }
}