package com.project.gruppen.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.project.gruppen.R
import com.project.gruppen.screens.components.ImageBackground


@Preview
@Composable
fun Register(){
    var nameText by rememberSaveable { mutableStateOf("") }
    var passwordText by rememberSaveable { mutableStateOf("") }
    var emailText by rememberSaveable { mutableStateOf("") }

    ImageBackground(drawableId = R.drawable.background1) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Text(stringResource(id = R.string.title_register),
                fontSize = 60.sp, fontFamily = FontFamily(Font(R.font.quicksand)),
                fontWeight = FontWeight.SemiBold, color = Color.White, textAlign = TextAlign.Center,
                maxLines = 2
            )
            Spacer(modifier = Modifier.height(30.dp))
            TextFieldName(nameText = nameText, onNameChange = {nameText = it})
            Spacer(modifier = Modifier.height(20.dp))
            TextFieldEmail(emailText = emailText, onEmailChange ={emailText = it})
            Spacer(modifier = Modifier.height(20.dp))
            TextFieldPassword(passwordText = passwordText,  onPasswordChange = {passwordText = it})
            Spacer(modifier = Modifier.height(40.dp))
            Button(stringResource(id = R.string.register_button_text))
        }
    }
}