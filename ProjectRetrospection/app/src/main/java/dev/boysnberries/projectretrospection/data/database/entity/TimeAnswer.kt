/**
 * Created by Taylor Lanclos on 6/18/18
 */
package dev.boysnberries.projectretrospection.data.database.entity

import android.arch.persistence.room.*
import org.threeten.bp.OffsetDateTime
import org.threeten.bp.ZoneOffset


@Entity(tableName = "time_answers", foreignKeys = [
    ForeignKey(
            entity = Record::class,
            parentColumns = ["id"],
            childColumns = ["record_id"],
            onDelete = ForeignKey.NO_ACTION
    ),
    ForeignKey(
            entity = Question::class,
            parentColumns = ["id"],
            childColumns = ["question_id"],
            onDelete = ForeignKey.NO_ACTION
    )
], indices = [
    Index(value = ["record_id", "question_id"], unique = true),
    Index(value = ["question_id"]),
    Index(value = ["record_id"])
])
data class TimeAnswer(
        @PrimaryKey(autoGenerate = true) var id: Long?,
        @ColumnInfo(name = "record_id") var recordID: Long,
        @ColumnInfo(name = "question_id") var questionID: Long,
        @ColumnInfo(name = "value") var value: OffsetDateTime
) {
    companion object {
        fun default() = TimeAnswer(null, Long.MAX_VALUE, Long.MAX_VALUE, OffsetDateTime.MIN)
    }
}
