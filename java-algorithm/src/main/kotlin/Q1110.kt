import java.util.*

fun main(args: Array<String>) {
    val sc: Scanner = Scanner(System.`in`)
    var variable = sc.nextInt()
    val origin = variable
    var count = 0

    while (true) {
        ++count
        variable = proceed(variable)
        if (origin == variable) {
            println(count)
            return
        }
    }
}

fun proceed(variable: Int): Int {
    val left = variable % 10
    val right = (left + variable / 10) % 10
    return left * 10 + right
}
