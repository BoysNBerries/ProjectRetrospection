package dev.boysnberries.projectretrospection.view

import android.view.View
import android.widget.TextView
import dev.boysnberries.projectretrospection.R
import dev.boysnberries.projectretrospection.data.database.entity.Tracker

class TrackerAdapter(private val trackers: List<Tracker>, val onClickCallback: (View) -> Unit) :
        ClickableItemsAdapter<Tracker, TrackerAdapter.ViewHolder>(trackers, R.layout.item_tracker) {

    override fun assignToHolderViews(holder: ViewHolder, position: Int) {
        holder.trackerTitle.text = trackers[position].title
        holder.trackerDescription.text = trackers[position].description
    }

    override fun getViewHolder(view: View): ViewHolder {
        return ViewHolder(view, onClickCallback)
    }

    class ViewHolder(itemView: View, onClickCallback: (View) -> Unit) :
            ClickableItemsViewHolder(itemView, onClickCallback) {
        // TODO: I don't quite understand this warning but I'm sure it's important
        val trackerTitle = itemView.findViewById<TextView>(R.id.text_tracker_title)
        val trackerDescription = itemView.findViewById<TextView>(R.id.text_tracker_description)

    }
}
