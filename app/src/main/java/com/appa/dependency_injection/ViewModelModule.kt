package com.appa.dependency_injection

import android.content.Context
import android.net.ConnectivityManager
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.appa.utils.application.App
import com.appa.utils.factories.ViewModelFactory
import com.appa.view.fragment.dashboard.viewmodel.MainViewModel
import com.appa.view.fragment.splash.viewmodel.SplashViewModel

object ViewModelModule {

    inline fun <reified VM : ViewModel> provideViewModel(fragment: Fragment): Lazy<VM> {
        val viewModelFactory = when (VM::class.java) {
             SplashViewModel::class.java -> {
                val connectivityManager = App.getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
                ViewModelFactory(RepositoryModule.provideMessagesRepository(), connectivityManager)
            }
            MainViewModel::class.java -> {
                ViewModelFactory(RepositoryModule.provideMessagesRepository())
            }
            else -> throw RuntimeException("ViewModel does not exist")
        }
        return lazy { ViewModelProvider(fragment, viewModelFactory)[VM::class.java] }
    }
}