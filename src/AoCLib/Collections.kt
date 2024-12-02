package AoCLib.Collections

fun <T> Iterable<T>.groupCount(): Map<T, Int> = this.groupingBy { it }.eachCount()
