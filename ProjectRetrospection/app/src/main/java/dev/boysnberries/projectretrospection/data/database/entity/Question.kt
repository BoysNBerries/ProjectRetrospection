/**
 * Created by Taylor Lanclos on 6/18/18
 */
package dev.boysnberries.projectretrospection.data.database.entity

import android.arch.persistence.room.*
import java.io.Serializable


@Entity(tableName = "questions")
data class Question(
        @PrimaryKey(autoGenerate = true) val id: Long?,
        @Embedded val tracker: Tracker,
        @Embedded val questionType: QuestionType,
        @ColumnInfo(name = "question_text") val questionText: String,
        @ColumnInfo(name = "rank") val rank: Int
) : Serializable {
    constructor() : this(null, Tracker(), QuestionType(), "", 0)
}
