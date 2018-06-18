package dev.boysnberries.projectretrospection.view

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import dev.boysnberries.projectretrospection.R
import dev.boysnberries.projectretrospection.data.Tracker

class TrackerAdapter(private val trackers: List<Tracker>) : RecyclerView.Adapter<TrackerAdapter.ViewHolder>() {

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
        holder.trackerName.text = trackers[position].name
        holder.trackerDescription.text = trackers[position].description
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        // TODO: I don't quite understand these warnings but I'm sure they're important
        val trackerName = itemView.findViewById<TextView>(R.id.text_tracker_name)
        val trackerDescription = itemView.findViewById<TextView>(R.id.text_tracker_description)

    }
}
