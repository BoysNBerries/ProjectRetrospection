package dev.boysnberries.projectretrospection.data.database

import android.arch.persistence.room.*
import android.content.Context
import dev.boysnberries.projectretrospection.data.database.dao.*
import dev.boysnberries.projectretrospection.data.database.converter.OffsetDateTimeTypeConverter
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
@TypeConverters(OffsetDateTimeTypeConverter::class)
abstract class RetrospectionDatabase : RoomDatabase() {
    abstract fun booleanAnswerDao(): BooleanAnswerDao
    abstract fun categoricalAnswerDao(): CategoricalAnswerDao
    abstract fun categoryBucketDao(): CategoryBucketDao
    abstract fun numericAnswerDao(): NumericAnswerDao
    abstract fun questionDao(): QuestionDao
    abstract fun questionTypeDao(): QuestionTypeDao
    abstract fun recordDao(): RecordDao
    abstract fun textAnswerDao(): TextAnswerDao
    abstract fun timeAnswerDao(): TimeAnswerDao
    abstract fun trackerDao(): TrackerDao

    companion object {
        private var instance: RetrospectionDatabase? = null
        private var inMemoryInstance: RetrospectionDatabase? = null

        private fun getInMemoryInstance(context: Context): RetrospectionDatabase {
            when (this.inMemoryInstance) {
                null -> synchronized(RetrospectionDatabase::class) {
                    this.inMemoryInstance = Room.inMemoryDatabaseBuilder(
                            context,
                            RetrospectionDatabase::class.java
                    ).allowMainThreadQueries().build()
                    return this.inMemoryInstance!!
                }
                else -> return this.inMemoryInstance!!
            }
        }

        private fun getFilesystemInstance(context: Context): RetrospectionDatabase {
            when (this.instance) {
                null -> synchronized(RetrospectionDatabase::class) {
                    this.instance = Room.databaseBuilder(
                            context.applicationContext,
                            RetrospectionDatabase::class.java,
                            "retrospection.db"
                    ).build()
                    return this.instance!!
                }
                else -> return this.instance!!
            }
        }

        fun getInstance(context: Context, inMemory: Boolean = false): RetrospectionDatabase? {
            return when (inMemory) {
                false -> getFilesystemInstance(context)
                true -> getInMemoryInstance(context)
            }
        }

        fun destroyInstances() {
            this.instance = null
            this.inMemoryInstance = null
        }
    }
}