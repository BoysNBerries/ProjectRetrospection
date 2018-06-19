/**
 * Created by Taylor Lanclos on 6/18/18
 */
package dev.boysnberries.projectretrospection.data.database.entity

import android.arch.persistence.room.*
import org.threeten.bp.OffsetDateTime


@Entity(tableName = "records")
data class Record(
        @PrimaryKey(autoGenerate = true) val id: Long?,
        @Embedded val tracker: Tracker,
        @ColumnInfo(name = "creation_dts") val createdDTS: OffsetDateTime
) {
    constructor() : this(null, Tracker(), OffsetDateTime.MIN)
}
