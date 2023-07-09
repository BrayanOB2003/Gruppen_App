package com.project.gruppen.screens.components

import android.widget.Toast
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.project.gruppen.R
import kotlinx.coroutines.launch

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
fun Button(text: String, onClick: () -> Unit){
    val buttonColors = ButtonDefaults.buttonColors(

        contentColor = colorResource(id = R.color.purple),
        containerColor = colorResource(id = R.color.soft_pink)
    )

    Button(onClick = onClick,
        modifier = Modifier.size(width = 120.dp, height = 55.dp),
        colors = buttonColors) {
        Text(text, fontSize = 17.sp)
    }
}

@Composable
fun CheckBox(isChecked: Boolean, onCheckedChange: (Boolean) -> Unit){

    val checkBoxColors = CheckboxDefaults.colors(

    )

    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Checkbox(
            checked = isChecked,
            onCheckedChange = onCheckedChange,
        )
        Text(stringResource(id = R.string.remember_button_text), color = colorResource(id = R.color.white))
    }
}

@Composable
fun ToastMessage(message: String) {

    val context  = LocalContext.current
    Toast.makeText(context,
        message,
        Toast.LENGTH_LONG).show()
}