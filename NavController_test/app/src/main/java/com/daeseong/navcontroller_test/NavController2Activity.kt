package com.daeseong.navcontroller_test

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.daeseong.navcontroller_test.ui.theme.NavController_testTheme
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState

class NavController2Activity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NavController_testTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background)
                {
                    Test2()
                }
            }
        }
    }
}

@Composable
fun Test2() {

    val navController = rememberNavController()
    
    NavHost(navController = navController, startDestination = "page4" )
    {
        composable("page4")
        {
            Page4Screen(navController)
        }

        composable("page5")
        {
            Page5Screen(navController)
        }
    }
}

@Composable
fun Page4Screen(navController : NavController) {

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "title1", color = Color.Red) },
                backgroundColor = Color.Gray,
                contentColor = Color.White,
                modifier = Modifier.clickable {
                    navController.navigate("page5")
                }
            )
        }) {   paddingValues ->

        Column(modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(paddingValues)
            .padding(horizontal = 10.dp))
        {
            Text(text = "subtitle", modifier = Modifier.padding(top=10.dp))

            LazyColumn()
            {
                item()
                {
                    Column(modifier = Modifier.wrapContentHeight(), verticalArrangement = Arrangement.SpaceBetween)
                    {
                        Row(modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentHeight(),
                            horizontalArrangement = Arrangement.spacedBy(10.dp),
                            verticalAlignment = Alignment.CenterVertically)
                        {
                            Text(text = "text1", color = Color.White, textAlign = TextAlign.Left, modifier = Modifier
                                .background(Color.Gray)
                                .wrapContentHeight()
                                .weight(10f))

                            Divider(modifier = Modifier
                                .height(20.dp)
                                .width(1.dp))
                            
                            IconButton(modifier = Modifier.aspectRatio(1f).weight(1f), onClick = {
                            }) {
                                Icon(imageVector = Icons.Filled.Refresh , contentDescription = "")
                            }
                        }
                    }
                }

                item()
                {
                    Column(modifier = Modifier.wrapContentHeight(), verticalArrangement = Arrangement.SpaceBetween)
                    {
                        Row(modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentHeight(),
                            horizontalArrangement = Arrangement.spacedBy(10.dp),
                            verticalAlignment = Alignment.CenterVertically)
                        {
                            Text(text = "text2", color = Color.White, textAlign = TextAlign.Left, modifier = Modifier
                                .background(Color.Gray)
                                .wrapContentHeight()
                                .weight(10f))

                            Divider(modifier = Modifier
                                .height(20.dp)
                                .width(1.dp))

                            IconButton(modifier = Modifier.aspectRatio(1f).weight(1f), onClick = {
                            }) {
                                Icon(imageVector = Icons.Filled.Refresh , contentDescription = "")
                            }
                        }
                    }
                }

            }

        }
    }
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun Page5Screen(navController : NavController) {

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "title2", color = Color.Red) },
                backgroundColor = Color.Gray,
                contentColor = Color.White,
                modifier = Modifier.clickable {
                    navController.navigate("page4")
                }
            )})
    { paddingValues ->

        Column(modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(paddingValues)
            .padding(horizontal = 10.dp))
        {
            val pageState = rememberPagerState()

            val list = listOf(
                R.drawable.e,
                R.drawable.f,
                R.drawable.g
            )

            HorizontalPager(
                count = list.size,
                state = pageState,
                contentPadding = PaddingValues(horizontal = 10.dp, vertical = 10.dp),
                modifier = Modifier
                    .height(300.dp)
                    .background(Color.LightGray))
            { index ->

                Card(modifier = Modifier.fillMaxWidth()
                    .padding(10.dp), shape = RoundedCornerShape(10.dp))
                {
                    Image(
                        painter = painterResource(id = list[index]),
                        contentDescription = null,
                        contentScale = ContentScale.Fit)
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview3() {
    NavController_testTheme {
        Test2()
    }
}