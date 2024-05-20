package com.example.lab4_ph34649

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lab4_ph34649.ui.theme.Lab4_ph34649Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Lab4_ph34649Theme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    LoginScreen()
                }
            }
        }
    }

    @Composable
    fun LoginScreen() {
        val context = LocalContext.current
        var userName by remember { mutableStateOf("") }
        var password by remember { mutableStateOf("") }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            // Logo
            Image(
                painter = painterResource(id = R.drawable.ronaldo),
                contentDescription = "Logo"
            )
            Spacer(modifier = Modifier.height(20.dp))
            // Username TextField
            OutlinedTextField(
                value = userName,
                onValueChange = { userName = it },
                label = { Text("Username") }
            )
            Spacer(modifier = Modifier.height(8.dp))
            // Password TextField
            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                label = { Text("Password") },
                visualTransformation = PasswordVisualTransformation()
            )
            Spacer(modifier = Modifier.height(16.dp))
            // Login Button
            Button(
                onClick = {
                    if (userName.isNotBlank() && password.isNotBlank()) {
                        Toast.makeText(context, "Login successful", Toast.LENGTH_LONG).show()
                    } else {
                        Toast.makeText(context, "Please enter username and password", Toast.LENGTH_LONG).show()
                    }
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.DarkGray,
                    contentColor = Color.White
                )
            ) {
                Text("Login")
            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun PreviewLoginScreen() {
        Lab4_ph34649Theme {
            LoginScreen()
        }
    }
}
