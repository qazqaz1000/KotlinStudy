package oz.nckim.coroutinestudy.views.first

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import oz.nckim.coroutinestudy.R
import oz.nckim.coroutinestudy.views.base.BaseActivity

class FirstActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)
        print("hi first")
    }
}