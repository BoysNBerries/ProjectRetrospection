package dev.boysnberries.projectretrospection.data.database.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import dev.boysnberries.projectretrospection.data.database.entity.BooleanAnswer

@Dao
interface BooleanAnswerDao {
    @Query("select * from boolean_answers")
    fun getAll()

    @Query("select * from boolean_answers where record_id = :recordID")
    fun getByRecordID(recordID: Long)

    @Query("select * from boolean_answers where question_id = :questionID")
    fun getByQuestionID(questionID: Long)

    @Query("select * from boolean_answers where record_id = :recordID and question_id = :questionID")
    fun getByRecordIDAndQuestionID(recordID: Long, questionID: Long)

    @Insert(onConflict = OnConflictStrategy.ABORT)
    fun insert(booleanAnswer: BooleanAnswer)
}
