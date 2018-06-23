package dev.boysnberries.projectretrospection.data.database.entity

import org.junit.Assert
import org.junit.Test
import org.threeten.bp.OffsetDateTime


class TimeAnswerTest {
    @Test
    fun `class should define default id`() {
        Assert.assertNull(TimeAnswer.default().id)
    }

    @Test
    fun `class should define default question id`() {
        Assert.assertEquals(Long.MAX_VALUE, TimeAnswer.default().questionID)
    }

    @Test
    fun `class should define default record id`() {
        Assert.assertEquals(Long.MAX_VALUE, TimeAnswer.default().recordID)
    }

    @Test
    fun `class should define default value`() {
        Assert.assertEquals(OffsetDateTime.MIN, TimeAnswer.default().value)
    }
}
