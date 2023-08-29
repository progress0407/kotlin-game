package app

fun <T> permutation(elements: List<T>, r: Int): List<List<T>> {
    if (r > elements.size) return emptyList()
    if (r == 0) return listOf(emptyList())

    return elements.flatMap { element ->
        permutation(elements - element, r - 1).map { listOf(element) + it }
    }
}

fun main() {
    val list = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9)
    val r = 3
    val permutations = permutation(list, r)
    for (perm in permutations) {
        println(perm)
    }
}
