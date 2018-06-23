package dev.boysnberries.projectretrospection.data.database.entity

import org.junit.Assert
import org.junit.Test


class TextAnswerTest {
    @Test fun `class should define default id`() {
        Assert.assertNull(TextAnswer.default().id)
    }

    @Test fun `class should define default question id`() {
        Assert.assertEquals(Long.MAX_VALUE, TextAnswer.default().questionID)
    }

    @Test fun `class should define default record id`() {
        Assert.assertEquals(Long.MAX_VALUE, TextAnswer.default().recordID)
    }

    @Test fun `class should define default value`() {
        Assert.assertEquals("", TextAnswer.default().value)
    }
}
