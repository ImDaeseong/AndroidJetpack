package com.daeseong.lazycolumn_test

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.daeseong.lazycolumn_test.ui.theme.LazyColumn_testTheme

class Column4Activity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Test4()
        }
    }
}

data class colItem1(val id : Int, val item1 : String, val item2 : String, var isSelected : Boolean = false)

val col1Itemlist = listOf(
    colItem1(0,"item0", "item0-0"),
    colItem1(1,"item1", "item1-1"),
    colItem1(2,"item2", "item2-2"),
    colItem1(3,"item3", "item3-3"),
    colItem1(4,"item4", "item4-4"),
    colItem1(5,"item5", "item5-5"),
    colItem1(6,"item6", "item6-6"),
    colItem1(7,"item7", "item7-7"),
    colItem1(8,"item8", "item8-8"),
    colItem1(9,"item9", "item9-9"),
    colItem1(10,"item10", "item10-10")
)

@Composable
fun viewItem(item : colItem1){

    Card(elevation = 5.dp, modifier = Modifier.padding(10.dp)) {
        
        Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(10.dp)) {

            Image(imageVector = Icons.Filled.Person, contentDescription = "icon", Modifier.padding(10.dp))

            Column() {
                Text(text = item.item1, color = Color.Red)

                CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {
                    Text(text = item.item2)
                }
            }
        }
    }
}

@Composable
fun Test4() {

    LazyColumn(contentPadding = PaddingValues(vertical = 10.dp, horizontal = 10.dp) ){

        items(col1Itemlist) { item ->
            viewItem(item)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview5() {
    LazyColumn_testTheme {
        Test4()
    }
}
