package dev.boysnberries.projectretrospection.data.database.converter

import org.junit.Assert
import org.junit.Test
import org.threeten.bp.OffsetDateTime
import org.threeten.bp.ZoneOffset

class OffsetDateTimeTypeConverterTest {
    @Test fun `toOffsetDateTime should convert min from string`() {
        Assert.assertEquals(OffsetDateTime.MIN,
                OffsetDateTimeTypeConverter().toOffsetDateTime(OffsetDateTime.MIN.toString()))
    }

    @Test fun `toOffsetDateTime should convert max from string`() {
        Assert.assertEquals(OffsetDateTime.MAX,
                OffsetDateTimeTypeConverter().toOffsetDateTime(OffsetDateTime.MAX.toString()))
    }

    @Test fun `toOffsetDateTime should convert arbitrary offset date time from string`() {
        Assert.assertEquals(
                OffsetDateTime.of(
                        2018,
                        6,
                        23,
                        6,
                        43,
                        45,
                        102301,
                        ZoneOffset.UTC
                ),
                OffsetDateTimeTypeConverter().toOffsetDateTime(
                        "2018-06-23T06:43:45.000102301Z"
                ))
    }

    @Test fun `toString should convert min to string`() {
        Assert.assertEquals(OffsetDateTime.MIN.toString(),
                OffsetDateTimeTypeConverter().toString(OffsetDateTime.MIN))
    }

    @Test fun `toString should convert max to string`() {
        Assert.assertEquals(OffsetDateTime.MAX.toString(),
                OffsetDateTimeTypeConverter().toString(OffsetDateTime.MAX))
    }

    @Test fun `toString should convert arbitrary offset date time to string`() {
        Assert.assertEquals(
                "2018-06-23T06:43:45.000102301Z",
                OffsetDateTimeTypeConverter().toString(OffsetDateTime.of(
                        2018,
                        6,
                        23,
                        6,
                        43,
                        45,
                        102301,
                        ZoneOffset.UTC
                )))
    }
}