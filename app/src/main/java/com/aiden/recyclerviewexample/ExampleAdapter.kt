package com.aiden.recyclerviewexample

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.aiden.recyclerviewexample.databinding.ExampleItemBinding


class ExampleAdapter(
    private val exampleList: List<ExampleItem>,
    private val listener: OnItemClickListener
) :
    RecyclerView.Adapter<ExampleAdapter.ExampleViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExampleViewHolder {

        val itemBinding =
            ExampleItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ExampleViewHolder(itemBinding)
    }



    override fun onBindViewHolder(holder: ExampleViewHolder, position: Int) {
        val currentItem = exampleList[position]
        holder.bind(currentItem,position)
    }



    override fun getItemCount(): Int {
        return exampleList.size
    }




    inner class ExampleViewHolder(private val itemBinding: ExampleItemBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {

        private var position:Int? = null

        fun bind(item: ExampleItem,position: Int) {
            this.position = position
            itemBinding.tvHeading.text = item.text1
            itemBinding.tvDetails.text = item.text2
            itemBinding.ivPicture.setImageDrawable(item.imageResource)

        }

//        init {
//            itemBinding.root.setOnClickListener(this)
//        }
//
//        override fun onClick(v: View?) {
//            val position = this.position
//            if (position != null) {
//                listener.onItemClick(position)
//            }
//        }


    }

//    interface OnItemClickListener {
//        fun onItemClick(position: Int)
//    }

}

