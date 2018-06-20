package dev.boysnberries.projectretrospection.view

import android.view.View
import android.widget.TextView
import dev.boysnberries.projectretrospection.R
import dev.boysnberries.projectretrospection.data.database.entity.Question

class QuestionAdapter(private val questions: List<Question>, val onClickCallback: (View) -> Unit) :
        ClickableItemsAdapter<Question, QuestionAdapter.ViewHolder>(questions, R.layout.item_question) {

    override fun assignToHolderViews(holder: ViewHolder, position: Int) {
        holder.questionText.text = questions[position].questionText
    }

    override fun getViewHolder(view: View): ViewHolder {
        return ViewHolder(view, onClickCallback)
    }

    class ViewHolder(itemView: View, onClickCallback: (View) -> Unit) :
            ClickableItemsViewHolder(itemView, onClickCallback) {
        val questionText = itemView.findViewById<TextView>(R.id.text_question_text)
    }
}