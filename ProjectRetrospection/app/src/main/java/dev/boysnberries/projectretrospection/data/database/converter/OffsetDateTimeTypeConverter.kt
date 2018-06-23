package dev.boysnberries.projectretrospection.data.database.converter

import android.arch.persistence.room.TypeConverter
import org.threeten.bp.OffsetDateTime

class OffsetDateTimeTypeConverter {
    @TypeConverter fun toOffsetDateTime(value: String?): OffsetDateTime? {
        return if (value == null) null else OffsetDateTime.parse(value)
    }

    @TypeConverter fun toString(value: OffsetDateTime?): String? {
        return value?.toString()
    }
}
