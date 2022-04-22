package oz.nckim.coroutinestudy.flow

import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.runBlocking
import oz.nckim.coroutinestudy.utils.myPrintln

class TTest{
    lateinit var sss: String;
    fun testFun(){
        print("gd $sss")
    }
}

fun main(){
    TTest().testFun()
}