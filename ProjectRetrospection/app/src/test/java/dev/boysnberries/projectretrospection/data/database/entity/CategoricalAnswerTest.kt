package dev.boysnberries.projectretrospection.data.database.entity

import org.junit.Assert
import org.junit.Test


class CategoricalAnswerTest {
    @Test fun `class should define default id`() {
        Assert.assertNull(CategoricalAnswer().id)
    }

    @Test fun `class should define default question`() {
        Assert.assertEquals(Question(), CategoricalAnswer().question)
    }

    @Test fun `class should define default record`() {
        Assert.assertEquals(Record(), CategoricalAnswer().record)
    }

    @Test fun `class should define default value`() {
        Assert.assertEquals("", CategoricalAnswer().value)
    }
}
