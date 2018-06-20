package dev.boysnberries.projectretrospection.data.database.entity

import org.junit.Assert
import org.junit.Test


class QuestionTest {
    @Test fun `class should define default id`() {
        Assert.assertNull(Question().id)
    }

    @Test fun `class should define default tracker id`() {
        Assert.assertEquals(Long.MAX_VALUE, Question().trackerID)
    }

    @Test fun `class should define default question type id`() {
        Assert.assertEquals(Long.MAX_VALUE, Question().questionTypeID)
    }

    @Test fun `class should define default question text`() {
        Assert.assertEquals("", Question().questionText)
    }

    @Test fun `class should define default rank`() {
        Assert.assertEquals(0, Question().rank)
    }
}
