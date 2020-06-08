package com.example.learningproject.RecylerAdapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView
import androidx.recyclerview.widget.RecyclerView
import com.example.learningproject.R
import com.example.learningproject.model

class RecylerAdapter(var list : List<model>) : RecyclerView.Adapter<RecylerAdapter.viewHodler>() {

    class viewHodler(itemView : View) : RecyclerView.ViewHolder(itemView){
        var title = itemView.findViewById<TextView>(R.id.title)
        var body = itemView.findViewById<TextView>(R.id.body)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHodler {
        return viewHodler(LayoutInflater.from(parent.context).inflate(R.layout.posts_rows_layout,parent,false))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: viewHodler, position: Int) {
       val postList = list[position]
        holder.title.text = postList.title
        holder.body.text  = postList.body
    }
}