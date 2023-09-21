package com.daeseong.kakao_v2_test

import android.content.ContentValues.TAG
import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.daeseong.kakao_v2_test.ui.theme.Kakao_v2_testTheme
import com.kakao.sdk.auth.model.OAuthToken
import com.kakao.sdk.share.ShareClient
import com.kakao.sdk.template.model.*
import com.kakao.sdk.user.UserApiClient
import com.kakao.sdk.user.model.AccessTokenInfo
import com.kakao.sdk.user.model.User

class MainActivity : ComponentActivity() {

    private val TAG = MainActivity::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background)
            {
                Buttons()
            }
        }
    }

    companion object {

        private fun kakaoCallback(): (OAuthToken?, Throwable?) -> Unit {
            return { token, error ->
                token?.let {
                    if (it.idToken != null) {
                        // Handle ID token
                    } else if (it.accessToken != null) {
                        // Handle access token
                    }
                    LoginInfo()
                }
            }
        }

        fun kakaologin(context: Context) {

            if (UserApiClient.instance.isKakaoTalkLoginAvailable(context)) {
                Log.e(TAG, "kakao 설치")
                UserApiClient.instance.loginWithKakaoTalk(context, callback = kakaoCallback())
            } else {
                Log.e(TAG, "kakao 미설치")
                UserApiClient.instance.loginWithKakaoAccount(context, callback = kakaoCallback())
            }
        }

        fun LoginInfo() {

            UserApiClient.instance.me { user: User?, throwable: Throwable? ->

                if (user != null) {
                    try {
                        Log.e(TAG, "getId : " + user.id)
                        Log.e(TAG, "getNickname : " + user?.kakaoAccount?.profile?.nickname);
                        Log.e(TAG, "getEmail : " + user.kakaoAccount?.email)
                        Log.e(TAG, "getGender : " + user.kakaoAccount?.gender)
                        Log.e(TAG, "getAgeRange : " + user.kakaoAccount?.ageRange)
                        Log.e(
                            TAG,
                            "getProfileImageUrl : " + user?.kakaoAccount?.profile?.profileImageUrl
                        )
                        Log.e(TAG, "카카오 로그인 성공")
                    } catch (ex: Exception) {
                        Log.e(TAG, ex.message.toString())
                    }
                } else {
                    Log.e(TAG, "카카오 로그인 실패: ", throwable)
                }
            }
        }

        fun kakaologout() {

            UserApiClient.instance.logout { throwable: Throwable? ->

                if (throwable != null) {
                    Log.e(TAG, "kakao 로그아웃 실패")
                } else {
                    Log.e(TAG, "kakao 로그아웃 성공")
                }
            }
        }

        fun kakaoTokenInfo() {

            UserApiClient.instance.accessTokenInfo { accessTokenInfo: AccessTokenInfo?, throwable: Throwable? ->

                if (throwable != null) {
                    Log.e(TAG, "kakao 토큰 정보 호출 실패")
                } else if (accessTokenInfo != null) {
                    Log.e(TAG, "getId:" + accessTokenInfo.id)
                    Log.e(TAG, "만료시간:" + accessTokenInfo.expiresIn)
                }
            }
        }

        fun kakaounReg() {

            UserApiClient.instance.unlink { throwable: Throwable? ->

                if (throwable != null) {
                    Log.e(TAG, "kakao 토큰 회원탈퇴 실패")
                } else {
                    Log.e(TAG, "kakao 토큰 회원탈퇴 성공")
                }
            }
        }

        fun kakaolink(context: Context) {

            if (!ShareClient.instance.isKakaoTalkSharingAvailable(context))
                return

            val title = "제목"
            val imgUrl = "https://cdn.pixabay.com/photo/2015/07/14/18/14/school-845196_960_720.png"
            val desc = "설명"
            val linkUrl = "https://www.google.com"

            val content = Content(title, imgUrl, Link(linkUrl, linkUrl), desc)
            val itemContent = ItemContent()
            val social = Social()

            val button = com.kakao.sdk.template.model.Button("자세히 보기", Link(linkUrl, linkUrl))
            val buttons = arrayOf(button)

            val feedTemplate = FeedTemplate(content, itemContent, social, buttons.toList(), "버튼제목")

            ShareClient.instance.shareDefault(context, feedTemplate) { sharingResult, error ->
                if (error != null) {
                    Log.e(TAG, "카카오톡 공유 실패: $error")
                } else if (sharingResult != null) {
                    context.startActivity(sharingResult.intent)
                    Log.e(TAG, "${sharingResult.warningMsg}")
                    Log.e(TAG, "${sharingResult.argumentMsg}")
                    Log.e(TAG, "${sharingResult.warningMsg.size}")
                }
            }
        }
    }

}

@Composable
fun Buttons() {

    val context = LocalContext.current

    Column(modifier = Modifier.fillMaxSize().padding(16.dp), verticalArrangement = Arrangement.Center)
    {
        Button(modifier = Modifier.fillMaxWidth(),
            onClick = {
                MainActivity.kakaologin(context)
            })
        {
            Text(text = "button1")
        }

        Button(modifier = Modifier.fillMaxWidth(),
            onClick = {
                MainActivity.kakaologout()
            })
        {
            Text(text = "button2")
        }

        Button(modifier = Modifier.fillMaxWidth(),
            onClick = {
                MainActivity.kakaoTokenInfo()
            })
        {
            Text(text = "button3")
        }

        Button(modifier = Modifier.fillMaxWidth(),
            onClick = {
                MainActivity.kakaounReg()
            })
        {
            Text(text = "button4")
        }

        Button(modifier = Modifier.fillMaxWidth(),
            onClick = {
                MainActivity.kakaolink(context)
            })
        {
            Text(text = "button5")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Kakao_v2_testTheme {
        Buttons()
    }
}
