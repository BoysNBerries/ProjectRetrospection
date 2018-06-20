package dev.boysnberries.projectretrospection.view

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import dev.boysnberries.projectretrospection.R
import dev.boysnberries.projectretrospection.data.database.entity.Question

// TODO: This is copy & paste programming from TrackerAdapter.kt
//      We should find a meaningful abstraction for our adapters.
class QuestionAdapter(private val questions: List<Question>) : RecyclerView.Adapter<QuestionAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_question, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return questions.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.questionText.text = questions[position].questionText
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val questionText = itemView.findViewById<TextView>(R.id.text_question_text)
    }
}