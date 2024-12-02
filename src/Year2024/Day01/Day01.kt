package Year2024.Day01

import AoCLib.SomeDay
import Year2024.DayOf2024
import AoCLib.Collections.groupCount

import kotlin.math.absoluteValue

object Day01 : DayOf2024(1, "Historian Hysteria") {
    override fun first(): Any? {
        val ids = lines.map { it.split("""\s+""".toRegex()). map{ it.toInt() } }
        val ids1 = ids.map{ it.first() }
        val ids2 = ids.map{ it.last() }
        return ids1.sorted().zip(ids2.sorted())
            .sumOf { (a, b) -> (a - b).absoluteValue }
    }

    override fun second(): Any? {
        val ids = lines.map { it.split("""\s+""".toRegex()). map{ it.toInt() } }
        val ids1 = ids.map{ it.first() }
        val ids2 = ids.map{ it.last() }.groupCount()
        return ids1.sumOf { it * ids2.getOrDefault(it, 0) }
    }
}

fun main() = SomeDay.mainify(Day01)