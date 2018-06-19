/**
 * Created by Taylor Lanclos on 6/18/18
 */
package dev.boysnberries.projectretrospection.data.database.entity

import android.arch.persistence.room.*


@Entity(tableName = "categorical_answers")
data class CategoricalAnswer(
        @PrimaryKey(autoGenerate = true) val id: Long?,
        @Embedded val record: Record,
        @Embedded val question: Question,
        @ColumnInfo(name = "value") val value: String
) {
    constructor() : this(null, Record(), Question(), "")
}
