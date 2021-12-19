package com.example.jsoup6_indices_kotlin.adapter

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.jsoup6_indices_kotlin.R
import com.example.jsoup6_indices_kotlin.model.DataIndex
import kotlinx.android.synthetic.main.item_design.view.*

class RecyclerViewAdapter(private val indexList:List<DataIndex>,private val activity: Activity)
    :RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder>(){


    class MyViewHolder(v: View):RecyclerView.ViewHolder(v) {
        private val view:View=v

        fun bindSet(item: DataIndex) {
           view.indexId.text=item.name
            view.valueId.text=item.price
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.item_design,parent,false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item=indexList[position]
        holder.bindSet(item)
    }

    override fun getItemCount(): Int {
        return indexList.size
    }
}