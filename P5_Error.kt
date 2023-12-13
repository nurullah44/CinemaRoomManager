fun main() {
    println("Enter the number of rows:")
    val rows = readln().toInt()
    println("Enter the number of seats in each row:")
    val SeatsInRows = readln().toInt()
    var sList = MutableList(rows){MutableList(SeatsInRows){"S"}}
    var numberOfPurchTickets = 0
    var currentIncome = 0
    var totalIncome = 0
    fun totalIncome(): Int {
        if ( rows * SeatsInRows <= 60 ) {
            totalIncome = rows * SeatsInRows * 10
        } else {
            totalIncome = (rows / 2) * 10 * SeatsInRows + (rows - rows / 2) * 8 * SeatsInRows
        }
        return totalIncome
    }
    fun show_menu() {
        println("1. Show the seats\n2. Buy a ticket\n3. Statistics\n0. Exit")
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
        if (rowN > rows || seatN > SeatsInRows) {
            println("Wrong input!")
            buyTicket()
        }
        else {
            if ( sList[rowN - 1][seatN - 1] != "B") {
                val total = rows * SeatsInRows
                var price = 0
                when {
                    total <= 60 -> price = 10
                    total > 60 && rowN <= 4 -> price = 10
                    else -> price = 8
                }
                println("Ticket price: $$price")
                sList[rowN - 1][seatN - 1] = "B"
                numberOfPurchTickets += 1
                currentIncome += price
            } else {
                println("That ticket has already been purchased!")
                buyTicket()
            }
        }
    }
    fun getStats() {
        val percentage = "%.2f".format((numberOfPurchTickets * 100) / (rows * SeatsInRows).toDouble())
        println("Number of purchased tickets: $numberOfPurchTickets\nPercentage: $percentage%\nCurrent income: $$currentIncome\nTotal income: $${totalIncome()}\n")
    }
    while (true) {
        show_menu()
        val option = readln()
        when (option){
            "1" -> show_Seat()
            "2" -> buyTicket()
            "3" -> getStats()
            "0" -> break
        }
    }
}