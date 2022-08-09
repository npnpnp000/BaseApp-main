package com.appa.view.fragment.splash.viewmodel

import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import androidx.lifecycle.*
import com.appa.data.repositories.MessagesRepository
import kotlinx.coroutines.launch


class SplashViewModel(
    private val messagesRepository: MessagesRepository,
    private val connectivityManager: ConnectivityManager?
) : ViewModel() {

    var isDataReady: MutableLiveData<Boolean> = MutableLiveData(false)
    var internetConnectionAvailable: MutableLiveData<Boolean> = MutableLiveData(false)

    init {
        checkInternetConnectivity()
    }

    fun getComments() = viewModelScope.launch {
        isDataReady.value = messagesRepository.getComments().isNotEmpty()
    }

    private fun checkInternetConnectivity() {
        if (connectivityManager == null) {
            internetConnectionAvailable.value = false
            return
        }
        val capabilities = connectivityManager.getNetworkCapabilities(connectivityManager.activeNetwork) ?: return
        if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR)) {
            internetConnectionAvailable.value = true
        } else if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI)) {
            internetConnectionAvailable.value = true
        } else if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET)) {
            internetConnectionAvailable.value = true
        } else if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_VPN)) {
            internetConnectionAvailable.value = true
        }

    }

}
