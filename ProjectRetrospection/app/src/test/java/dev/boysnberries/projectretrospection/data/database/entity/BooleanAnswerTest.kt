package dev.boysnberries.projectretrospection.data.database.entity

import org.junit.Assert
import org.junit.Test


class BooleanAnswerTest {
    @Test fun `class should define default id`() {
        Assert.assertNull(BooleanAnswer().id)
    }

    @Test fun `class should define default question`() {
        Assert.assertEquals(Question(), BooleanAnswer().question)
    }

    @Test fun `class should define default record`() {
        Assert.assertEquals(Record(), BooleanAnswer().record)
    }

    @Test fun `class should define default value`() {
        Assert.assertFalse(BooleanAnswer().value)
    }
}
