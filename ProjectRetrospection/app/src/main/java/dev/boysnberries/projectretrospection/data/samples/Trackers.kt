package dev.boysnberries.projectretrospection.data.samples

import dev.boysnberries.projectretrospection.data.database.entity.Tracker
import org.threeten.bp.OffsetDateTime
import java.util.*

/**
 * Created by John on 6/17/2018.
 */

fun getTrackers() = listOf(
        Tracker(
               1,
               "John's Hat Quest",
               "Am I creepier with a hat?",
                OffsetDateTime.now(),
                OffsetDateTime.now(),
                1
        ),
        Tracker(
               2,
               "Taylor's Grey Shirt",
               "How many people are as delusional as Taylor?",
                OffsetDateTime.now().minusYears(2),
                OffsetDateTime.now().minusYears(1),
                2
        ),
        Tracker(
               3,
               "Jensen's Infernal Cat Car",
               "How many times is that freakin' cat on my car?",
                OffsetDateTime.now().minusYears(1),
                OffsetDateTime.now().minusYears(1),
                3
        )
)
