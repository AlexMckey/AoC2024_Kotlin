package Year2024.Day01

import AoCLib.SomeDay
import Year2024.DayOf2024
import AoCLib.Collections.groupCount

import kotlin.math.absoluteValue

object Day01 : DayOf2024(1, "Historian Hysteria") {
    private fun readInput(): Pair<List<Int>,List<Int>> =
        lines
            .map { it.split("""\s+""".toRegex())
                .map{ it.toInt() }
                .let { it[0] to it[1] } }
            .unzip()


    override fun first(): Any? {
        val (ids1, ids2) = readInput()
        return ids1.sorted().zip(ids2.sorted())
            .sumOf { (a, b) -> (a - b).absoluteValue }
    }

    override fun second(): Any? {
        val (ids1, ids2) = readInput()
        val ids2Cnt = ids2.groupingBy { it }.eachCount()
        return ids1.sumOf { it * ids2Cnt.getOrDefault(it, 0) }
    }
}

fun main() = SomeDay.mainify(Day01)