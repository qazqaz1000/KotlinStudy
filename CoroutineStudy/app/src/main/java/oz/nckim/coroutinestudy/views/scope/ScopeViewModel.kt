package oz.nckim.coroutinestudy.views.scope

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import oz.nckim.coroutinestudy.views.base.BaseViewModel


class ScopeViewModel : BaseViewModel() {


    private var _counter = MutableStateFlow(0)
    val counter = _counter.asStateFlow()

    private var _pp = MutableLiveData(0)
    val pp: LiveData<Int> = _pp

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

    fun counterPlus(number: Int){
        _counter.value = _counter.value?.plus(number)
    }

    fun counterPlus2(number: Int) = runBlocking {
        viewModelScope.launch(Dispatchers.Main) {
            _pp.value = _pp.value?.plus(number)
        }
    }

}