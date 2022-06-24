package com.mcdonalds.ap

import android.content.Context
import com.mcdonalds.ap.Constant.CAMPL1
import com.mcdonalds.ap.Constant.DEEPL1
import com.orhanobut.hawk.Hawk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.jsoup.Jsoup

class JSo (val context: Context) {
    private var jsoup: String? = "null"
    private val hawk : String? = Hawk.get(CAMPL1)
    private val hawkAppLink: String? = Hawk.get(DEEPL1)

    private var forJsoupSetNaming: String = Constant.FilterURL + Constant.subber1 + hawk
    private var forJsoupSetAppLnk: String = Constant.FilterURL + Constant.subber1 + hawkAppLink
    suspend fun getDocSecretKey(): String?{
        withContext(Dispatchers.IO){
            if(hawk!=null) {
                val doc = Jsoup.connect(forJsoupSetNaming).get()
                jsoup = doc.text().toString()
            } else {
                val doc = Jsoup.connect(forJsoupSetAppLnk).get()
                jsoup = doc.text().toString()
            }
        }
        return jsoup
    }
}