package com.example.diplom.utils.usecase

import com.example.diplom.model.Entry
import com.example.diplom.utils.data.PreferencesStorage

class EntryUseCase(private val prefStorage: PreferencesStorage) {

    fun loadEntry(): List<Entry> {
        return listOf(
            Entry(1, "12 марта", "12:40", "14:40", "1300", true),
            Entry(2, "21 сентебря", "12:40", "14:40", "1300", true),
            Entry(3, "10 мая", "12:40", "14:40", "1600", false),
            Entry(4, "21 марта", "12:40", "14:40", "1370", false),
            Entry(5, "12 апреля", "12:40", "14:40", "1500", true),
            Entry(6, "15 марта", "16:40", "14:40", "1700", false),
            Entry(7, "18 июня", "12:30", "14:40", "1740", true),
            Entry(8, "20 июнь", "17:40", "14:40", "1200", true),
            Entry(19, "12 июля", "10:00", "14:40", "1350", false),
        )
    }
}