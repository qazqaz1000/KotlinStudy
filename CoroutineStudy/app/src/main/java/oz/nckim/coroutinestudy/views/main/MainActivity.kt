package oz.nckim.coroutinestudy.views.main

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*
import oz.nckim.coroutinestudy.R
import oz.nckim.coroutinestudy.views.base.BaseActivity
import oz.nckim.coroutinestudy.views.scope.ScopeActivity

/**
 * MainActivity
 * GlobalScope Study
 */
class MainActivity : BaseActivity() {
    lateinit var buttons : Array<Button>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()
    }

    private fun initViews(){
        buttons = arrayOf(
            btn_run_activity,
            btn_run1,
            btn_run2,
            btn_run3,
            btn_run4,
            btn_run5,
            btn_run6,
            btn_run7,
            btn_run8
        )

        buttons.forEach {
            it.setOnClickListener(onClickListener)
        }
    }

    private val onClickListener : View.OnClickListener =View.OnClickListener { view->
        when(view.id){
            R.id.btn_run1 -> runGlobalScopeDefault()                     //Thread[DefaultDispatcher-worker-1,5,main]
            R.id.btn_run2 -> runGlobalScopeParam(Dispatchers.Main)     //Thread[main,5,main]
            R.id.btn_run3 -> runGlobalScopeParam(Dispatchers.IO)       //Thread[DefaultDispatcher-worker-1,5,main]
            R.id.btn_run4 -> runGlobalScopeParam(Dispatchers.Default)  //Thread[DefaultDispatcher-worker-1,5,main]
            R.id.btn_run5 -> runGlobalScopeAwait()  //Thread[DefaultDispatcher-worker-1,5,main]
            R.id.btn_run6 -> runSuspendFun()  //Thread[DefaultDispatcher-worker-1,5,main]
            R.id.btn_run_activity -> {

                startActivity(Intent(this, ScopeActivity::class.java))
            }

        }
    }

    /**
     * GlobalScope.launch
     * thread name : DefaultDispatcher-worker
     *
     * GlobalScope.launch 함수의 기본은 Dispatchers.Default
     */
    private fun runGlobalScopeDefault(){
        print("start")
        GlobalScope.launch {
            delay(1000)
            print("GlobalScope Launch")
        }
        print("end")
    }

    /**
     * GlobalScope.launch(coroutineDispatcher : CoroutineDispatcher)
     *
     * Dispatchers.Main
     * thread name : main
     *
     * Dispatchers.IO
     * thread name : DefaultDispatcher-worker
     *
     * Dispatchers.Default
     * thread name : DefaultDispatcher-worker
     *
     * Dispatchers.Main인경우 UI 제어 가능
     */
    private fun runGlobalScopeParam(coroutineDispatcher: CoroutineDispatcher){
        print("start")
        GlobalScope.launch(coroutineDispatcher) {
            delay(1000)
            print("GlobalScope Launch $coroutineDispatcher")
        }
        print("end")
    }

    /**
     * GlobalScope.async
     * GlobalScope.launch 와 동일함 main, io, default 선택 가능
     * GlobalScope.launch 와 다르게 Deferred<T> 클래스를 리턴함.
     * Deffered<T> 클래스는 await() 메소드를 제공하고 T타입 객체를 리턴함.
     * async{ ... }.await() 는 withConext{ ... } 구문과 동일함
     * 코루틴 내에서도 thread를 다르게 호출 할 수 있음
     */
    private fun runGlobalScopeAwait(){
        print("start")
        GlobalScope.launch {        //default thread에서 실행
            launch(Dispatchers.Main) {      //main thread에서 실행
                print("Launch") //print main
            }
            delay(1000)
            val value = async(Dispatchers.Main) {      //main thread에서 실행
                print("I am async") //print main
                "async waiting ..."
            }
            print(value.await())    //print DefaultDispatcher-worker

            delay(1000)
            val value2 : String =
                withContext(Dispatchers.IO) {      //io thread에서 실행
                    print("I am withContext") //print DefaultDispatcher-worker
                    "withContext waiting ..."
                }
            print(value2)
        }
        print("end")
    }

    /**
     * 일반 runSuspendFun() 함수 실행
     * GlobalScope.launch 코루틴 실행
     * 일반 runSuspendFun() 함수 종료
     * doSomething() suspend 함수 실행
     * doSomething() suspend 함수 종료
     * GlobalScope.launch 코루틴 종료
     *
     * 코루틴에서는 일반 함수를 호출 할 수 없다.
     * 함수에 유예한다는 suspend 키워드를 사용해야함
     */
    private fun runSuspendFun(){
        print("start")
        GlobalScope.launch {
            print("hi")
            doSomething()
            print("bye")
        }
        print("end")
    }
    private suspend fun doSomething(){
        print("start")
        delay(1000)
        print("end")
    }




}