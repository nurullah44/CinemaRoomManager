fun main() {
    println("Enter the number of rows:")
    val rows = readln().toInt()
    println("Enter the number of seats in each row:")
    val SeatsInRows = readln().toInt()
    var sList = MutableList(rows){MutableList(SeatsInRows){"S"}}
    fun show_menu() {
        println("1. Show the seats\n2. Buy a ticket\n0. Exit")
    }
    fun show_Seat() {
        println("Cinema:")
        print("  ")
        for (i in 1..SeatsInRows) print("$i ")
        println()
        for (i in sList.indices) println("${i+1} ${sList[i].joinToString(" ")}")
        println()
    }
    fun buyTicket() {
        println("Enter a row number:")
        val rowN = readln().toInt()
        println("Enter a seat number in that row:")
        val seatN = readln().toInt()
        val total = rows * SeatsInRows
        var price = 0
        when {
            total <= 60 -> price = 10
            total > 60 && rowN <= 4 -> price = 10
            else -> price = 8
        }
        println("Ticket price: $$price")
        sList[rowN-1][seatN-1] = "B"
    }
    while (true) {
        show_menu()
        val option = readln()
        when (option){
            "1" -> show_Seat()
            "2" -> buyTicket()
            "0" -> break
        }
    }
}