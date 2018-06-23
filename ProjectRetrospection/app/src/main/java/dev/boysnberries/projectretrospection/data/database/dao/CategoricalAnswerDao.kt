package dev.boysnberries.projectretrospection.data.database.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import dev.boysnberries.projectretrospection.data.database.entity.CategoricalAnswer

@Dao
interface CategoricalAnswerDao {
    @Query("select * from categorical_answers")
    fun getAll(): List<CategoricalAnswer>

    @Query("select * from categorical_answers where record_id = :recordID")
    fun getByRecordID(recordID: Long): List<CategoricalAnswer>

    @Query("select * from categorical_answers where question_id = :questionID")
    fun getByQuestionID(questionID: Long): List<CategoricalAnswer>

    @Query("select * from categorical_answers where record_id = :recordID and question_id = :questionID")
    fun getByRecordIDAndQuestionID(recordID: Long, questionID: Long): List<CategoricalAnswer>

    @Insert(onConflict = OnConflictStrategy.ABORT)
    fun insert(categoricalAnswer: CategoricalAnswer): Long
}
