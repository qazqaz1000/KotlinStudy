package oz.nckim.coroutinestudy.views.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*
import oz.nckim.coroutinestudy.R
import oz.nckim.coroutinestudy.views.base.BaseActivity
import oz.nckim.coroutinestudy.views.first.FirstActivity

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
            R.id.btn_run_activity -> {

                startActivity(Intent(this, FirstActivity::class.java))
            }

        }
    }

    private fun runGlobalScopeDefault(){
        print("start")
        GlobalScope.launch {
            delay(1000)
            print("GlobalScope Launch")
        }
        print("end")
    }

    private fun runGlobalScopeParam(coroutineDispatcher: CoroutineDispatcher){
        print("start")
        GlobalScope.launch(coroutineDispatcher) {
            delay(1000)
            print("GlobalScope Launch $coroutineDispatcher")
        }
        print("end")
    }


}