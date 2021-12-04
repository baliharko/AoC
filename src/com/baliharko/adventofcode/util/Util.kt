package com.baliharko.adventofcode.util

import kotlin.Throws
import java.io.IOException
import java.nio.charset.StandardCharsets
import java.nio.file.Files
import java.nio.file.Paths
import java.util.concurrent.TimeUnit
import kotlin.system.measureNanoTime

object Util {
    @JvmStatic
    @Throws(IOException::class)
    fun readFile(path: String): List<String> {
        return Files.readAllLines(Paths.get("src/resources$path"), StandardCharsets.UTF_8)
    }

    fun measure(block: () -> Unit) {
        val nanos = measureNanoTime(block)
        val millis = TimeUnit.NANOSECONDS.toMillis(nanos)
        print("\nTime: $millis ms")
    }
}