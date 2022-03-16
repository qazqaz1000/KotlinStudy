package oz.nckim.coroutinestudy.views.scope

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.*
import oz.nckim.coroutinestudy.views.base.BaseViewModel


class ScopeViewModel : BaseViewModel() {
    private val job = Job()

    /**
     * CoroutineScope의 생명주기는 ScopeViewModel를 따라감
     * viewModel이 소멸되는 시점인 onCleared()에서  job.cancel()을 호출해줘야함
     */
    private val viewModelScope = CoroutineScope(Dispatchers.Main + job)

    fun runViewModelScope(){
        print("start")
        viewModelScope.launch {
            for (i : Int in 1 .. 5){
                delay(1000)
                print("i am ViewModel Scope ... $i")
            }
        }
        print("end")
    }

    override fun onCleared() {
        super.onCleared()
        print("ViewModel Scope Cancel")
        job.cancel()
    }
}