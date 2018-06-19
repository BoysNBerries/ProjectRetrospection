package dev.boysnberries.projectretrospection.data.database.entity

import org.junit.Assert
import org.junit.Test


class CategoryBucketTest {
    @Test fun `class should define default id`() {
        Assert.assertNull(CategoryBucket().id)
    }

    @Test fun `class should define default question`() {
        Assert.assertEquals(Question(), CategoryBucket().question)
    }

    @Test fun `class should define default allowed value`() {
        Assert.assertEquals("", CategoryBucket().allowedValue)
    }

    @Test fun `class should define default rank`() {
        Assert.assertNull(CategoryBucket().rank)
    }
}
