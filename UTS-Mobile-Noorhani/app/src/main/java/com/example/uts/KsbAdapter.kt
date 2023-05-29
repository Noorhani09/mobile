package com.example.uts

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class KsbAdapter (private val context: Context, private val novel: List<KsbClass>, val listener: (KsbClass) -> Unit)
    : RecyclerView.Adapter<KsbAdapter.NovelViewHolder>(){
    class NovelViewHolder(view: View): RecyclerView.ViewHolder(view) {

        val ksbimg = view.findViewById<ImageView>(R.id.image)
        val ksbname = view.findViewById<TextView>(R.id.tv_name)
        val ksbdate = view.findViewById<TextView>(R.id.tv_date)
        val ksbauthor = view.findViewById<TextView>(R.id.tv_author)

        fun bindView(novel: KsbClass, listener: (KsbClass) -> Unit){
            ksbimg.setImageResource(novel.ksbimg)
            ksbname.text = novel.ksbname
            ksbdate.text = novel.ksbdate
            ksbauthor.text = novel.ksbauthor
            itemView.setOnClickListener{
                (listener(novel))
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NovelViewHolder {
        return NovelViewHolder(
            LayoutInflater.from(context).inflate(R.layout.item_view, parent, false)
        )
    }

    override fun onBindViewHolder(holder: NovelViewHolder, position: Int) {
        holder.bindView(novel[position], listener)
    }

    override fun getItemCount(): Int = novel.size

}