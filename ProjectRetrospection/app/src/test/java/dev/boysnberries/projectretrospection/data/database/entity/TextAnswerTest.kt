package dev.boysnberries.projectretrospection.data.database.entity

import org.junit.Assert
import org.junit.Test


class TextAnswerTest {
    @Test fun `class should define default id`() {
        Assert.assertNull(TextAnswer().id)
    }

    @Test fun `class should define default question`() {
        Assert.assertEquals(Question(), TextAnswer().question)
    }

    @Test fun `class should define default record`() {
        Assert.assertEquals(Record(), TextAnswer().record)
    }

    @Test fun `class should define default value`() {
        Assert.assertEquals("", TextAnswer().value)
    }
}
