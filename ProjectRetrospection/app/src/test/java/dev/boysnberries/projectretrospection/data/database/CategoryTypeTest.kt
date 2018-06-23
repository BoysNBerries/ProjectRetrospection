package dev.boysnberries.projectretrospection.data.database


import dev.boysnberries.projectretrospection.data.CategoryType
import org.junit.Assert
import org.junit.BeforeClass
import org.junit.Test


class BooleanAnswerTest {
    companion object {
        @BeforeClass @JvmStatic fun `check for function definitions`() {
            for (categoryType: CategoryType in CategoryType.values()) {
                val functionName: String = "category type should have category for %s".format(
                        categoryType.value.toLowerCase()
                )

                if (functionName !in BooleanAnswerTest::class.members.map { fn -> fn.name }) {
                    throw Exception("no function defined for '%s'".format(functionName))
                }
            }
        }
    }

    @Test fun `category type should have category for boolean`() {
        Assert.assertEquals("BOOLEAN", CategoryType.BOOLEAN.value)
    }

    @Test fun `category type should have category for text`() {
        Assert.assertEquals("TEXT", CategoryType.TEXT.value)
    }

    @Test fun `category type should have category for numeric`() {
        Assert.assertEquals("NUMERIC", CategoryType.NUMERIC.value)
    }

    @Test fun `category type should have category for time`() {
        Assert.assertEquals("TIME", CategoryType.TIME.value)
    }

    @Test fun `category type should have category for categorical`() {
        Assert.assertEquals("CATEGORICAL", CategoryType.CATEGORICAL.value)
    }
}
