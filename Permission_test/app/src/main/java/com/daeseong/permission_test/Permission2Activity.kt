package com.daeseong.permission_test

import android.Manifest
import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.os.Environment
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.content.FileProvider
import coil.compose.rememberImagePainter
import com.daeseong.permission_test.ui.theme.Permission_testTheme
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.rememberPermissionState
import java.io.File
import java.text.SimpleDateFormat
import java.util.*

class Permission2Activity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Permission_testTheme {
                Test2()
            }
        }
    }
}

fun Context.createImageFile(): File {
    val timeStamp = SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault()).format(Date())
    val imageFileName = "JPEG_$timeStamp.jpg"
    val storageDir = getExternalFilesDir(Environment.DIRECTORY_PICTURES)
    return File.createTempFile(imageFileName, null, storageDir)
}

@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun Test2() {

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


            val file = context.createImageFile()
            val uri = FileProvider.getUriForFile(
                Objects.requireNonNull(context),
                BuildConfig.APPLICATION_ID + ".provider", file
            )

            var imgUri by remember { mutableStateOf<Uri>(Uri.EMPTY) }

            val imgLauncher = rememberLauncherForActivityResult(ActivityResultContracts.TakePicture()) {
                println(uri)
                imgUri = uri
            }


            // 권한
            var permissionLauncher = rememberLauncherForActivityResult(ActivityResultContracts.RequestPermission()) { isGranted: Boolean ->
                if (isGranted) {
                    imgLauncher.launch(uri)
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
                        imgLauncher.launch(uri)
                    } else {
                        permissionLauncher.launch(Manifest.permission.CAMERA)
                    }
                })
            {
                Text(text = "확인", color = Color.White)
            }

            Spacer(modifier = Modifier.height(20.dp))

            if (imgUri.path?.isNotEmpty() == true) {
                
                Image(modifier = Modifier
                    .size(200.dp)
                    .padding(10.dp),
                    painter = rememberImagePainter(imgUri), contentDescription = null)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview3() {
    Permission_testTheme {
        Test2()
    }
}