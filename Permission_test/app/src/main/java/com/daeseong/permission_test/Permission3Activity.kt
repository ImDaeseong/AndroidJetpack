package com.daeseong.permission_test

import android.Manifest
import android.graphics.Bitmap
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.result.launch
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.daeseong.permission_test.ui.theme.Permission_testTheme
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.rememberPermissionState
import java.util.*

class Permission3Activity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Permission_testTheme {
                Test3()
            }
        }
    }
}

@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun Test3() {

    Surface(modifier = Modifier.fillMaxSize(), color = Color.Gray)
    {
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(10.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally)
        {
            val context = LocalContext.current

            val permissionSingleState = rememberPermissionState(Manifest.permission.CAMERA)

            val result = rememberSaveable { mutableStateOf<Bitmap?>(null) }

            val imgLauncher = rememberLauncherForActivityResult(ActivityResultContracts.TakePicturePreview()) { bitmap ->
                if (bitmap != null) {
                    result.value = bitmap
                }
            }

            // 권한
            var permissionLauncher = rememberLauncherForActivityResult(ActivityResultContracts.RequestPermission()) { isGranted: Boolean ->
                if (isGranted) {
                    imgLauncher.launch()
                } else {
                    Toast.makeText(context, "권한 거부", Toast.LENGTH_SHORT).show()
                }
            }

            Button(
                modifier = Modifier
                    .size(150.dp)
                    .background(color = Color.Green, shape = CircleShape),
                onClick = {
                    if (permissionSingleState.hasPermission) {
                        imgLauncher.launch()
                    } else {
                        permissionLauncher.launch(Manifest.permission.CAMERA)
                    }
                })
            {
                Text(text = "확인", color = Color.White)
            }

            result.value?.let { image ->
                Image(image.asImageBitmap(),null, modifier = Modifier.size(200.dp) )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview4() {
    Permission_testTheme {
        Test3()
    }
}