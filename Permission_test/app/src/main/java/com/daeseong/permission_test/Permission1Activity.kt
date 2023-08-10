package com.daeseong.permission_test

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.background
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat
import com.daeseong.permission_test.ui.theme.Permission_testTheme
import android.Manifest
import android.content.pm.PackageManager
import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Surface
import androidx.compose.runtime.*
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.rememberMultiplePermissionsState

class Permission1Activity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Test1()
        }
    }
}

@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun Test1() {

    Surface(modifier = Modifier.fillMaxSize(), color = Color.Gray)
    {
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(10.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally)
        {
            val context = LocalContext.current

            val permissionMultiState = rememberMultiplePermissionsState(
                listOf(Manifest.permission.ACCESS_COARSE_LOCATION,
                    Manifest.permission.ACCESS_FINE_LOCATION)
            )

            // 권한
            var permissionSingleLauncher = rememberLauncherForActivityResult(ActivityResultContracts.RequestPermission()) { isGranted: Boolean ->
                if (isGranted) {
                    Toast.makeText(context, "권한 있음", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(context, "권한 거부", Toast.LENGTH_SHORT).show()
                }
            }

            //멀티 권한
            var permissionMultiLauncher = rememberLauncherForActivityResult(ActivityResultContracts.RequestMultiplePermissions()) { permissionMap  ->
                for ((key, isGranted) in permissionMap) {

                    println("$key $isGranted")

                    if(isGranted){

                    } else {

                    }
                }
            }

            Button(
                modifier = Modifier
                    .width(150.dp)
                    .height(50.dp)
                    .background(color = Color.Green, shape = CircleShape),
                onClick = {
                    if (ContextCompat.checkSelfPermission(context, Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED) {
                        Toast.makeText(context, "권한 있음", Toast.LENGTH_SHORT).show()
                    } else {
                        permissionSingleLauncher.launch(Manifest.permission.CAMERA)
                    }
                })
            {
                Text(text = "single", color = Color.White)
            }

            Spacer(modifier = Modifier.height(10.dp))

            Button(
                modifier = Modifier
                    .width(150.dp)
                    .height(50.dp)
                    .background(color = Color.Green, shape = CircleShape),
                onClick = {

                    if (permissionMultiState.allPermissionsGranted) {
                        Toast.makeText(context, "권한 있음", Toast.LENGTH_SHORT).show()
                    } else {
                        permissionMultiLauncher.launch(arrayOf(Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.ACCESS_FINE_LOCATION))
                    }
                })
            {
                Text(text = "multi", color = Color.White)
            }

        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview2() {
    Permission_testTheme {
        Test1()
    }
}