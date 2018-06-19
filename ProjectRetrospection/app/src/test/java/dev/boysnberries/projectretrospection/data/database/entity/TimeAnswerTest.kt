package dev.boysnberries.projectretrospection.data.database.entity

import org.junit.Assert
import org.junit.Test
import org.threeten.bp.OffsetDateTime


class TimeAnswerTest {
    @Test
    fun `class should define default id`() {
        Assert.assertNull(TimeAnswer().id)
    }

    @Test
    fun `class should define default question`() {
        Assert.assertEquals(Question(), TimeAnswer().question)
    }

    @Test
    fun `class should define default record`() {
        Assert.assertEquals(Record(), TimeAnswer().record)
    }

    @Test
    fun `class should define default value`() {
        Assert.assertEquals(OffsetDateTime.MIN, TimeAnswer().value)
    }
}
