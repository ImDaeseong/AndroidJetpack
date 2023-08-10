package com.daeseong.permission_test

import android.Manifest
import android.os.Bundle
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
import com.daeseong.permission_test.ui.theme.Permission_testTheme

class Permission5Activity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Test5()
        }
    }
}

private fun isLocationPermission(result: Map<String, Boolean>): Boolean {
    return result[Manifest.permission.ACCESS_FINE_LOCATION] == true && result[Manifest.permission.ACCESS_COARSE_LOCATION] == true
}

private fun isCameraPermission(result: Map<String, Boolean>): Boolean {
    return result[Manifest.permission.CAMERA] == true
}

@Composable
fun Test5() {

    Surface(modifier = Modifier.fillMaxSize(), color = Color.Gray)
    {
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(10.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally)
        {
            val context = LocalContext.current

            var permissionMultiLauncher = rememberLauncherForActivityResult(
                contract = ActivityResultContracts.RequestMultiplePermissions(),
                onResult = { permissionMap  ->

                    if (isLocationPermission(permissionMap)) {
                        println("isLocationPermission")
                    }

                    if (isCameraPermission(permissionMap)) {
                        println("isCameraPermission")
                    }

                    for ((key, isGranted) in permissionMap) {
                        println("$key $isGranted")
                    }
                }
            )

            Button(
                modifier = Modifier
                    .width(150.dp)
                    .height(50.dp)
                    .background(color = Color.Green, shape = CircleShape),
                onClick = {
                    permissionMultiLauncher.launch(arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE,Manifest.permission.CAMERA,Manifest.permission.ACCESS_COARSE_LOCATION,Manifest.permission.ACCESS_FINE_LOCATION))
                })
            {
                Text(text = "확인", color = Color.White)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview6() {
    Permission_testTheme {
        Test5()
    }
}