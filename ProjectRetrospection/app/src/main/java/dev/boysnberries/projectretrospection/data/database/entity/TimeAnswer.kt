/**
 * Created by Taylor Lanclos on 6/18/18
 */
package dev.boysnberries.projectretrospection.data.database.entity

import android.arch.persistence.room.*
import org.threeten.bp.OffsetDateTime
import org.threeten.bp.ZoneOffset


@Entity(tableName = "time_answers")
data class TimeAnswer(
        @PrimaryKey(autoGenerate = true) val id: Long?,
        @Embedded val record: Record,
        @Embedded val question: Question,
        @ColumnInfo(name = "value") val value: OffsetDateTime
) {
    constructor() : this(null, Record(), Question(), OffsetDateTime.MIN)
}
