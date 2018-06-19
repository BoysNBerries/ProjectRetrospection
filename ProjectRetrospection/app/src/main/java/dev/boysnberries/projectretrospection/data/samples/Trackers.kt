package dev.boysnberries.projectretrospection.data.samples

import dev.boysnberries.projectretrospection.data.Tracker
import java.util.*

/**
 * Created by John on 6/17/2018.
 */

fun getTrackers() = listOf(
        Tracker(
               1,
               "John's Hat Quest",
               "Am I creepier with a hat?",
                Date(2017, 6, 30),
                Date(2017, 8, 20)
        ),
        Tracker(
               2,
               "Taylor's Grey Shirt",
               "How many people are as delusional as Taylor?",
                Date(),
                Date()
        ),
        Tracker(
               3,
               "Jensen's Infernal Cat Car",
               "How many times is that freakin' cat on my car?",
                Date(2016, 1, 30),
                Date(2016, 2, 10)
        )
)
