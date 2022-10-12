package com.example.practice_taskmanager

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MessageWithImage(
                message = MessageVerified(
                    "All tasks completed",
                    "Nice work!"
                )
            )
        }
    }
}

data class MessageVerified(val workTrace:String, val workComment:String)

@Composable
fun MessageWithImage(message: MessageVerified){
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            painter = painterResource(
                id = R.drawable.ic_task_completed
            ),
            contentDescription = "good mark",
            contentScale = ContentScale.Inside,
            //modifier = Modifier.fillMaxHeight(),
            alignment = Alignment.Center
        )
        MessageWithText(
            message = MessageVerified(
                workTrace = message.workTrace,
                workComment = message.workComment
            )
        )
    }

}

@Composable
fun MessageWithText(message: MessageVerified){
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,

    ) {
        Text(
            text = message.workTrace,
            modifier = Modifier
                .padding(top=24.dp, bottom = 8.dp),
            fontSize = 26.sp
        )
        Text(
            text = message.workComment,
            modifier = Modifier,
            fontSize = 26.sp
        )
    }
}



@Preview(showBackground = true)
@Composable
fun PreviewMessage() {
    MessageWithImage(
        message = MessageVerified(
            "All tasks completed",
            "Nice work!"
        )
    )

}