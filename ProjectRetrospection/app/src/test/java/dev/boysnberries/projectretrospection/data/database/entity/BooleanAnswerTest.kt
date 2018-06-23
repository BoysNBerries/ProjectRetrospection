package dev.boysnberries.projectretrospection.data.database.entity

import org.junit.Assert
import org.junit.Test


class BooleanAnswerTest {
    @Test fun `class should define default id`() {
        Assert.assertNull(BooleanAnswer.default().id)
    }

    @Test fun `class should define default question id`() {
        Assert.assertEquals(Long.MAX_VALUE, BooleanAnswer.default().questionID)
    }

    @Test fun `class should define default record id`() {
        Assert.assertEquals(Long.MAX_VALUE, BooleanAnswer.default().recordID)
    }

    @Test fun `class should define default value`() {
        Assert.assertFalse(BooleanAnswer.default().value)
    }
}
