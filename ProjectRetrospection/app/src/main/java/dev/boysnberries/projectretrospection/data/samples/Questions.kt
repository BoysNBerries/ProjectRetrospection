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
                Tracker(),
                QuestionType(1, "bool"),
               "Was I wearing a hat at the time the person decided to sit next to me?",
                1
        ),
        Question(
                2,
                Tracker(),
                QuestionType(1, "bool"),
                "Was I wet from the rain?",
                3
        ),
        Question(
                3,
                Tracker(),
                QuestionType(2, "categorical"),
                "What time of day was it?",
               2
        )
)
