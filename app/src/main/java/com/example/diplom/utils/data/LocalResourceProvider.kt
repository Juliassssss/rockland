package com.example.diplom.utils.data

import android.content.Context
import androidx.annotation.StringRes

class LocalResourceProvider(private val context: Context) : ILocalResourcesProvider {
    override fun getString(@StringRes id: Int): String {
        return context.getString(id)
    }

    override fun getStringByStringId(id: String): String {
        val idInt = context.resources.getIdentifier(id, "string", context.packageName)
        return context.getString(idInt)
    }

    override fun getInteger(id: Int): Int {
        return context.resources.getDimensionPixelSize(id)
    }

    override fun getStringFormatted(id: Int, vararg args: Any): String {
        return context.getString(id, args)
    }

}