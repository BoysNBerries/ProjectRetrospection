/**
 * Created by Taylor Lanclos on 6/18/18
 */
package dev.boysnberries.projectretrospection.data.database.entity

import android.arch.persistence.room.*
import java.io.Serializable


@Entity(tableName = "questions", foreignKeys = [
    ForeignKey(
            entity = Tracker::class,
            parentColumns = ["id"],
            childColumns = ["trackerID"],
            onDelete = ForeignKey.NO_ACTION
    ),
    ForeignKey(
            entity = QuestionType::class,
            parentColumns = ["id"],
            childColumns = ["questionTypeID"],
            onDelete = ForeignKey.NO_ACTION
    )
])
data class Question(
        @PrimaryKey(autoGenerate = true) val id: Long?,
        val trackerID: Long,
        val questionTypeID: Long,
        @ColumnInfo(name = "question_text") val questionText: String,
        @ColumnInfo(name = "rank") val rank: Int
) : Serializable {
    constructor() : this(null, Long.MAX_VALUE, Long.MAX_VALUE, "", 0)
}
