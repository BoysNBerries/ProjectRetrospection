/**
 * Created by Taylor Lanclos on 6/18/18
 */
package dev.boysnberries.projectretrospection.data.database.entity

import android.arch.persistence.room.*


@Entity(tableName = "category_buckets", foreignKeys = [
    ForeignKey(
            entity = Question::class,
            parentColumns = ["id"],
            childColumns = ["question_id"],
            onDelete = ForeignKey.NO_ACTION
    )
], indices = [
    Index(value = ["question_id"])
])
data class CategoryBucket(
        @PrimaryKey(autoGenerate = true) val id: Long?,
        @ColumnInfo(name = "question_id") val questionID: Long,
        @ColumnInfo(name = "allowed_value") val allowedValue: String,
        @ColumnInfo(name = "rank") val rank: Int?
) {
    constructor() : this(null, Long.MAX_VALUE, "", null)
}
