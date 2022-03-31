package oz.nckim.coroutinestudy.flow

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import oz.nckim.coroutinestudy.utils.myPrintln
import kotlin.system.measureTimeMillis


fun simple1(): Flow<Int> = flow {
    for (i in 1..3) {
        delay(100) // pretend we are asynchronously waiting 100 ms
        emit(i) // emit next value
    }
}

fun main() = runBlocking<Unit> {
    val time = measureTimeMillis {
        simple1().collect { value ->
            delay(300) // pretend we are processing it for 300 ms
            myPrintln(value)
        }
    }
    myPrintln("Collected in $time ms")
}