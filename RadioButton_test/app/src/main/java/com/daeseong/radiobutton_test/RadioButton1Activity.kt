package com.daeseong.radiobutton_test

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectable
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.daeseong.radiobutton_test.ui.theme.RadioButton_testTheme

class RadioButton1Activity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RadioButton_testTheme {

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background)
                {

                    Column(
                        modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally)
                    {
                        Test1()
                    }
                }
            }
        }
    }
}

@Composable
fun RadioButton1() {

    val options = listOf("RadioButton1", "RadioButton2")
    var selected by remember { mutableStateOf(options[0]) }

    Row(
        Modifier
            .fillMaxWidth()
            .background(Color.Gray)
            .padding(10.dp)) {

        RadioButton(
            colors = RadioButtonDefaults.colors(selectedColor = Color.Red, unselectedColor = Color.Black, disabledColor = Color.LightGray),
            selected = selected == options[0],
            onClick = {
                selected = options[0]
            })

        Text(text = options[0], modifier = Modifier
            .padding(start = 10.dp, end = 10.dp)
            .align(Alignment.CenterVertically))

        RadioButton(
            colors = RadioButtonDefaults.colors(selectedColor = Color.Red, unselectedColor = Color.Black, disabledColor = Color.LightGray),
            selected = selected == options[1],
            onClick = {
                selected = options[1]
            })

        Text(text = options[1], modifier = Modifier
            .padding(start = 10.dp)
            .align(Alignment.CenterVertically))
    }
}

@Composable
fun RadioButton2() {

    val options = listOf("RadioButton1", "RadioButton2", "RadioButton3")
    val (selected, rowselected) = remember { mutableStateOf(options[0]) }

    Column {

        options.forEach { item ->

            Row(
                Modifier
                    .fillMaxWidth()
                    .background(Color.Gray)
                    .padding(10.dp)
                    .selectable(
                        selected = (item == selected),
                        onClick = {
                            rowselected(item)
                        }
                    )) {

                RadioButton(
                    colors = RadioButtonDefaults.colors(selectedColor = Color.Red, unselectedColor = Color.Black, disabledColor = Color.LightGray),
                    selected = (item == selected),
                    onClick = {
                        rowselected(item)
                    })

                Text(text = item, modifier = Modifier
                    .padding(start = 10.dp, end = 10.dp)
                    .align(Alignment.CenterVertically))
            }
        }
    }
}

@Composable
fun Test1() {

    RadioButton1()

    Spacer(modifier = Modifier.height(50.dp))

    RadioButton2()
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview2() {
    RadioButton_testTheme {
        Test1()
    }
}