package com.aiden.recyclerviewexample

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.aiden.recyclerviewexample.databinding.ExampleItemBinding


class ExampleAdapter(
    private val exampleList: List<ExampleItem>,
    private val listener: (Int) -> Unit
) :
    RecyclerView.Adapter<ExampleAdapter.ExampleViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExampleViewHolder {

        val itemBinding =
            ExampleItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ExampleViewHolder(itemBinding)
    }


    override fun onBindViewHolder(holder: ExampleViewHolder, position: Int) {
        val currentItem = exampleList[position]
        holder.bind(currentItem) {
            listener(position)
        }
    }


    override fun getItemCount(): Int {
        return exampleList.size
    }


    inner class ExampleViewHolder(private val itemBinding: ExampleItemBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(item: ExampleItem, onClick: () -> Unit) {
            itemBinding.tvHeading.text = item.text1
            itemBinding.tvDetails.text = item.text2
            itemBinding.ivPicture.setImageDrawable(item.imageResource)
            itemBinding.root.setOnClickListener {
                onClick()
            }
        }

    }


}

