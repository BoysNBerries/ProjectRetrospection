package dev.boysnberries.projectretrospection.data.database.entity

import org.junit.Assert
import org.junit.Test


class QuestionTest {
    @Test fun `class should define default id`() {
        Assert.assertNull(Question().id)
    }

    @Test fun `class should define default tracker`() {
        Assert.assertEquals(Tracker(), Question().tracker)
    }

    @Test fun `class should define default question type`() {
        Assert.assertEquals(QuestionType(), Question().questionType)
    }

    @Test fun `class should define default question text`() {
        Assert.assertEquals("", Question().questionText)
    }

    @Test fun `class should define default rank`() {
        Assert.assertEquals(0, Question().rank)
    }
}
