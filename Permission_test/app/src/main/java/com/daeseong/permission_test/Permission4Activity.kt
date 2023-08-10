package com.daeseong.permission_test

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat
import com.daeseong.permission_test.ui.theme.Permission_testTheme

class Permission4Activity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Permission_testTheme {
                Test4()
            }
        }
    }
}

@Composable
fun Test4() {

    Surface(modifier = Modifier.fillMaxSize(), color = Color.Gray)
    {
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(10.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally)
        {
            val context = LocalContext.current

            // 권한
            var permissionSingleLauncher = rememberLauncherForActivityResult(ActivityResultContracts.RequestPermission()) { isGranted: Boolean ->
                if (isGranted) {
                    Toast.makeText(context, "권한 있음", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(context, "권한 거부", Toast.LENGTH_SHORT).show()
                }
            }

            Button(
                modifier = Modifier
                    .width(150.dp)
                    .height(50.dp)
                    .background(color = Color.Green, shape = CircleShape),
                onClick = {
                    if (ContextCompat.checkSelfPermission(context, Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
                        Toast.makeText(context, "권한 있음", Toast.LENGTH_SHORT).show()
                    } else {
                        permissionSingleLauncher.launch(Manifest.permission.WRITE_EXTERNAL_STORAGE)
                    }
                })
            {
                Text(text = "file", color = Color.White)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview5() {
    Permission_testTheme {
        Test4()
    }
}