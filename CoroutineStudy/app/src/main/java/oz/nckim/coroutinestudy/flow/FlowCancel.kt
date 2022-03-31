package oz.nckim.coroutinestudy.flow

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withTimeoutOrNull
import oz.nckim.coroutinestudy.utils.myPrintln

fun simple3(): Flow<Int> = flow {
    for (i in 1..3) {
        delay(100)
        myPrintln("Emitting $i")
        emit(i)
    }
}

// collect time out
fun main() = runBlocking<Unit> {
    withTimeoutOrNull(250) { // Timeout after 250ms
        simple3().collect { value -> myPrintln(value) }
    }
    myPrintln("Done")
}