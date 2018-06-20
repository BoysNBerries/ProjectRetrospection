/**
 * Created by Taylor Lanclos on 6/18/18
 */
package dev.boysnberries.projectretrospection.data.database.entity

import android.arch.persistence.room.*
import org.threeten.bp.OffsetDateTime


@Entity(tableName = "records", foreignKeys = [
    ForeignKey(
            entity = Tracker::class,
            parentColumns = ["id"],
            childColumns = ["tracker_id"],
            onDelete = ForeignKey.NO_ACTION
    )
])
data class Record(
        @PrimaryKey(autoGenerate = true) val id: Long?,
        @ColumnInfo(name = "tracker_id") val trackerID: Long,
        @ColumnInfo(name = "creation_dts") val createdDTS: OffsetDateTime
) {
    constructor() : this(null, Long.MAX_VALUE, OffsetDateTime.MIN)
}
