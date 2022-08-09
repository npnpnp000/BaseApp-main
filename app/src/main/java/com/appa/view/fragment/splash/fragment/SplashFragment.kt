package com.appa.view.fragment.splash.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.appa.R
import com.appa.databinding.FragmentSplashBinding
import com.appa.utils.extensions.provideViewModel
import com.appa.view.fragment.splash.viewmodel.SplashViewModel


class SplashFragment : Fragment() {

    var binding: FragmentSplashBinding? = null

    private val splashViewModel: SplashViewModel by provideViewModel()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentSplashBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        observeDataReadyNavigation()
        observerInternetConnection()
    }

    private fun observeDataReadyNavigation() {
        splashViewModel.isDataReady.observe(viewLifecycleOwner) { isDataReady ->
            if (isDataReady.not()) return@observe
            navigateToDashboard()
        }
    }

    private fun navigateToDashboard() {
        findNavController().navigate(SplashFragmentDirections.actionSplashFragmentToMainFragment())
    }

    private fun observerInternetConnection() {
        splashViewModel.internetConnectionAvailable.observe(viewLifecycleOwner) { isInternetConnectionAvailable ->
            if (isInternetConnectionAvailable) {
                splashViewModel.getComments()
                return@observe
            }
            startErrorDialog()
        }
    }

    private fun startErrorDialog() {
        val alertDialog: AlertDialog = AlertDialog.Builder(requireContext()).create()
        alertDialog.apply {
            setTitle(getString(R.string.error))
            setMessage(requireContext().getString(R.string.internet_connection_error))
            setButton(
                AlertDialog.BUTTON_NEUTRAL, getString(R.string.ok)
            ) { dialog, _ ->
                dialog.dismiss()
                activity?.finish()
            }
            show()
        }
    }

    override fun onDestroyView() {
        binding = null
        super.onDestroyView()
    }
}
