package com.daeseong.permission_test

import android.Manifest
import android.content.Context
import android.location.Location
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
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.daeseong.permission_test.ui.theme.Permission_testTheme
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices

class Permission6Activity : ComponentActivity() {

    private lateinit var fusedLocationClient: FusedLocationProviderClient
    private var currentLocation: Location? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Test6()
        }
    }

    private fun getLoc(context: Context, callback: (Location) -> Unit) {

        fusedLocationClient = LocationServices.getFusedLocationProviderClient(context)

        try {
            val location = fusedLocationClient.lastLocation
            location.addOnSuccessListener { loc ->
                if (loc != null) {
                    callback(loc)
                }
            }
        } catch (e: SecurityException) {
        }
    }

    @Composable
    fun Test6() {

        Surface(modifier = Modifier.fillMaxSize(), color = Color.Gray)
        {
            Column(modifier = Modifier.fillMaxSize().padding(10.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally)
            {
                val context = LocalContext.current

                var permissionMultiLauncher = rememberLauncherForActivityResult(
                    contract = ActivityResultContracts.RequestMultiplePermissions(),
                    onResult = { permissionMap ->
                        if (permissionMap[Manifest.permission.ACCESS_COARSE_LOCATION] == true || permissionMap[Manifest.permission.ACCESS_FINE_LOCATION] == true) {
                            getLoc(context) { loc ->
                                currentLocation = loc
                                println("Location Latitude=${currentLocation!!.latitude} Longitude=${currentLocation!!.longitude}")
                            }
                        } else {
                            Toast.makeText(context, "권한 거부", Toast.LENGTH_SHORT).show()
                        }
                    }
                )

                Button(modifier = Modifier
                    .width(150.dp).height(50.dp).background(color = Color.Green, shape = CircleShape),
                    onClick = {
                        permissionMultiLauncher.launch(arrayOf(Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.ACCESS_FINE_LOCATION))
                    })
                {
                    Text(text = "확인", color = Color.White)
                }
            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun DefaultPreview7() {
        Permission_testTheme {
            Test6()
        }
    }
}
