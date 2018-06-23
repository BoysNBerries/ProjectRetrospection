package dev.boysnberries.projectretrospection.data.database.entity

import org.junit.Assert
import org.junit.Test


class QuestionTypeTest {
    @Test fun `class should define default id`() {
        Assert.assertNull(QuestionType.default().id)
    }

    @Test fun `class should define default tag`() {
        Assert.assertEquals("", QuestionType.default().tag)
    }
}
