package dev.boysnberries.projectretrospection.data.database.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import dev.boysnberries.projectretrospection.data.database.entity.TimeAnswer

@Dao
interface TimeAnswerDao {
    @Query("select * from time_answers")
    fun getAll(): List<TimeAnswer>

    @Query("select * from time_answers where record_id = :recordID")
    fun getByRecordID(recordID: Long): List<TimeAnswer>

    @Query("select * from time_answers where question_id = :questionID")
    fun getByQuestionID(questionID: Long): List<TimeAnswer>

    @Query("select * from time_answers where record_id = :recordID and question_id = :questionID")
    fun getByRecordIDAndQuestionID(recordID: Long, questionID: Long): List<TimeAnswer>

    @Insert(onConflict = OnConflictStrategy.ABORT)
    fun insert(timeAnswer: TimeAnswer): Long
}
