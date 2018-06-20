package dev.boysnberries.projectretrospection.data.database

import android.arch.persistence.room.*
import android.content.Context
import dev.boysnberries.projectretrospection.data.database.entity.*


@Dao
interface TrackersDao {
    @Query("select * from trackers")
    fun getAll(): List<Tracker>

    @Query("select * from questions where tracker = :trackerID")
    fun getQuestionsForTrackerByID(trackerID: Long)
}


@Database(version = 1, entities = [
    BooleanAnswer::class,
    CategoricalAnswer::class,
    CategoryBucket::class,
    NumericAnswer::class,
    TextAnswer::class,
    TimeAnswer::class,
    Question::class,
    QuestionType::class,
    Record::class,
    Tracker::class
])
abstract class RetrospectionDatabase : RoomDatabase() {

    abstract fun getTrackersDao(): TrackersDao

    companion object {
        private var instance: RetrospectionDatabase? = null

        fun getInstance(context: Context): RetrospectionDatabase? {
            if (this.instance == null) {
                synchronized(RetrospectionDatabase::class) {
                    this.instance = Room.databaseBuilder(
                            context.applicationContext,
                            RetrospectionDatabase::class.java,
                            "retrospection.db"
                    ).build()
                }
            }
            return this.instance
        }

        fun destroyInstance() {
            this.instance = null
        }
    }
}