package com.appa.utils.factories

import android.net.ConnectivityManager
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.appa.data.repositories.MessagesRepository
import com.appa.view.fragment.dashboard.viewmodel.MainViewModel
import com.appa.view.fragment.splash.viewmodel.SplashViewModel

@Suppress("UNCHECKED_CAST")
class ViewModelFactory(
    private val messagesRepository: MessagesRepository,
    private val connectivityManager: ConnectivityManager? = null
) : ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel> create(modelClass: Class<T>): T =
        when (modelClass) {
            MainViewModel::class.java -> MainViewModel(messagesRepository) as T
            SplashViewModel::class.java -> SplashViewModel(
                messagesRepository,
                connectivityManager
            ) as T
            else -> throw Exception("ViewModel not found")
        }
}