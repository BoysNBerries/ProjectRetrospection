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
], indices = [
    Index(value = ["tracker_id"])
])
data class Record(
        @PrimaryKey(autoGenerate = true) var id: Long?,
        @ColumnInfo(name = "tracker_id") var trackerID: Long,
        @ColumnInfo(name = "creation_dts") var createdDTS: OffsetDateTime
) {
    companion object {
        fun default() = Record(null, Long.MAX_VALUE, OffsetDateTime.MIN)
    }
}
