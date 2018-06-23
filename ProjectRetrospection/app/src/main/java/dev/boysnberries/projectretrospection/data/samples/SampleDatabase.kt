package dev.boysnberries.projectretrospection.data.samples

import android.arch.persistence.room.Room
import android.content.ClipDescription
import android.content.Context
import dev.boysnberries.projectretrospection.data.CategoryType
import dev.boysnberries.projectretrospection.data.database.RetrospectionDatabase
import dev.boysnberries.projectretrospection.data.database.entity.*
import org.threeten.bp.OffsetDateTime


interface Category

fun getTrackerByTitle(database: RetrospectionDatabase, title: String): Tracker? {
    return database.trackerDao().getAll().find { tracker -> tracker.title == title }
}

fun getQuestionTypeByCategoryType(database: RetrospectionDatabase, cat: CategoryType): QuestionType? {
    return database.questionTypeDao().getAll().find { questionType -> questionType.tag == cat.value }
}

fun insertTracker(database: RetrospectionDatabase,
                  title: String,
                  description: String,
                  createdDTS: OffsetDateTime,
                  updatedDTS: OffsetDateTime,
                  rank: Int): Long {
    return database.trackerDao().insert(Tracker(
            null,
            title,
            description,
            createdDTS,
            updatedDTS,
            rank
    ))
}

fun insertQuestion(database: RetrospectionDatabase,
                   trackerTitle: String,
                   categoryType: CategoryType,
                   questionText: String,
                   rank: Int): Long {
    return database.questionDao().insert(Question(
            null,
            getTrackerByTitle(database, trackerTitle)?.id as Long,
            getQuestionTypeByCategoryType(database,categoryType)?.id as Long,
            questionText,
            rank
    ))
}

fun insertRecord(database: RetrospectionDatabase,
                 trackerTitle: String,
                 answers: List<Pair<String, Any>>): Long {
    val trackerID = database.trackerDao().getAll().find { tracker -> tracker.title == trackerTitle }?.id as Long
    val recordID = database.recordDao().insert(Record(null, trackerID, OffsetDateTime.now()))

    for ((questionText, answer) in answers) {
        val questionID = database.questionDao().getByTrackerID(trackerID).find { question -> question.questionText == questionText }?.id as Long
        when (answer) {
            is Boolean -> database.booleanAnswerDao().insert(BooleanAnswer(null, recordID, questionID, answer))
            is String -> database.textAnswerDao().insert(TextAnswer(null, recordID, questionID, answer))
            is Float -> database.numericAnswerDao().insert(NumericAnswer(null, recordID, questionID, answer))
            is OffsetDateTime -> database.timeAnswerDao().insert(TimeAnswer(null, recordID, questionID, answer))
            is Category -> database.categoricalAnswerDao().insert(CategoricalAnswer(null, recordID, questionID, answer.toString()))
        }
    }

    return recordID
}

fun insertCategories(database: RetrospectionDatabase, questionText: String, values: List<String>) {
    val questionID = database.questionDao().getAll().find { question -> question.questionText == questionText }?.id as Long

    for (value in values) {
        database.categoryBucketDao().insert(CategoryBucket(null, questionID, value, null))
    }
}

private enum class HatTypes(val value: String) : Category {
    MICROSOFT("Microsoft"),
    YUNG_LEAN("Yung Lean")
}

private enum class ShirtColor(val value: String) : Category {
    GREENISH("Green-ish"),
    BLUEISH("Blue-ish"),
    GREY("Grey")
}

fun getEmptySampleDatabase(context: Context): RetrospectionDatabase {
    return Room.inMemoryDatabaseBuilder(context, RetrospectionDatabase::class.java).allowMainThreadQueries().build()
}

fun getSampleDatabase(context: Context): RetrospectionDatabase {
    val database = getEmptySampleDatabase(context)

    insertTracker(
            database,
            "John's Hat Quest",
            "Am I creepier with a hat?",
            OffsetDateTime.now(),
            OffsetDateTime.now(),
            1
    )
    insertTracker(
            database,
            "Taylor's Grey Shirt",
            "How many people are as delusional as Taylor?",
            OffsetDateTime.now().minusYears(2),
            OffsetDateTime.now().minusYears(1),
            2
    )
    insertTracker(
            database,
            "Jensen's Infernal Cat Car",
            "How many times is that freakin' cat on my car?",
            OffsetDateTime.now().minusYears(1),
            OffsetDateTime.now().minusYears(1),
            3
    )


    database.questionTypeDao().insert(QuestionType(0, CategoryType.BOOLEAN.value))
    database.questionTypeDao().insert(QuestionType(1, CategoryType.CATEGORICAL.value))
    database.questionTypeDao().insert(QuestionType(2, CategoryType.NUMERIC.value))
    database.questionTypeDao().insert(QuestionType(3, CategoryType.TEXT.value))
    database.questionTypeDao().insert(QuestionType(4, CategoryType.TIME.value))


    insertQuestion(
            database,
            "John's Hat Quest",
            CategoryType.CATEGORICAL,
            "Which hat am I wearing?",
            1
    )
    insertQuestion(
            database,
            "John's Hat Quest",
            CategoryType.TIME,
            "What is the time of day?",
            2
    )

    insertCategories(database, "Which hat am I wearing?", listOf(
            HatTypes.MICROSOFT.value,
            HatTypes.YUNG_LEAN.value
    ))


    insertQuestion(
            database,
            "Taylor's Grey Shirt",
            CategoryType.CATEGORICAL,
            "What color is the shirt?",
            1
    )
    insertQuestion(
            database,
            "Taylor's Grey Shirt",
            CategoryType.NUMERIC,
            "How old is the person?",
            2
    )

    insertCategories(database, "What color is the shirt?", listOf(
            ShirtColor.BLUEISH.value,
            ShirtColor.GREENISH.value,
            ShirtColor.GREY.value
    ))


    insertQuestion(
            database,
            "Jensen's Infernal Cat Car",
            CategoryType.BOOLEAN,
            "Is there a cat on my car?",
            1
    )
    insertQuestion(
            database,
            "Jensen's Infernal Cat Car",
            CategoryType.TIME,
            "What time is it?",
            2
    )


    insertRecord(database,"John's Hat Quest", listOf(
            Pair("Which hat am I wearing?", HatTypes.YUNG_LEAN.value),
            Pair("What is the time of day?", OffsetDateTime.now())
    ))
    insertRecord(database, "John's Hat Quest", listOf(
            Pair("Which hat am I wearing?", HatTypes.MICROSOFT.value),
            Pair("What is the time of day?", OffsetDateTime.now())
    ))


    insertRecord(database, "Taylor's Grey Shirt", listOf(
            Pair("What color is the shirt?", ShirtColor.BLUEISH.value),
            Pair("How old is the person?", 58)
    ))
    insertRecord(database, "Taylor's Grey Shirt", listOf(
            Pair("What color is the shirt?", ShirtColor.GREENISH.value),
            Pair("How old is the person?", 18)
    ))
    insertRecord(database, "Taylor's Grey Shirt", listOf(
            Pair("What color is the shirt?", ShirtColor.GREY.value),
            Pair("How old is the person?", 24)
    ))


    insertRecord(database, "Jensen's Infernal Cat Car", listOf(
            Pair("Is there a cat on my car?", false),
            Pair("What time is it?", OffsetDateTime.now())
    ))

    insertRecord(database, "Jensen's Infernal Cat Car", listOf(
            Pair("Is there a cat on my car?", true),
            Pair("What time is it?", OffsetDateTime.now())
    ))

    return database
}