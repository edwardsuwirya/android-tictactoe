package info.mylabstudio.tictactoe.presentation

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import info.mylabstudio.tictactoe.R
import kotlinx.android.synthetic.main.fragment_registration.*

class RegistrationFragment(private val onNavigationListener: OnNavigationListener) : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        return inflater.inflate(R.layout.fragment_registration, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        btnPlay.setOnClickListener {
            val player1Text = etPlayer1Name.text
            val player2Text = etPlayer2Name.text
            onNavigationListener.onRegistration(
                player1 = player1Text.toString(),
                player2 = player2Text.toString()
            )
        }
    }


    companion object {
        @JvmStatic
        fun newInstance(onNavigationListener: OnNavigationListener) =
            RegistrationFragment(onNavigationListener)

        const val TAG = "REGISTRATION_FRAGMENT"
    }
}