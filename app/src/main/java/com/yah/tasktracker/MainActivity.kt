package com.yah.tasktracker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val useredittext = findViewById<EditText>(R.id.useredittext)
        val dataset = mutableListOf<Datasource>()
        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        val adapter = ItemAdapter(dataset)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView

//        recyclerView.setHasFixedSize(true)

        findViewById<Button>(R.id.button).setOnClickListener{
            val stringUserTask = findViewById<EditText>(R.id.useredittext).text.toString()
            dataset.add(Datasource(stringUserTask)).toString()
            //when someone clicks button edit text will clear
            useredittext.getText().clear()
            adapter.notifyDataSetChanged()


        }

        //Swipe task to delete code
        val swipeToDeleteCallBack = object : SwipeToDeleteCallBack() {
            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
               val position = viewHolder.adapterPosition
                dataset.removeAt(position)
                adapter.notifyItemRemoved(position)
            }
        }
        //Here
        val itemTouchHelper = ItemTouchHelper(swipeToDeleteCallBack)
        itemTouchHelper.attachToRecyclerView(recyclerView)
    }


}



//        val textView: TextView = findViewById(R.id.textview)
//        textView.text = Datasource().loadAffirmations().size.toString()
