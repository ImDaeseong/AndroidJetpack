package com.daeseong.text_test

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.daeseong.text_test.ui.theme.Text_testTheme

class Text2Activity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Text_testTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally)
                    {
                        Test2()
                    }
                }
            }
        }
    }
}

@Composable
fun setTextColor1(value : String){

    val spannablestring = buildAnnotatedString {
        append(value)
        addStyle(style = SpanStyle(color = Color.Red), start = 0, end = 2)
        addStyle(style = SpanStyle(color = Color.Magenta), start = 3, end = 5)
        addStyle(style = SpanStyle(color = Color.Cyan), start = 6, end = 10)
    }

    Text(text = spannablestring,
        style = TextStyle(
            fontSize = 20.sp,
            fontStyle = FontStyle.Italic,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )
    )
}

@Composable
fun setTextColor2(value : String){

    val spannablestring = buildAnnotatedString {
        append(value)
        addStyle(style = SpanStyle(color = Color.Red), start = 0, end = 1)
        addStyle(style = SpanStyle(color = Color.Magenta), start = 3, end = 4)
        addStyle(style = SpanStyle(color = Color.Cyan), start = 6, end = 9)
    }

    Text(text = spannablestring,
        style = TextStyle(
            fontSize = 20.sp,
            fontStyle = FontStyle.Italic,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )
    )
}

@Preview
@Composable
fun Test2() {

    setTextColor1("제목 색상 변경 1")
    setTextColor1("ab cd ef 1")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview3() {
    Text_testTheme {
        Test2()
    }
}