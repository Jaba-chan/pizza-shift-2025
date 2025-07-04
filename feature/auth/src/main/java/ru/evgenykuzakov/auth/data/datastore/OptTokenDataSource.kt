package ru.evgenykuzakov.auth.data.datastore

import android.content.Context
import android.content.SharedPreferences
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

internal class OptTokenDataSource @Inject constructor(
    @ApplicationContext context: Context
) {
    private val sharedPreferences: SharedPreferences =
        context.getSharedPreferences(APP_PREFS, Context.MODE_PRIVATE)
    var authToken: String?
        get() = sharedPreferences.getString(APP_PREFS, null)
        set(value) {
            sharedPreferences.edit().putString(APP_PREFS, value).apply()
        }

    companion object {
        private const val APP_PREFS = "app_prefs"
    }
}