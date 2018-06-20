/**
 * Created by Taylor Lanclos on 6/18/18
 */
package dev.boysnberries.projectretrospection.data.database.entity

import android.arch.persistence.room.*


@Entity(tableName = "boolean_answers", foreignKeys = [
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
])
data class BooleanAnswer(
        @PrimaryKey(autoGenerate = true) val id: Long?,
        @ColumnInfo(name = "record_id") val recordID: Long,
        @ColumnInfo(name = "question_id") val questionID: Long,
        @ColumnInfo(name = "value") val value: Boolean
) {
    constructor() : this(null, Long.MAX_VALUE, Long.MAX_VALUE, false)
}
