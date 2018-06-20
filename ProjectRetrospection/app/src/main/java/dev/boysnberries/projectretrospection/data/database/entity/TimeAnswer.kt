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
            childColumns = ["recordID"],
            onDelete = ForeignKey.NO_ACTION
    ),
    ForeignKey(
            entity = Question::class,
            parentColumns = ["id"],
            childColumns = ["questionID"],
            onDelete = ForeignKey.NO_ACTION
    )
])
data class TimeAnswer(
        @PrimaryKey(autoGenerate = true) val id: Long?,
        val recordID: Long,
        val questionID: Long,
        @ColumnInfo(name = "value") val value: OffsetDateTime
) {
    constructor() : this(null, Long.MAX_VALUE, Long.MAX_VALUE, OffsetDateTime.MIN)
}
