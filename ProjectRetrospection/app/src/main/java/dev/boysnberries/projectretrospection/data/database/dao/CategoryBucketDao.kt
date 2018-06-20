package dev.boysnberries.projectretrospection.data.database.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import dev.boysnberries.projectretrospection.data.database.entity.CategoryBucket

@Dao
interface CategoryBucketDao {
    @Query("select * from category_buckets")
    fun getAll()

    @Query("select * from category_buckets where question_id = :questionID")
    fun getByQuestionID(questionID: Long)

    @Insert(onConflict = OnConflictStrategy.ABORT)
    fun insert(categoryBucket: CategoryBucket)
}
