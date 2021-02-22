package info.mylabstudio.tictactoe.presentation.splash

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import info.mylabstudio.tictactoe.R
import info.mylabstudio.tictactoe.presentation.OnNavigationListener
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


class SplashFragment(private val onNavigationListener: OnNavigationListener) :
    Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_splash, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        GlobalScope.launch {
            delay(2000)
            onNavigationListener.onSplash()
        }
    }

    companion object {
        @JvmStatic
        fun newInstance(onNavigationListener: OnNavigationListener) =
            SplashFragment(onNavigationListener)
    }
}