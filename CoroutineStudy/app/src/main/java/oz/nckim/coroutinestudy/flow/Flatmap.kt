package oz.nckim.coroutinestudy.flow

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withTimeoutOrNull
import oz.nckim.coroutinestudy.utils.myPrintln

fun sampleFlow(): Flow<Int> = flow {
    emit(1)
    emit(5)
}

// collect time out
fun main() = runBlocking<Unit> {
    myPrintln("concat")
    sampleFlow().flatMapConcat { value ->
        flow{
            emit(value + 1)
            delay(1000)
            emit(value + 2)
            emit(value + 3)
        }
    }.collect {
        myPrintln(it)
        /**
         * 2
         * 3
         * 4
         * 6
         * 7
         * 8
         */
    }
    myPrintln("lastest")
    sampleFlow().flatMapLatest { value ->
        flow{
            emit(value + 1)
            delay(1000)
            emit(value + 2)
            emit(value + 3)
        }
    }.collect {
        myPrintln(it)
        /**
         * 2
         * 6
         * 7
         * 8
         */
    }
    myPrintln("merge")
    sampleFlow().flatMapMerge { value ->
        flow{
            emit(value + 1)
            delay(1000)
            emit(value + 2)
            emit(value + 3)
        }
    }.collect {
        myPrintln(it)
        /**
         * 2
         * 6
         * 3
         * 4
         * 7
         * 8
         */
    }
}