package dev.boysnberries.projectretrospection.view

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import dev.boysnberries.projectretrospection.R

// TODO: trackers should be a list of some 'Tracker' type
class TrackerAdapter(private val trackers: List<String>) : RecyclerView.Adapter<TrackerAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_tracker, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return trackers.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // TODO: once trackers is a list of data objects instead of just strings, fix this
        holder.trackerName.text = trackers[position]
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        // TODO: I don't quite understand this warning but I'm sure it's important
        val trackerName = itemView.findViewById<TextView>(R.id.text_tracker_name)
    }
}
