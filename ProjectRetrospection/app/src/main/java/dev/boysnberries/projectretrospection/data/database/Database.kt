package dev.boysnberries.projectretrospection.data.database

import android.arch.persistence.room.*
import android.content.Context
import dev.boysnberries.projectretrospection.data.database.entity.*


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