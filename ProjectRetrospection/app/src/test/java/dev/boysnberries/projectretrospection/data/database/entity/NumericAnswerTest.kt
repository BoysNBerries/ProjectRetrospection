package dev.boysnberries.projectretrospection.data.database.entity

import org.junit.Assert
import org.junit.Test


class NumericAnswerTest {
    @Test fun `class should define default id`() {
        Assert.assertNull(NumericAnswer().id)
    }

    @Test fun `class should define default question`() {
        Assert.assertEquals(Question(), NumericAnswer().question)
    }

    @Test fun `class should define default record`() {
        Assert.assertEquals(Record(), NumericAnswer().record)
    }

    @Test fun `class should define default value`() {
        Assert.assertEquals(0, NumericAnswer().value)
    }
}
