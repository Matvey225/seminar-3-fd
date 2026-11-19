package seminar.task04

abstract class Delivery(
    val destination: String) {
    init {
       require(destination.isNotBlank())
    }

    abstract fun cost(weightKg: Int): Int

    fun label(weightKg: Int): String {
        return "Доставка в ${destination}: ${cost(weightKg)}"
    }
}

class Pickup(destination: String) : Delivery(destination) {
    override fun cost(weightKg: Int): Int = 0
}

class CourierDelivery(destination: String) : Delivery(destination) {
    override fun cost(weightKg: Int): Int {
        return 200 + (weightKg * 50)
    }
}

class ExpressDelivery(
    destination: String,
    val distanceKm: Int) : Delivery(destination) {
    override fun cost(weightKg: Int): Int {
        return 300 + (weightKg * 80) + (distanceKm * 20)
    }
}