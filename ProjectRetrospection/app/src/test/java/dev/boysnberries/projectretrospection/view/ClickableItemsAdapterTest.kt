package dev.boysnberries.projectretrospection.view
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import io.mockk.*
import org.junit.Assert
import org.junit.Before
import org.junit.Test

const val LAYOUT = 112234

data class ClickableItemsAdapterTestData(
        val adapterSpy: ClickableItemsAdapterTest.ClickableItemsAdapterImpl,
        val parentViewGroupMock: ViewGroup,
        val layoutInflaterInflateRet: View,
        val getViewHolderRet: ClickableItemsViewHolder
)

class ClickableItemsAdapterTest {

    abstract class ClickableItemsAdapterImpl :
            ClickableItemsAdapter<Int, ClickableItemsViewHolder>(listOf(1, 2, 3), LAYOUT)

    // TODO: If we do this pattern a lot (i.e. having a setup() function that
    // TODO: sets test data on a data class object), we should probably standardize
    // TODO: the pattern.  My preference would be to pass the data object into every
    // TODO: test function, if that is possible with JUnit.  We probably also want to
    // TODO: call it something different (like a one-letter name) because 'testData' is
    // TODO: wordy once its repeated enough.
    lateinit var testData: ClickableItemsAdapterTestData

    @Before fun setup() {
        val adapter = spyk<ClickableItemsAdapterImpl>()
        val parentViewGroup = mockk<ViewGroup>()
        val layoutInflaterInflateRet = mockk<View>()
        val getViewHolderRet = mockk<ClickableItemsViewHolder>()

        mockkStatic(LayoutInflater::class)

        every { parentViewGroup.context } returns mockk()
        every {
            LayoutInflater
                    .from(parentViewGroup.context)
                    .inflate(LAYOUT, any(), any())
        } returns layoutInflaterInflateRet

        every { adapter.getViewHolder(any()) } returns getViewHolderRet

        this.testData = ClickableItemsAdapterTestData(
                adapterSpy = adapter,
                parentViewGroupMock = parentViewGroup,
                layoutInflaterInflateRet = layoutInflaterInflateRet,
                getViewHolderRet = getViewHolderRet
        )
    }

    @Test fun `onCreateViewHolder should create view using LayoutInflater`() {
        testData.adapterSpy.onCreateViewHolder(testData.parentViewGroupMock, 0)

        verify {
            LayoutInflater
                    .from(testData.parentViewGroupMock.context)
                    .inflate(LAYOUT, testData.parentViewGroupMock, false)
        }
    }

    @Test fun `onCreateViewHolder should call getViewHolder`() {
        testData.adapterSpy.onCreateViewHolder(testData.parentViewGroupMock, 0)

        verify {
            testData.adapterSpy.getViewHolder(testData.layoutInflaterInflateRet)
        }
    }

    @Test fun `onCreateViewHolder returns getViewHolder return value`() {
        Assert.assertEquals(
            testData.getViewHolderRet,
            testData.adapterSpy.onCreateViewHolder(testData.parentViewGroupMock, 0)
        )
    }

    // TODO: finish testing class
}