/**
 * Created by Taylor Lanclos on 6/18/18
 */
package dev.boysnberries.projectretrospection.data.database.entity

import android.arch.persistence.room.*
import org.threeten.bp.OffsetDateTime
import java.io.Serializable


@Entity(tableName = "trackers")
data class Tracker(
        @PrimaryKey(autoGenerate = true) var id: Long?,
        @ColumnInfo(name = "title") var title: String,
        @ColumnInfo(name = "description") var description: String,
        @ColumnInfo(name = "created_dts") var createdDTS: OffsetDateTime,
        @ColumnInfo(name = "updated_dts") var updatedDTS: OffsetDateTime,
        @ColumnInfo(name = "rank") var rank: Int
) : Serializable {
    constructor() : this(
            null,
            "",
            "",
            OffsetDateTime.MIN,
            OffsetDateTime.MIN,
            0
    )
}
