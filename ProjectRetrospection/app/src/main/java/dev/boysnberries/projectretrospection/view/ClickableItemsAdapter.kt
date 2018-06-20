package dev.boysnberries.projectretrospection.view

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

// TODO: This an abstraction that reduces boilerplate in the adapters we currently have.
// TODO: I'm not sure if it is *meaningful* abstraction, though.  Just wanted to get something
// TODO: written to play around with.
abstract class ClickableItemsAdapter<ItemType, ViewHolderType : ClickableItemsViewHolder>(
        private val items: List<ItemType>,
        val layout: Int
    ) : RecyclerView.Adapter<ViewHolderType>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderType {
        val view = LayoutInflater
                .from(parent.context)
                .inflate(layout, parent, false)
        return getViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolderType, position: Int) {
        assignToHolderViews(holder, position)
    }

    abstract fun assignToHolderViews(holder: ViewHolderType, position: Int)

    abstract fun getViewHolder(view: View) : ViewHolderType

}

abstract class ClickableItemsViewHolder(itemView: View, private val onClickCallback: (View) -> Unit) :
        RecyclerView.ViewHolder(itemView), View.OnClickListener {

    init {
        // TODO: is this warning okay?
        itemView.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        this.onClickCallback(v)
    }
}