package oz.nckim.coroutinestudy.utils

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis


fun myPrint(s : Any){
    val curThread : String = Thread.currentThread().toString()
    val funName = Thread.currentThread().stackTrace[3].methodName
    val printFormat : String = String.format("%-50s %-40s %s", curThread, funName, s)
    print(printFormat)
}

fun myPrintln(s : Any){
    val curThread : String = Thread.currentThread().toString()
    val funName = Thread.currentThread().stackTrace[3].methodName
    val printFormat : String = String.format("%-50s %-40s %s", curThread, funName, s)
    println(printFormat)
}

