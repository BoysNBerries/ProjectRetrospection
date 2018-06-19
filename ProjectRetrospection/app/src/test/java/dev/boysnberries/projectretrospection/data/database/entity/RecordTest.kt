package dev.boysnberries.projectretrospection.data.database.entity

import org.junit.Assert
import org.junit.Test
import org.threeten.bp.OffsetDateTime


class RecordTest {
    @Test fun `class should define default id`() {
        Assert.assertNull(Record().id)
    }

    @Test fun `class should define default tracker`() {
        Assert.assertEquals(Tracker(), Record().tracker)
    }

    @Test fun `class should define default created DTS`() {
        Assert.assertEquals(OffsetDateTime.MIN, Record().createdDTS)
    }
}
