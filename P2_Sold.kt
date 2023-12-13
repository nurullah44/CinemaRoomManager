fun main() {
    println("Enter the number of rows:")
    val rows = readln().toInt()
    println("Enter the number of seats in each row:")
    val SeatsInRows = readln().toInt()
    val total = rows * SeatsInRows
    var profit = 0

    if ( total <= 60 ) {
        profit = total * 10
    } else {
        profit = (rows / 2) * 10 * SeatsInRows + (rows - rows / 2) * 8 * SeatsInRows
    }
    println("Total income:\n$$profit")
}