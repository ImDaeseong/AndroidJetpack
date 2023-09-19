package com.daeseong.volley_test

import android.content.Context
import com.android.volley.*
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley

class GetRequestData(private val context: Context) {

    private val requestQueue: RequestQueue by lazy { Volley.newRequestQueue(context) }

    companion object {
        private var instance: GetRequestData? = null

        @Synchronized
        fun getInstance(context: Context): GetRequestData {
            if (instance == null) {
                instance = GetRequestData(context)
            }
            return instance!!
        }
    }

    fun clear() {
        requestQueue.cancelAll(context)
    }

    fun getData(sUrl: String, listener: Response.Listener<String>, errorListener: Response.ErrorListener) {
        val sr = StringRequest(Request.Method.GET, sUrl, listener, errorListener)
        sr.retryPolicy = DefaultRetryPolicy(10000, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT)
        sr.setShouldCache(false)
        requestQueue.add(sr)
    }

    fun getPostData(sUrl: String, listener: Response.Listener<String>, errorListener: Response.ErrorListener, vararg params: String) {
        val sr = object : StringRequest(Request.Method.POST, sUrl, listener, errorListener) {
            @Throws(AuthFailureError::class)
            override fun getParams(): Map<String, String> {
                val param = HashMap<String, String>()
                param["dobType"] = params[0]
                param["dsptcKsco"] = params[1]
                param["continent"] = params[2]
                param["showItemListCount"] = params[3]
                param["sepmt61"] = params[4]
                return param
            }
        }

        sr.retryPolicy = DefaultRetryPolicy(10000, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT)
        sr.setShouldCache(false)
        requestQueue.add(sr)
    }
}