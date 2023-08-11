package com.daeseong.bottomnavigation_test

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.daeseong.bottomnavigation_test.ui.theme.BottomNavigation_testTheme

class BottomMain4Activity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Test4()
        }
    }
}

@Composable
fun Banner(modifier: Modifier = Modifier){
    Box(modifier = modifier) {
        Image(painter = painterResource(id = R.drawable.b), contentDescription = null, contentScale = ContentScale.Crop, modifier = Modifier.height(200.dp))
        SearchBar()
    }
}

@Composable
fun SearchBar(modifier: Modifier = Modifier){

    var textState by remember { mutableStateOf(TextFieldValue()) }

    TextField(
        value = textState,
        onValueChange = { newValue ->
            textState = newValue
        },
        leadingIcon = {
            Icon(imageVector = Icons.Default.Search, contentDescription = null)
        },
        placeholder = {
            Text("Search")
        },
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = Color.Gray,
            disabledIndicatorColor = Color.Transparent,
            focusedIndicatorColor = Color.Red,
            unfocusedIndicatorColor = Color.Transparent),
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth()
            .heightIn(min = 50.dp)
            .clip(RoundedCornerShape(16.dp))
    )
}

@Composable
fun TopMenu2(title: String, modifier: Modifier = Modifier, content : @Composable () -> Unit) {
    
    Column(
        modifier
            .border(width = 1.dp, color = Color.Gray)
            .padding(10.dp)) {
        Text(
            text = title,
            style = MaterialTheme.typography.h5.copy(fontWeight = FontWeight.ExtraBold),
            modifier = modifier.padding(horizontal = 16.dp, vertical = 8.dp))
        content()
    }
}

@Composable
fun Home(modifier: Modifier = Modifier) {
    LazyRow(modifier = Modifier
        .fillMaxSize()
        .background(Color.Red)
        .height(100.dp)) {
    }
}

@Composable
fun Search(modifier: Modifier = Modifier) {
    LazyRow(modifier = Modifier
        .fillMaxSize()
        .background(Color.Blue)
        .height(100.dp)) {
    }
}

@Composable
fun Info(modifier: Modifier = Modifier) {
    LazyRow(modifier = Modifier
        .fillMaxSize()
        .background(Color.Yellow)
        .height(100.dp)) {
    }
}

@Composable
fun Settings(modifier: Modifier = Modifier) {
    LazyRow(modifier = Modifier
        .fillMaxSize()
        .background(Color.Green)
        .height(100.dp)) {
    }
}

@Composable
fun BottomMenu3(modifier: Modifier = Modifier) {

    val bottomMenuItems = listOf(
        MenuItem1(title = "Home", icon = Icons.Default.Home),
        MenuItem1(title = "Search", icon = Icons.Default.Search),
        MenuItem1(title = "Info", icon = Icons.Default.Info),
        MenuItem1(title = "Settings", icon = Icons.Default.Settings)
    )

    val selectedItemTitle = remember { mutableStateOf(bottomMenuItems[0].title) }

    BottomNavigation(modifier, backgroundColor = Color.Black, contentColor = Color.White) {
        bottomMenuItems.forEach { item ->
            BottomNavigationItem(
                icon = {
                    Icon(
                        imageVector = item.icon,
                        contentDescription = item.title,
                        modifier = Modifier.size(20.dp),
                        tint = if (item.title == selectedItemTitle.value) Color.Red else Color.Black
                    )
                },
                label = { Text(text = item.title) },
                selected = item.title == selectedItemTitle.value,
                onClick = {
                    selectedItemTitle.value = item.title
                },
                alwaysShowLabel = true,
                selectedContentColor = Color.Red,
                unselectedContentColor = Color.Gray
            )
        }
    }
}

@Composable
fun Test4() {

    Scaffold(bottomBar = { BottomMenu3() }) { padding ->

        Column(modifier = Modifier
            .verticalScroll(rememberScrollState())
            .padding(padding))
        {
            Banner()

            TopMenu2(
                title = "Home", content = { Home() }
            )

            TopMenu2(
                title = "Search", content = { Search() }
            )

            TopMenu2(
                title = "Info", content = { Info() }
            )

            TopMenu2(
                title = "Settings", content = { Settings() }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview4() {
    BottomNavigation_testTheme {
        Test4()
    }
}

data class MenuItem1(
    val title: String,
    val icon: ImageVector
)