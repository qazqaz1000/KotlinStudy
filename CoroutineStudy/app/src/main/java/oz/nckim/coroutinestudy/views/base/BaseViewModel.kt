package oz.nckim.coroutinestudy.views.base

import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel

abstract class BaseViewModel : ViewModel() {
    private val tag : String  get() = javaClass.name
    fun print(s : String){
        val curThread : String = Thread.currentThread().toString()
        val funName = Thread.currentThread().stackTrace[3].methodName
        val printFormat : String = String.format("%-50s %-40s %s", curThread, funName, s)
        Log.d(tag, printFormat)
    }
}