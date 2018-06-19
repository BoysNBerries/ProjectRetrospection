/**
 * Created by Taylor Lanclos on 6/18/18
 */
package dev.boysnberries.projectretrospection.data.database.entity

import android.arch.persistence.room.*
import org.threeten.bp.OffsetDateTime
import org.threeten.bp.ZoneOffset


@Entity(tableName = "trackers")
data class Tracker(
        @PrimaryKey(autoGenerate = true) val id: Long?,
        @ColumnInfo(name = "title") val title: String,
        @ColumnInfo(name = "description") val description: String,
        @ColumnInfo(name = "created_dts") val createdDTS: OffsetDateTime,
        @ColumnInfo(name = "updated_dts") val updatedDTS: OffsetDateTime,
        @ColumnInfo(name = "rank") val rank: Int
) {
    constructor() : this(
            null,
            "",
            "",
            OffsetDateTime.MIN,
            OffsetDateTime.MIN,
            0
    )
}
