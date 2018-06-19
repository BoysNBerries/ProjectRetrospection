/**
 * Created by Taylor Lanclos on 6/18/18
 */
package dev.boysnberries.projectretrospection.data.database.entity

import android.arch.persistence.room.*


@Entity(tableName = "numeric_answers")
data class NumericAnswer(
        @PrimaryKey(autoGenerate = true) val id: Long?,
        @Embedded val record: Record,
        @Embedded val question: Question,
        @ColumnInfo(name = "value") val value: Number
) {
    constructor() : this(null, Record(), Question(), 0)
}
