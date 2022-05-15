package com.example.diplom.model

class Promotions(
    val id: Int,
    val title: String,
    val description: String,
    val image: String? = null,
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is News) return false

        if (id != other.id) return false
        if (title != other.title) return false
        if (description != other.description) return false
        if (image != other.image) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id.hashCode()
        result = 31 * result + title.hashCode()
        result = 31 * result + description.hashCode()
        result = 31 * result + image.hashCode()
        return result
    }
}