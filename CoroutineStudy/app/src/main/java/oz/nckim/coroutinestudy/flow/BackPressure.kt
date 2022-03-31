package oz.nckim.coroutinestudy.flow

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking
import oz.nckim.coroutinestudy.utils.myPrintln
import kotlin.system.measureTimeMillis


var start = 0L
fun currTime() = System.currentTimeMillis()
fun emitter(): Flow<Int> = (1..5)
    .asFlow()
    .onStart{ start = currTime() }
    .onEach{
        delay(1000)
        myPrintln("Emit $it (${currTime() - start}ms)")
    }

fun main() = runBlocking{
    val time = measureTimeMillis{
        emitter()
            .flowOn(Dispatchers.IO)             // emit을 IO 쓰레드에서 함
            .buffer()                           // emit 계속 해서 buffer에 쌓아둠
            .conflate()                         // emit을 계속 발행하지만 처리 할 수 있는 가장 최근것만 처리
            .collect{
                myPrintln("Collect $it starts (${currTime() - start}ms) ")
                delay(3000)
                myPrintln("Collect $it ends (${currTime() - start}ms) ")
            }
    }
    myPrintln("Collected in $time ms")
}