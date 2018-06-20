package dev.boysnberries.projectretrospection.data.samples

import dev.boysnberries.projectretrospection.data.database.entity.Question
import dev.boysnberries.projectretrospection.data.database.entity.QuestionType
import dev.boysnberries.projectretrospection.data.database.entity.Tracker

/**
 * Created by John on 6/18/2018.
 */
fun getQuestions() = listOf(
        Question(
                1,
                0,
                1,
                "Was I wearing a hat at the time the person decided to sit next to me?",
                1
        ),
        Question(
                2,
                0,
                1,
                "Was I wet from the rain?",
                3
        ),
        Question(
                3,
                0,
                1,
                "What time of day was it?",
                2
        )
)
