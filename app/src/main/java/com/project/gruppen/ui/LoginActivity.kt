package com.project.gruppen.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.project.gruppen.R

class LoginActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

        }
    }
}


@Preview
@Composable
fun preview(){
    Column{
        TextFieldEmail()
        TextFieldPassword()

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextFieldEmail() {
    var text by rememberSaveable { mutableStateOf("") }

    TextField(
        value = text,
        onValueChange = { text = it },
        label = { Text (
            stringResource(R.string.email_label))},
        placeholder = { Text(
            stringResource(R.string.email_placeholder))},
        leadingIcon = {
            Icon(painter = painterResource(R.mipmap.mail),
            contentDescription = stringResource(R.string.email_description),
            modifier = Modifier.size(25.dp))}
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextFieldPassword() {
    var text by rememberSaveable { mutableStateOf("") }
    var passwordHidden by rememberSaveable { mutableStateOf(true) }

    TextField(
        value = text,
        onValueChange = { text = it },label = {Text(
            stringResource(R.string.password_label))},
        leadingIcon = {
            Icon(painter = painterResource(R.mipmap.padlock),
                contentDescription = stringResource(R.string.password_description),
                modifier = Modifier.size(25.dp)
            )},
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