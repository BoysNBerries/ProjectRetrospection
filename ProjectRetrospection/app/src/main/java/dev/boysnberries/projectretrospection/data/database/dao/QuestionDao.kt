package dev.boysnberries.projectretrospection.data.database.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import dev.boysnberries.projectretrospection.data.database.entity.Question

@Dao
interface QuestionDao {
    @Query("select * from questions")
    fun getAll(): List<Question>

    @Query("select * from questions where question_type_id = :questionTypeID")
    fun getByQuestionTypeID(questionTypeID: Long): List<Question>

    @Query("select * from questions where tracker_id = :trackerID")
    fun getByTrackerID(trackerID: Long): List<Question>

    @Query("select * from questions where tracker_id = :trackerID and question_type_id = :questionTypeID")
    fun getByTrackerIDAndQuestionTypeID(trackerID: Long, questionTypeID: Long): List<Question>

    @Insert(onConflict = OnConflictStrategy.ABORT)
    fun insert(question: Question): Long
}
