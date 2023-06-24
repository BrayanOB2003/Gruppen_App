package com.project.gruppen.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.project.gruppen.R

@Preview
@Composable
fun LoginFuntion(){
    var passwordText by rememberSaveable { mutableStateOf("") }
    var emailText by rememberSaveable { mutableStateOf("") }
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
        ){
        TextFieldName(nameText = emailText, onNameChange = {emailText = it})
        Spacer(modifier = Modifier.height(20.dp))
        TextFieldEmail(emailText = emailText, onEmailChange ={emailText = it})
        Spacer(modifier = Modifier.height(20.dp))
        TextFieldPassword(passwordText = passwordText,  onPasswordChange = {passwordText = it})
        Spacer(modifier = Modifier.height(40.dp))
        Button(stringResource(id = R.string.register_button_text))
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextFieldEmail(emailText: String, onEmailChange: (String) -> Unit) {

    TextField(
        value = emailText,
        onValueChange = onEmailChange,
        label = { Text (
            stringResource(R.string.email_label)
        )
        },
        placeholder = { Text(
            stringResource(R.string.email_placeholder)
        )
        },
        leadingIcon = {
            Icon(painter = painterResource(R.mipmap.mail),
                contentDescription = stringResource(R.string.email_description),
                modifier = Modifier.size(25.dp))
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextFieldPassword(passwordText: String, onPasswordChange: (String) -> Unit) {
    var passwordHidden by rememberSaveable { mutableStateOf(true) }

    TextField(
        value = passwordText,
        onValueChange = onPasswordChange,
        label = {
            Text(
            stringResource(R.string.password_label)
            )
        },
        leadingIcon = {
            Icon(painter = painterResource(R.mipmap.padlock),
                contentDescription = stringResource(R.string.password_description),
                modifier = Modifier.size(25.dp)
            )
        },
        visualTransformation = if (passwordHidden) PasswordVisualTransformation() else VisualTransformation.None,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        trailingIcon = {
            IconButton(onClick = { passwordHidden = !passwordHidden }) {
                val visibilityIcon =
                    if (passwordHidden) Icons.Filled.Visibility else Icons.Filled.VisibilityOff
                val description = if (passwordHidden) stringResource(id = R.string.show_password_button_description)
                else stringResource(id = R.string.hide_password_button_description)
                Icon(imageVector = visibilityIcon, contentDescription = description)
            }
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextFieldName(nameText: String, onNameChange: (String) -> Unit){

    TextField(
        value = nameText,
        onValueChange = onNameChange,
        label = { Text (
            stringResource(R.string.name_label)
        )
        },
        leadingIcon = {
            Icon(painter = painterResource(R.mipmap.user),
                contentDescription = stringResource(R.string.name_description),
                modifier = Modifier.size(25.dp))
        }
    )
}

@Composable
fun Button(text: String){
    Button(onClick = {}, modifier = Modifier.size(width = 110.dp, height = 45.dp)) {
        Text(text)
    }
}