package dev.boysnberries.projectretrospection.view

import android.app.Activity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.LinearLayout
import dev.boysnberries.projectretrospection.R
import dev.boysnberries.projectretrospection.data.Question
import dev.boysnberries.projectretrospection.data.samples.getQuestions
import dev.boysnberries.projectretrospection.data.samples.getTrackers

// TODO: This is also copy & paste programming
// It should also be abstracted. The notion should be something like a card view.
class TrackerCreationActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tracker_creation)

        val questions = this.loadQuestions()
        val questionsView = findViewById<RecyclerView>(R.id.recycler_questions)
        questionsView.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL, false)
        questionsView.adapter = QuestionAdapter(questions = questions)
    }

    private fun loadQuestions(): List<Question> {
        return getQuestions()
    }
}