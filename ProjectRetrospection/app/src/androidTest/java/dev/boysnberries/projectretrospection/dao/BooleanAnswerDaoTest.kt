package dev.boysnberries.projectretrospection.dao

import android.arch.persistence.room.Room
import android.support.test.InstrumentationRegistry
import android.support.test.runner.AndroidJUnit4
import dev.boysnberries.projectretrospection.data.database.RetrospectionDatabase
import dev.boysnberries.projectretrospection.data.database.dao.BooleanAnswerDao
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class BooleanAnswerDaoTest {
    private lateinit var database: RetrospectionDatabase

    @Before fun setup() {
        this.database = Room.inMemoryDatabaseBuilder(
                InstrumentationRegistry.getContext(),
                RetrospectionDatabase::class.java
        ).build()
    }

    @After fun teardown() {
        this.database.close()
    }

    @Test fun booleanAnswerDao_getAll__should__getAllRows() {

    }
    // TODO: Complete testing
}
