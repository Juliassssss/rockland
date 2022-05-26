package com.example.diplom.model

data class Entry(
    val id: Long,
    val date: String,
    val startTime: String,
    val endTime: String,
    val sumPay: String,
    val isCarried: Boolean
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Entry) return false

        if (id != other.id) return false
        if (date != other.date) return false
        if (startTime != other.startTime) return false
        if (endTime != other.endTime) return false
        if (sumPay != other.sumPay) return false
        if (isCarried != other.isCarried) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id.hashCode()
        result = 31 * result + date.hashCode()
        result = 31 * result + startTime.hashCode()
        result = 31 * result + endTime.hashCode()
        result = 31 * result + sumPay.hashCode()
        result = 31 * result + isCarried.hashCode()
        return result
    }
}