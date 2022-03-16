package oz.nckim.coroutinestudy.views.scope

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import kotlinx.android.synthetic.main.activity_scope.*
import kotlinx.coroutines.*
import oz.nckim.coroutinestudy.R
import oz.nckim.coroutinestudy.views.base.BaseActivity
import kotlin.coroutines.CoroutineContext

class ScopeActivity : BaseActivity(), CoroutineScope, View.OnClickListener {
    private val viewModel : ScopeViewModel by viewModels()

    private lateinit var job: Job

    /**
     * CoroutineContext 를 override 함으로써
     * CoroutineScope의 생명주기는 ScopeActivity와 동일함
     * onDestroy() 에서  job.cancel()을 실행해줘야함
     */
    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main + job


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scope)

        btn_cancel.setOnClickListener(this)
        btn_exception1.setOnClickListener(this)
        btn_exception2.setOnClickListener(this)
        btn_exception3.setOnClickListener(this)
        btn_exception4.setOnClickListener(this)

        job = Job()
        runActivityScope()
    }

    /**
     * 생명주기가 Activity와 동일한 코루틴을 실행함
     * 1초간격으로 5번 print 하는 사이에 Activity를 destroy 할 경우 실행중인 코루틴 정지
     */
    private fun runActivityScope(){
        print("start")
        launch {
            for (i : Int in 1 .. 5){
                delay(1000)
                print("i am Activity Scope ... $i")
            }
        }
        viewModel.runViewModelScope()
        print("end")
    }

    /**
     * 코루틴 실행중 Exception 발생시 앱 죽음
     */
    private fun runException1(){
        print("start")
        launch {
            print("launch")
            throw Exception()
        }
        print("end")
    }
    /**
     * runException1의 앱 죽는 현상을 대처 가능하지만
     * 코루틴 내부의 try catch를 했을 뿐 코루틴은 종료되지 않음
     * hi 실행되고 bye 실행됨
     */
    private fun runException2(){
        print("start")
        launch {
            print("hi")
            try{
                print("launch")
                throw Exception()
                print("launch2")
            }catch( e: java.lang.Exception) {
                print("exception " + e)
            }
            print("bye")
        }
        print("end")
    }

    /**
     * 예외 발생시 코루틴을 종료시키려면 CoroutineExceptionHandler 를 사용해야함
     * 코루틴 종료 후 Activiy Scope 코루틴을 사용하려면 job 을 다시 만들어줘야함
     * hi 실행되고 bye 실행되지않음
     */
    private fun runException3(){
        print("start")
        val handler = CoroutineExceptionHandler { _, throwable ->
            print("exception : $throwable")
            job = Job()
        }
        launch(Dispatchers.Main + handler) {
            print("hi")
            throw Exception()
            print("bye")
        }
        print("end")
    }

    /**
     * 예외 발생시 코루틴을 종료시키려면 CoroutineExceptionHandler 를 사용해야함
     * 코루틴 종료 후 Activiy Scope 코루틴을 사용하려면 job 을 다시 만들어줘야함
     * hi 실행되고 bye 실행되지않음
     */
    private fun runException4(){
        print("start")
        val handler = CoroutineExceptionHandler { _, throwable ->
            print("exception : $throwable")
            job = Job()
        }
        launch(Dispatchers.Main + handler) {
            print("hi")
            withContext(Dispatchers.Main){
                print("withContext")
                throw Exception()
            }
            print("bye")
        }
        print("end")
    }

    override fun onDestroy() {
        super.onDestroy()
        print("Activity Scope Cancel")
        job.cancel()
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.btn_cancel -> this.finish()
            R.id.btn_exception1 -> runException1()
            R.id.btn_exception2 -> runException2()
            R.id.btn_exception3 -> runException3()
            R.id.btn_exception4 -> runException4()
        }
    }

}