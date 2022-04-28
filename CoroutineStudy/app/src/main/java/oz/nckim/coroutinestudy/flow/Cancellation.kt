package oz.nckim.coroutinestudy.flow

import kotlinx.coroutines.*
import java.io.Closeable

/**
 * 출처 : https://myungpyo.medium.com/%EC%BD%94%EB%A3%A8%ED%8B%B4-%EA%B3%B5%EC%8B%9D-%EA%B0%80%EC%9D%B4%EB%93%9C-%EC%9E%90%EC%84%B8%ED%9E%88-%EC%9D%BD%EA%B8%B0-part-2-ccd47699b520
 * 코루틴 중단에 대해서
 */
fun default() = runBlocking {
    val job = launch(Dispatchers.Default) {
        for (i in 1..10) {
            println("I'm sleeping $i ...")
            Thread.sleep(500L)
        }
    }

    delay(1300L)
    println("main : I'm tired of waiting!")
    job.cancelAndJoin()
    println("main : Now I can quit.")
}

fun myYield() = runBlocking {
    val job = launch {
        for (i in 1..10) {
            yield()
            println("I'm sleeping $i ...")
            Thread.sleep(500L)
        }
    }

    delay(1300L)
    println("main : I'm tired of waiting!")
    job.cancelAndJoin()
    println("main : Now I can quit.")
}

fun myIsActive() = runBlocking {
    val job = launch(Dispatchers.Default) {
        for (i in 1..10) {
            if (!isActive) {
                break
            }
            println("I'm sleeping $i ...")
            Thread.sleep(500L)
        }
    }

    delay(1300L)
    println("main : I'm tired of waiting!")
    job.cancelAndJoin()
    println("main : Now I can quit.")
}

fun myTryFinally() = runBlocking {
    val job = launch {
        try {
            repeat(1000) { i ->
                println("I'm sleeping $i ...")
                delay(500L)
            }
        } finally {
            println("main : I'm running finally!")
        }
    }

    delay(1300L)
    println("main : I'm tired of waiting!")
    job.cancelAndJoin()
    println("main : Now I can quit.")
}

fun myUse() = runBlocking {
    val job = launch {
        SleepingBed().use {
            it.sleep(1000)
        }
    }

    delay(1300L)
    println("main : I'm tired of waiting!")
    job.cancelAndJoin()
    println("main : Now I can quit.")
}

class SleepingBed : Closeable {

    suspend fun sleep(times: Int) {
        repeat(times) { i ->
            println("I'm sleeping $i ...")
            delay(500L)
        }
    }

    override fun close() {
        println("main : I'm running close() in SleepingBed!")
    }

}

/**
 * 취소 불가능한 코드 블록의 실행 (Run non-cancellable block)
 * 이미 CancellableException 이 발생한 코루틴의 finally 블록 안에서 중단 함수를 호출하면 현재 코루틴은 이미 취소된 상태이기 때문에 CancellationException 이 발생합니다.
 * 보통 리소스를 정리하는 함수들은 넌-블럭킹(Non-Blocking) 으로 동작하기 때문에 이러한 제약이 큰 문제가 되지는 않습니다.
 * 하지만 이미 취소된 코루틴 안에서 동기적으로 어떤 중단 함수를 호출해야 하는 상황이라면 우리는 withContext{ } 코루틴 빌더에 NonCancellable 컨텍스트를 전달하여 이를 처리할 수 있습니다.
 */
fun myNonCancellable() = runBlocking {
    val job = launch {
        try {
            repeat(1000) { i ->
                println("I'm sleeping $i ...")
                delay(500L)
            }
        } finally {
            withContext(NonCancellable) {
                delay(1000)
                println("main : I'm running finally!")
            }
        }
    }

    delay(1300L)
    println("main : I'm tired of waiting!")
    job.cancelAndJoin()
    println("main : Now I can quit.")
}

fun myWithTimeout() = runBlocking<Unit> {
    withTimeout(1300L) {
        launch {
            try {
                repeat(1000) { i ->
                    println("I'm sleeping $i ...")
                    delay(500L)
                }
            } finally {
                println("main : I'm running finally!")
            }
        }
    }
}

fun main() = runBlocking {
    default()

    println("===========================")

    myYield()

    println("===========================")

    myIsActive()

    println("===========================")

    myTryFinally()

    println("===========================")

    myUse()

    println("===========================")

    myNonCancellable()

    println("===========================")

    myWithTimeout()
}