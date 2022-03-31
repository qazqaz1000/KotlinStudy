package oz.nckim.coroutinestudy.flow

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking
import oz.nckim.coroutinestudy.utils.myPrintln

fun simple2(): Flow<Int> = flow {
    for (i in 1..3) {
        Thread.sleep(100) // pretend we are computing it in CPU-consuming way
        myPrintln("Emitting $i")            //Dispatche worker 쓰레드에서 실행
        emit(i) // emit next value
    }
}.flowOn(Dispatchers.IO) // RIGHT way to change context for CPU-consuming code in flow builder

fun main() = runBlocking<Unit> {
    simple2().collect { value ->
        myPrintln("Collected $value")       // Main Thread 에서 실행
    }
}