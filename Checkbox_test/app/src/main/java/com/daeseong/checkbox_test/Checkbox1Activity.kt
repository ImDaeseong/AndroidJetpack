package com.daeseong.checkbox_test

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.daeseong.checkbox_test.ui.theme.Checkbox_testTheme

class Checkbox1Activity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column(modifier = Modifier.fillMaxSize()) {
                Column(
                    modifier = Modifier
                        .padding(top = 10.dp)
                        .padding(bottom = 10.dp)
                        .fillMaxSize(),
                    verticalArrangement = Arrangement.Top,
                    horizontalAlignment = Alignment.CenterHorizontally)
                {
                    Test1()
                }
            }
        }
    }
}

@Composable
fun checkUI1() {

    val checked = remember {  mutableStateOf(false) }

    Checkbox(checked = checked.value,
        onCheckedChange = { isChecked ->
            checked.value = isChecked
        },
        enabled = true
    )
}

@Composable
fun checkUI2() {

    val checked = remember {  mutableStateOf(false) }

    Checkbox(checked = checked.value,
        onCheckedChange = { isChecked ->
            checked.value = isChecked
        },
        enabled = false
    )
}

@Composable
fun checkUI3() {

    val checked = remember {  mutableStateOf(false) }

    Checkbox(checked = checked.value,
        onCheckedChange = { isChecked ->
            checked.value = isChecked
        },
        colors = CheckboxDefaults.colors(
            checkedColor = Color.Red,
            uncheckedColor = Color.Black,
            checkmarkColor = Color.White
        ),
        enabled = true
    )
}

@Composable
fun checkUI4() {

    val checked = remember {  mutableStateOf(false) }

    Row(verticalAlignment = Alignment.CenterVertically)
    {
        Checkbox(checked = checked.value,
            onCheckedChange = { isChecked ->
                checked.value = isChecked
            },
            colors = CheckboxDefaults.colors(
                checkedColor = Color.Red,
                uncheckedColor = Color.Black,
                checkmarkColor = Color.White
            )
        )

        Text(modifier = Modifier.align(Alignment.CenterVertically),
            text = "checkbox")
    }
}

@Composable
fun checkUI5() {

    val checklist = listOf("check1", "check2", "check3")

    checklist.forEach { items ->

        Row( modifier = Modifier.background(Color.White),
            verticalAlignment = Alignment.CenterVertically) {

            val checked = remember {  mutableStateOf(true) }

            Checkbox(checked = checked.value,
                onCheckedChange = { isChecked ->
                    checked.value = isChecked
                },
                colors = CheckboxDefaults.colors(
                    checkedColor = Color.Red,
                    uncheckedColor = Color.Black,
                    checkmarkColor = Color.White
                )
            )

            Text(modifier = Modifier.align(Alignment.CenterVertically),
                text = items)
        }

    }

}

@Composable
fun Test1() {

    checkUI1()

    Spacer(modifier = Modifier.height(10.dp))

    checkUI2()

    Spacer(modifier = Modifier.height(10.dp))

    checkUI3()

    Spacer(modifier = Modifier.height(10.dp))

    checkUI4()

    Spacer(modifier = Modifier.height(10.dp))

    checkUI5()
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview2() {
    Checkbox_testTheme {
        Test1()
    }
}