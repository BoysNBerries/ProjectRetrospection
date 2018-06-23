package dev.boysnberries.projectretrospection.data.database.entity

import org.junit.Assert
import org.junit.Test


class CategoryBucketTest {
    @Test fun `class should define default id`() {
        Assert.assertNull(CategoryBucket.default().id)
    }

    @Test fun `class should define default question id`() {
        Assert.assertEquals(Long.MAX_VALUE, CategoryBucket.default().questionID)
    }

    @Test fun `class should define default allowed value`() {
        Assert.assertEquals("", CategoryBucket.default().allowedValue)
    }

    @Test fun `class should define default rank`() {
        Assert.assertNull(CategoryBucket.default().rank)
    }
}
