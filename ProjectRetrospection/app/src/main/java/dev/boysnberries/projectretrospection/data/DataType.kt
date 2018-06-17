package dev.boysnberries.projectretrospection.data

import java.time.LocalDateTime


class DataTypeValueException(message: String) : Exception(message) {
    constructor() : this("")
}

interface AbstractDataType {
    fun value(): Any
}

data class TimeDataType(private val _datetime: LocalDateTime) : AbstractDataType {
    override fun value(): LocalDateTime {
        return _datetime
    }
}

class IntegerDataType(private val _value: Int) : AbstractDataType {
    override fun value(): Int {
        return _value
    }
}

class CategoricalDataType(private val _value: String, private val _categories: List<String>) : AbstractDataType {
    init {
        if (this.value() !in this.categories) {
            throw DataTypeValueException()
        }
    }
    override fun value(): String {
        return _value
    }

    val categories: List<String>
        get() = _categories
}

class BooleanDataType(private val _value: Boolean) : AbstractDataType {
    override fun value(): Boolean {
        return _value
    }
}
