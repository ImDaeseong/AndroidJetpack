package com.daeseong.qrgooglezxing_test

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.content.ContextCompat
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.rememberPermissionState
import com.journeyapps.barcodescanner.BarcodeCallback
import com.journeyapps.barcodescanner.BarcodeResult
import com.journeyapps.barcodescanner.DecoratedBarcodeView

class QR2Activity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            Test2()
        }
    }
}

@Composable
fun QRCodeScanner(context: Context, modifier: Modifier = Modifier, onQRCodeScanned: (String) -> Unit) {

    val scannerView = remember {

        DecoratedBarcodeView(context).apply {

            decodeContinuous(object : BarcodeCallback {

                override fun barcodeResult(result: BarcodeResult?) {

                    result?.text?.let { qrCodeText ->

                        onQRCodeScanned(qrCodeText)
                    }
                }

                override fun possibleResultPoints(resultPoints: MutableList<com.google.zxing.ResultPoint>?) {

                }
            })
        }
    }

    //Composable이 화면에 표시될 때 DisposableEffect 호출
    DisposableEffect(Unit) {

        if (ContextCompat.checkSelfPermission(context, Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED) {
            scannerView.resume()
        }

        onDispose {
            //Composable이 화면에서 사라질 때(뷰가 제거될 때) 실행
            scannerView.pause()
        }
    }

    AndroidView(
        modifier = modifier,
        factory = { scannerView }
    )
}

@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun Test2() {

    val context = LocalContext.current

    var qrCodeText by remember { mutableStateOf("") }

    val permissionState = rememberPermissionState(permission = Manifest.permission.CAMERA)

    val scannerActive = permissionState.hasPermission

    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center)
    {
        if (scannerActive) {

            if (qrCodeText.isNotEmpty()) {

                Text(text = "결과값: $qrCodeText")

            } else {

                val displayMetrics = context.resources.displayMetrics
                val screenWidth = displayMetrics.widthPixels / displayMetrics.density
                val screenHeight = displayMetrics.heightPixels / displayMetrics.density
                val scannerSize = with(LocalDensity.current) { (minOf(screenWidth, screenHeight) * 0.7).dp }

                QRCodeScanner(context, modifier = Modifier.size(scannerSize)) { scannedText ->
                    qrCodeText = scannedText
                }
            }

        } else {

            Button(
                onClick = {
                    if (!permissionState.hasPermission) {
                        permissionState.launchPermissionRequest()
                    }
                })
            {
                Text("카메라 권한 요청")
            }
        }
    }
}