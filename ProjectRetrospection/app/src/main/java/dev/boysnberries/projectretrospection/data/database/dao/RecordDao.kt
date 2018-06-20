package dev.boysnberries.projectretrospection.data.database.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import dev.boysnberries.projectretrospection.data.database.entity.Record

@Dao
interface RecordDao {
    @Query("select * from records")
    fun getAll()

    @Query("select * from records where tracker_id = :trackerID")
    fun getByTrackerID(trackerID: Long)

    @Insert(onConflict = OnConflictStrategy.ABORT)
    fun insert(record: Record)
}
