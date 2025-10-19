package tat.mukhutdinov.concurrency

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.lang.Thread.sleep

fun main() {
    val myScope = CoroutineScope(Job() + Dispatchers.IO)

    println("${Thread.currentThread().name} - runBlocking function")

    myScope.launch {
        println("${Thread.currentThread().name} - launch function")

        withContext(Dispatchers.IO) {
            println("${Thread.currentThread().name} - withContext function")
            delay(1000)
            println("10 results found.")
        }

        println("${Thread.currentThread().name} - end of launch function")

        println("Loading...")
    }

    sleep(2000)
}


suspend fun getWeatherReport() = coroutineScope {
    val forecast = async { getForecast() }
    val temperature = async { getTemperature() }

    "${forecast.await()} ${temperature.await()}"
}

suspend fun getForecast(): String {
    delay(1000)
    return "Sunny"
}

suspend fun getTemperature(): String {
    delay(1000)
    return "30C"
}

