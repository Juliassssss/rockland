package com.example.diplom.model


data class DataStoreEntity(val key: String, val data: String) {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is DataStoreEntity) return false

        if (key != other.key) return false

        return true
    }

    override fun hashCode(): Int {
        return key.hashCode()
    }
}