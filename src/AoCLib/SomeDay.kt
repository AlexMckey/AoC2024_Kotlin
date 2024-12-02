package AoCLib

import java.io.File
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

/**
 * Abstract class representing solution for [day]s problem in specified [year].
 */
open class SomeDay(val year: Int, val day: Int, val title: String = "") {
    private val inputDir = "d:\\YandexDisk\\DevsExercises\\AoC\\AoCInput\\$year\\"
    //private val inputDir = "C:\\Users\\MakievskyAV\\Desktop\\Devs\\AoC_2020\\PuzzleInput\\"
    private val filepath = inputDir + "day${day.toString().padStart(2,'0')}.txt"

    open val localData: String? = null

    val data: String by lazy {
        localData ?: runBlocking { File(filepath).bufferedReader().readText().trim() }
    }

    val lines: List<String> by lazy { data.toStrs() }
    val ints: List<Int> by lazy { data.toInts() }
    val longs: List<Long> by lazy { data.toLongs() }
    val matrix: List<List<Char>> by lazy { lines.map { it.toList() } }
    val blocks: List<String> by lazy { data.splitByBlankLines() }

    open fun first(): Any? = null

    open fun second(): Any? = null

    companion object {
        fun mainify(someday: SomeDay) {
            with(someday) {
                println("Year $year, Day $day : ${title.ifEmpty { "" }}")
                measureTimeMillis {
                    println("First: ${first()?.toString() ?: "unsolved"}")
                }.run {
                    println("Time: ${this}ms")
                }
                measureTimeMillis {
                    println("Second: ${second()?.toString() ?: "unsolved"}")
                }.run {
                    println("Time: ${this}ms")
                }
            }
        }
    }
}