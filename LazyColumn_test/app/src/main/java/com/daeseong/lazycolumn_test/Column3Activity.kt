package com.daeseong.lazycolumn_test

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.daeseong.lazycolumn_test.ui.theme.LazyColumn_testTheme
import com.daeseong.lazycolumn_test.ui.theme.colorLightGray

class Column3Activity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Test3()
        }
    }
}

data class colItem(
    val item1 : String,
    val item2 : String,
    val item3 : Int,
    @DrawableRes val id: Int
)

val colItemlist = mutableListOf<colItem>().apply {
    add(colItem("item1", "item1-1", 1, R.drawable.a))
    add(colItem("item2", "item2-1", 2, R.drawable.b))
    add(colItem("item3", "item3-1", 3, R.drawable.play))
    add(colItem("item4", "item4-1", 4, R.drawable.a))
    add(colItem("item5", "item5-1", 5, R.drawable.b))
    add(colItem("item6", "item6-1", 6, R.drawable.play))
    add(colItem("item7", "item7-1", 7, R.drawable.a))
    add(colItem("item8", "item8-1", 8, R.drawable.b))
    add(colItem("item9", "item9-1", 9, R.drawable.play))
    add(colItem("item10", "item10-1", 10, R.drawable.a))
}

@Composable
fun itemUI(item : colItem) {

    Column(modifier = Modifier.fillMaxWidth().background(Color.White))
    {
        Row(modifier = Modifier
            .padding(10.dp)
            .background(Color.LightGray, shape = RoundedCornerShape(10.dp)),
            verticalAlignment = Alignment.CenterVertically)
        {
            Box(modifier = Modifier.size(100.dp), contentAlignment = Alignment.Center)
            {
                Image(painter = painterResource(id = item.id), contentDescription = null, contentScale = ContentScale.Fit)

                Text(text = item.item1, Modifier.fillMaxWidth().padding(10.dp),
                    style = TextStyle( fontSize = 10.sp, textAlign = TextAlign.Center, color = Color.White),
                    maxLines = 1, overflow = TextOverflow.Ellipsis)
            }

            Text(text = item.item2, Modifier.fillMaxWidth().padding(10.dp),
                style = TextStyle( fontSize = 20.sp, textAlign = TextAlign.Start, color = Color.Blue),
                maxLines = 1, overflow = TextOverflow.Ellipsis)
        }
    }
}

@Composable
fun Test3() {

    LazyColumn(modifier = Modifier.background(color = colorLightGray())) {

        items(colItemlist) { item ->
            itemUI(item)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview4() {
    LazyColumn_testTheme {
        Test3()
    }
}
