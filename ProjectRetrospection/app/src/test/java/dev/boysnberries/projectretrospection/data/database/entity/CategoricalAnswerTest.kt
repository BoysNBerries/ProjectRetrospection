package dev.boysnberries.projectretrospection.data.database.entity

import org.junit.Assert
import org.junit.Test


class CategoricalAnswerTest {
    @Test fun `class should define default id`() {
        Assert.assertNull(CategoricalAnswer().id)
    }

    @Test fun `class should define default question id`() {
        Assert.assertEquals(Long.MAX_VALUE, CategoricalAnswer().questionID)
    }

    @Test fun `class should define default record id`() {
        Assert.assertEquals(Long.MAX_VALUE, CategoricalAnswer().recordID)
    }

    @Test fun `class should define default value`() {
        Assert.assertEquals("", CategoricalAnswer().value)
    }
}
