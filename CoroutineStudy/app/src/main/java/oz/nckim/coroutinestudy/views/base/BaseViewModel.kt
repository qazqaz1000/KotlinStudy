package oz.nckim.coroutinestudy.views.base

import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job

abstract class BaseViewModel : ViewModel() {

    private val tag : String  get() = javaClass.name

    private val job = Job()

    /**
     * CoroutineScope의 생명주기는 ScopeViewModel를 따라감
     * viewModel이 소멸되는 시점인 onCleared()에서  job.cancel()을 호출해줘야함
     */
    val viewModelScope = CoroutineScope(Dispatchers.Main + job)



    fun print(s : String){
        val curThread : String = Thread.currentThread().toString()
        val funName = Thread.currentThread().stackTrace[3].methodName
        val printFormat : String = String.format("%-50s %-40s %s", curThread, funName, s)
        Log.d(tag, printFormat)
    }

    override fun onCleared() {
        super.onCleared()
        print("ViewModel Scope Cancel")
        job.cancel()
    }
}