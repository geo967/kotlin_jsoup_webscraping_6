package com.example.jsoup6_indices_kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.jsoup6_indices_kotlin.adapter.RecyclerViewAdapter
import com.example.jsoup6_indices_kotlin.model.DataIndex
import kotlinx.android.synthetic.main.activity_main.*
import org.jsoup.Jsoup
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getWebInfo()
    }

    private fun getWebInfo() {
        thread{
            val indexList=ArrayList<DataIndex>()

         /*   val doc = Jsoup.connect("https://www.91mobiles.com/samsung-mobile-price-list-in-india#:~:text=Samsung%20Mobile%20Phones%20Price%20List%20%282021%29%20%20,%20Rs.%2023%2C499%20%206%20more%20rows%20")
                .timeout(60000).validateTLSCertificates(false).get()


            val indexGrid=doc.getElementsByClass("title_ul")
            val indexItems=indexGrid[0].getElementsByTag("li")

            val indexValueGrid=doc.getElementsByClass("price price_padding")

            for(i in 0 until indexValueGrid.size){
                val indexName=indexItems[i].text()
                    val indexPrice=indexValueGrid[i].text()
                    indexList.add(DataIndex(indexName,indexPrice))

            }*/
            val doc = Jsoup.connect("https://www.msn.com/en-in/money?ocid=winp1taskbar")
                .timeout(60000).validateTLSCertificates(false).get()


            val indexGrid=doc.getElementsByClass("cardQuotes-DS-EntryPoint1-1 disableQuoteLink-DS-EntryPoint1-1")
           // val indexItems=indexGrid[0].getElementsByTag("div")
            for(i in 0 until indexGrid.size){
                val indexName=indexGrid[i].text()
                val indexPrice="200"//indexItems[i].text()
                indexList.add(DataIndex(indexName,indexPrice))

            }

            //can't access UI elements from the background thread, so

            this.runOnUiThread {
                val recyclerViewAdapter= RecyclerViewAdapter(indexList,this)
                val linearLayoutManager= LinearLayoutManager(this)

                recyclerViewId.layoutManager=linearLayoutManager
                recyclerViewId.adapter=recyclerViewAdapter
            }

        }
    }
}