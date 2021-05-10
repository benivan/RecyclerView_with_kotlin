package com.aiden.recyclerviewexample

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.aiden.recyclerviewexample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {


    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private val drawable by lazy {
        listOf(
            ResourcesCompat.getDrawable(resources, R.drawable.ic_android, null)!!,
            ResourcesCompat.getDrawable(resources, R.drawable.ic_free_breakfast, null)!!,
            ResourcesCompat.getDrawable(resources, R.drawable.ic_gif, null)!!,
            ResourcesCompat.getDrawable(resources, R.drawable.ic_house, null)!!,
        )
    }

    private val exampleList by lazy {
        generateList(100)
    }

    private val adapter by lazy {
        ExampleAdapter(exampleList) {
            onItemClick(it)
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(this)

        binding.fabAdd.setOnClickListener {
            insertIem()
        }
        binding.fabDelete.setOnClickListener {
            removeItem()
        }


    }


   private fun onItemClick(position: Int) {
        Toast.makeText(this, "Item $position clicked", Toast.LENGTH_SHORT).show()
        val clickedItem: ExampleItem = exampleList[position];
        clickedItem.text2 = "clicked"
        adapter.notifyItemChanged(position)
    }

    fun insertIem() {
        val index = 0;
        val newItem = ExampleItem(
            ResourcesCompat.getDrawable(resources, R.drawable.ic_insert, null),
            "New item at $index",
            "line two of the new item added at index $index"
        )
        exampleList.add(index, newItem)
        adapter.notifyItemInserted(index)
    }

    fun removeItem() {
        val index = 0;
        exampleList.removeAt(index)
        adapter.notifyItemRemoved(index)
    }


    private fun generateList(size: Int): ArrayList<ExampleItem> {
        val list = ArrayList<ExampleItem>()
        repeat(size) { i ->
            val item = ExampleItem(
                drawable[i % 4],
                "Test $i",
                "$i Detail line is here."
            )
            list += item
        }
        return list
    }


}
