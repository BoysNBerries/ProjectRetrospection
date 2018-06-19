package dev.boysnberries.projectretrospection.data.samples

import dev.boysnberries.projectretrospection.data.Question
import java.util.Date;

/**
 * Created by John on 6/18/2018.
 */
fun getQuestions() = listOf(
        Question(
               1,
               "Wearing hat or not?",
               "Was I wearing a hat at the time the person decided to sit next to me?",
                Date(2017, 6, 30),
                Date(2017, 8, 20)
        ),
        Question(
                2,
                "Was I wet?",
                "Was it raining outside recently, making me wet and unpleasant to sit by?",
                Date(2017, 6, 31),
                Date(2017, 6, 31)
        ),
        Question(
                3,
                "Time of day",
                "What time of day was it?",
                Date(2017, 6, 30),
                Date(2017, 6, 30)
        )
)
