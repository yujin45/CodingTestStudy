import java.util.*
import kotlin.math.abs

fun gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)

fun main() {
    val br = System.`in`.bufferedReader()
    val (N, S) = br.readLine().split(" ").map { it.toInt() }
    val A = br.readLine().split(" ").map { abs(it.toInt() - S) }

    println(A.reduce(::gcd))
}
