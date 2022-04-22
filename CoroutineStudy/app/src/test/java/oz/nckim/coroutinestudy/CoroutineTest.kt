package oz.nckim.coroutinestudy

import androidx.activity.viewModels
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.*
import kotlinx.coroutines.test.TestDispatcher
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import oz.nckim.coroutinestudy.views.scope.ScopeViewModel

//@ExperimentalCoroutinesApi
@ExtendWith(CoroutinesTestExtension::class)
class CoroutineTest {
    private val dispatcher: TestDispatcher = UnconfinedTestDispatcher()
    private lateinit var scopeViewModel: ScopeViewModel

    @BeforeEach
    fun setUp(){
        Dispatchers.setMain(dispatcher)
        scopeViewModel = ScopeViewModel()
    }

    @Test
    fun `더하기`(){

        scopeViewModel.counterPlus(3)

        assertThat(scopeViewModel.counter.value).isEqualTo(3)
    }

    @Test
    fun `더하기 livedata`() = runBlocking {
        withContext(Dispatchers.Main){
            println("1")
            async {
                println("2")
                scopeViewModel.counterPlus2(3)
                println("3")
                assertThat(scopeViewModel.pp.value).isEqualTo(3)
            }
            println("4")

            println("5")
        }



    }

    @AfterEach
    fun clear(){
        Dispatchers.resetMain()
    }

}