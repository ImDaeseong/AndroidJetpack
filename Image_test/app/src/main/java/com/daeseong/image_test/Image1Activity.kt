package com.daeseong.image_test

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.daeseong.image_test.ui.theme.Image_testTheme

class Image1Activity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Test1()
        }
    }
}

@Composable
fun Test1() {

    val context = LocalContext.current

    Column(
        modifier = Modifier
            .background(color = Color.White)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally)
    {
        Image(
            modifier = Modifier
                .clickable {
                    Toast
                        .makeText(context, "Image1", Toast.LENGTH_SHORT)
                        .show()
                }
                .size(size = 100.dp)
                .border(width = 1.dp, color = Color.Gray),
            painter = painterResource(id = R.drawable.a),
            contentDescription = null)
        
        Spacer(modifier = Modifier.height(10.dp))

        Image(
            modifier = Modifier
                .clickable {
                    Toast
                        .makeText(context, "Image2", Toast.LENGTH_SHORT)
                        .show()
                }
                .size(size = 100.dp)
                .clip(shape = RoundedCornerShape(8.dp))
                .border(width = 1.dp, color = Color.Gray, shape = RoundedCornerShape(8.dp)),
            painter = painterResource(id = R.drawable.b),
            contentDescription = null,
            contentScale = ContentScale.FillBounds)


        Spacer(modifier = Modifier.height(10.dp))


        Image(
            modifier = Modifier
                .clickable {
                    Toast
                        .makeText(context, "Image3", Toast.LENGTH_SHORT)
                        .show()
                }
                .size(size = 200.dp)
                .clip(shape = CircleShape)
                .border(width = 1.dp, color = Color.Gray, shape = CircleShape),
            painter = painterResource(id = R.drawable.a),
            contentDescription = null)

        Spacer(modifier = Modifier.height(10.dp))


        Image(
            modifier = Modifier
                .clickable {
                    Toast
                        .makeText(context, "Image4", Toast.LENGTH_SHORT)
                        .show()
                }
                .size(size = 200.dp),
            painter = painterResource(id = R.drawable.a),
            colorFilter = ColorFilter.tint(Color.Black.copy(alpha = 0.5f), BlendMode.DstIn),
            contentDescription = null)

    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview2() {
    Image_testTheme {
        Test1()
    }
}