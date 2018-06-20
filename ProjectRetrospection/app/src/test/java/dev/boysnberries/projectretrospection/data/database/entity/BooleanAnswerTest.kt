package dev.boysnberries.projectretrospection.data.database.entity

import org.junit.Assert
import org.junit.Test


class BooleanAnswerTest {
    @Test fun `class should define default id`() {
        Assert.assertNull(BooleanAnswer().id)
    }

    @Test fun `class should define default question id`() {
        Assert.assertEquals(Long.MAX_VALUE, BooleanAnswer().questionID)
    }

    @Test fun `class should define default record id`() {
        Assert.assertEquals(Long.MAX_VALUE, BooleanAnswer().recordID)
    }

    @Test fun `class should define default value`() {
        Assert.assertFalse(BooleanAnswer().value)
    }
}
