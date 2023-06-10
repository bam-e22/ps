class UndergroundSystem() {
    private val customers = mutableMapOf<Int, Pair<String, Int>>()
    private val table = mutableMapOf<Pair<String, String>, Pair<Double, Int>>()

    fun checkIn(id: Int, stationName: String, t: Int) {
        customers[id] = stationName to t
    }

    fun checkOut(id: Int, stationName: String, t: Int) {
        val customer = customers[id]
        checkNotNull(customer)
        val startStation = customer.first
        val startTime = customer.second

        if (table.contains(startStation to stationName)) {
            val history = table[startStation to stationName]
            checkNotNull(history)
            val previousAve = history.first
            val totalCount = history.second + 1
            table[startStation to stationName] = (previousAve * ((totalCount - 1) / totalCount.toDouble()) + (t - startTime) * (1 / totalCount.toDouble())) to totalCount
        } else {
            table[startStation to stationName] = (t - startTime).toDouble() to 1
        }
    }

    fun getAverageTime(startStation: String, endStation: String): Double {
        return table[startStation to endStation]?.first ?: 0.0
    }
}

fun main() {
    val u = UndergroundSystem()
    u.checkIn(45,"Leyton",3)
    u.checkIn(32,"Paradise",8)
    u.checkIn(27,"Leyton",10)
    u.checkOut(45,"Waterloo",15)
    u.checkOut(27,"Waterloo",20)
    u.checkOut(32,"Cambridge",22)
    u.getAverageTime("Paradise","Cambridge").let {
        println(it)
    }
    u.getAverageTime("Leyton","Waterloo").let {
        println(it)
    }
}


// answer 2
/*
class UndergroundSystem() {
    private val customers = mutableMapOf<Int, Customer>()
    private val table = TravelTimeTable()

    fun checkIn(id: Int, stationName: String, t: Int) {
        customers[id] = Customer(id, stationName, t)
    }

    fun checkOut(id: Int, stationName: String, t: Int) {
        val customer = customers[id]
        checkNotNull(customer)
        table.record(customer.startStation, stationName, t - customer.startTime)
    }

    fun getAverageTime(startStation: String, endStation: String): Double {
        return table.getAverageTime(startStation, endStation)
    }
}

data class Customer(
        val id: Int,
        val startStation: String,
        val startTime: Int
)

class TravelTimeTable {
    private val table = mutableMapOf<Pair<String, String>, History>()

    fun record(startStation: String, endStation: String, travelTime: Int) {
        val history = History(travelTime, 1)
        if (table[startStation to endStation] == null) {
            table[startStation to endStation] = history
        } else {
            table[startStation to endStation] = table[startStation to endStation]!! + history;
        }
    }

    fun getAverageTime(startStation: String, endStation: String): Double {
        val history = table[startStation to endStation]
        return history?.average ?: 0.0
    }
}

data class History(
        val totalTime: Int,
        val n: Int
) {
    val average: Double
        get() = totalTime.toDouble() / n

    operator fun plus(history: History?): History {
        return if (history == null) {
            this
        } else {
            History(totalTime + history.totalTime, n + history.n)
        }
    }
}


/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * var obj = UndergroundSystem()
 * obj.checkIn(id,stationName,t)
 * obj.checkOut(id,stationName,t)
 * var param_3 = obj.getAverageTime(startStation,endStation)
 */

 */
