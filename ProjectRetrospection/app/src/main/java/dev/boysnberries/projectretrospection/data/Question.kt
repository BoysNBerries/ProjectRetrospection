package dev.boysnberries.projectretrospection.data

import java.io.Serializable
import java.util.Date

/**
 * Created by John on 6/18/2018.
 */
data class Question (
        val id: Int,
        val title: String,
        val description: String,
        val createdDate: Date,
        val updatedDate: Date
) : Serializable
