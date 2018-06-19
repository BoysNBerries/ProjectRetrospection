/**
 * Created by Taylor Lanclos on 6/18/18
 */
package dev.boysnberries.projectretrospection.data.database.entity

import android.arch.persistence.room.*


@Entity(tableName = "category_buckets")
data class CategoryBucket(
        @PrimaryKey(autoGenerate = true) val id: Long?,
        @Embedded val question: Question,
        @ColumnInfo(name = "allowed_value") val allowedValue: String,
        @ColumnInfo(name = "rank") val rank: Int?
) {
    constructor() : this(null, Question(), "", null)
}
