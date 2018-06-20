package dev.boysnberries.projectretrospection.data.database.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import dev.boysnberries.projectretrospection.data.database.entity.Tracker

@Dao
interface TrackerDao {
    @Query("select * from trackers")
    fun getAll()

    @Insert(onConflict = OnConflictStrategy.ABORT)
    fun insert(tracker: Tracker)
}
