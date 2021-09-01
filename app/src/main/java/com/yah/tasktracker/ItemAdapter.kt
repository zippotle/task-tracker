package com.yah.tasktracker

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ItemAdapter(
//    private val context: Context,
    private val dataset: MutableList<Datasource>
) : RecyclerView.Adapter<ItemAdapter.ViewHolder>() {

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder.
    // Each data item is just an Affirmation object.


    /**
     * Create new views (invoked by the layout manager)
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // create a new view
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        val items = inflater.inflate(R.layout.list_item, parent, false)
        return ViewHolder(items)
    }

    /**
     * Replace the contents of a view (invoked by the layout manager)
     */
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = dataset.get(position)
        holder.item_title.setText(item.item_title)
//Previously you set the affirmation's stringResourceId on to textView in the ItemViewHolder.
// Now set the affirmation item's imageResourceId onto the ImageView of the list item view.
    }

    /**
     * Return the size of your dataset (invoked by the layout manager)
     */
    override fun getItemCount(): Int{
        return dataset.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val item_title: TextView = itemView.findViewById<TextView>(R.id.item_title)
    }
}



