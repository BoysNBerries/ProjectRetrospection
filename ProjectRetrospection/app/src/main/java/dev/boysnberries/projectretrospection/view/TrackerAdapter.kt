package dev.boysnberries.projectretrospection.view

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import dev.boysnberries.projectretrospection.R
import dev.boysnberries.projectretrospection.data.Tracker

class TrackerAdapter(private val trackers: List<Tracker>, val onClickCallback: (View) -> Unit) : RecyclerView.Adapter<TrackerAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_tracker, parent, false)
        return ViewHolder(view, onClickCallback)
    }

    override fun getItemCount(): Int {
        return trackers.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.trackerName.text = trackers[position].name
        holder.trackerDescription.text = trackers[position].description
    }

    class ViewHolder(itemView: View, onClickCallback: (View) -> Unit) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
        // TODO: I don't quite understand this warning but I'm sure it's important
        val trackerName = itemView.findViewById<TextView>(R.id.text_tracker_name)
        val trackerDescription = itemView.findViewById<TextView>(R.id.text_tracker_description)
        private val onClickCallback: (View) -> Unit = onClickCallback

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View) {
            this.onClickCallback(v)
        }
    }
}
