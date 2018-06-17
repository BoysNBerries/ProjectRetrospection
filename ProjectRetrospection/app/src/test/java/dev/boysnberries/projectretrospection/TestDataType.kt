package dev.boysnberries.projectretrospection

import dev.boysnberries.projectretrospection.data.*
import org.junit.Test

import org.junit.Assert.*
import java.time.LocalDateTime

class TestAbstractDataType {
    @Test
    fun value_should_returnValue() {
        assertEquals(
            LocalDateTime.of(2018, 11, 23, 0, 0),
            TimeDataType(
                    LocalDateTime.of(2018, 11, 23, 0, 0)
            ).value()
        )
    }
}

class TestIntegerDataType {
    @Test
    fun value_should_returnValue() {
        assertEquals(20, IntegerDataType(20).value())
    }
}

class TestCategoricalDataType {
    @Test
    fun value_should_returnValue() {
        assertEquals(
            "TestValue",
            CategoricalDataType("TestValue", mutableListOf("TestValue")).value()
        )
    }

    @Test(expected = DataTypeValueException::class)
    fun value_should_raiseDataTypeValueExceptionOnTypeNotInCategories() {
        CategoricalDataType("TestValue", mutableListOf())
    }

    @Test
    fun categories_should_returnCategories() {
        assertEquals(
            mutableListOf("TestValue", "TestValue2"),
            CategoricalDataType(
                    "TestValue",
                    mutableListOf("TestValue", "TestValue2")
            ).categories
        )
    }
}

class TestBooleanDataType {
    @Test
    fun value_should_returnValue() {
        assertFalse(BooleanDataType(false).value())
    }
}