package dev.boysnberries.projectretrospection.data

import java.util.*

/**
 * Created by John on 6/17/2018.
 */
data class Tracker (
        val id: Int,
        val name: String,
        val description: String,
        val createdDate: Date,
        val updatedDate: Date
)
