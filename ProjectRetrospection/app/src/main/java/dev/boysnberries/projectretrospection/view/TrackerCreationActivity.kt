package dev.boysnberries.projectretrospection.view

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.LinearLayout
import dev.boysnberries.projectretrospection.R
import dev.boysnberries.projectretrospection.data.database.entity.Question
import dev.boysnberries.projectretrospection.data.samples.getQuestions

// TODO: This is also copy & paste programming
// It should also be abstracted. The notion should be something like a card view.
class TrackerCreationActivity : Activity() {
    public val OPEN_QUESTION_KEY: String = "OPEN_QUESTION"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tracker_creation)

        val questions = this.loadQuestions()
        val questionsView = findViewById<RecyclerView>(R.id.recycler_questions)
        questionsView.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL, false)
        questionsView.adapter = QuestionAdapter(
                questions = questions,
                onClickCallback = {
                    val idx = questionsView.indexOfChild(it)
                    this.openQuestionEditor(questions[idx])
                }
        )
    }

    private fun loadQuestions(): List<Question> {
        return getQuestions()
    }

    private fun openQuestionEditor(question: Question) {
        val intent = Intent(this, QuestionCreationActivity::class.java)
        intent.putExtra(OPEN_QUESTION_KEY, question)
        this.startActivity(intent)
    }
}