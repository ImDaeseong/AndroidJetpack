package com.daeseong.checkbox_test

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Checkbox
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.daeseong.checkbox_test.ui.theme.Checkbox_testTheme

class Checkbox2Activity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Test2()
        }
    }
}

@Composable
fun Test2() {

    val check1 = remember { mutableStateOf(true) }
    val check2 = remember { mutableStateOf(true) }
    val check3 = remember { mutableStateOf(false) }

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(10.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally)
    {
        checkLabel("check1", check1)
        checkLabel("check2", check2)
        checkLabel("check3", check3)
    }
}

@Composable
fun checkLabel(input : String, bCheck : MutableState<Boolean>) {

    Row(modifier = Modifier
        .clickable {
            bCheck.value = !bCheck.value
        }, verticalAlignment = Alignment.CenterVertically)
    {
        Checkbox(
            checked = bCheck.value,
            onCheckedChange = {
                bCheck.value = it
            }
        )

        Text( modifier = Modifier.padding(start = 8.dp), text = input)
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview3() {
    Checkbox_testTheme {
        Test2()
    }
}