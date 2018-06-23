package dev.boysnberries.projectretrospection.data.database.entity

import org.junit.Assert
import org.junit.Test
import org.threeten.bp.OffsetDateTime


class TrackerTest {
    @Test fun `class should define default id`() {
        Assert.assertNull(Tracker.default().id)
    }

    @Test fun `class should define default title`() {
        Assert.assertEquals("", Tracker.default().title)
    }

    @Test fun `class should define default description`() {
        Assert.assertEquals("", Tracker.default().description)
    }

    @Test fun `class should define default created DTS`() {
        Assert.assertEquals(OffsetDateTime.MIN, Tracker.default().createdDTS)
    }

    @Test fun `class should define default updated DTS`() {
        Assert.assertEquals(OffsetDateTime.MIN, Tracker.default().updatedDTS)
    }

    @Test fun `class should define default rank`() {
        Assert.assertEquals(0, Tracker.default().rank)
    }
}
