package dev.boysnberries.projectretrospection.data.database.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import dev.boysnberries.projectretrospection.data.database.entity.QuestionType

@Dao
interface QuestionTypeDao {
    @Query("select * from question_types")
    fun getAll(): List<QuestionType>

    @Insert(onConflict = OnConflictStrategy.ABORT)
    fun insert(questionType: QuestionType): Long
}
