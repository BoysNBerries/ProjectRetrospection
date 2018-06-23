package dev.boysnberries.projectretrospection.data.database.entity

import org.junit.Assert
import org.junit.Test


class NumericAnswerTest {
    @Test fun `class should define default id`() {
        Assert.assertNull(NumericAnswer.default().id)
    }

    @Test fun `class should define default question id`() {
        Assert.assertEquals(Long.MAX_VALUE, NumericAnswer.default().questionID)
    }

    @Test fun `class should define default record id`() {
        Assert.assertEquals(Long.MAX_VALUE, NumericAnswer.default().recordID)
    }

    @Test fun `class should define default value`() {
        Assert.assertEquals(0.0f, NumericAnswer.default().value)
    }
}
