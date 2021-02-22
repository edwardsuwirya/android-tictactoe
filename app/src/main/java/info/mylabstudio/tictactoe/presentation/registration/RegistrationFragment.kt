package info.mylabstudio.tictactoe.presentation.registration

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import info.mylabstudio.tictactoe.R
import info.mylabstudio.tictactoe.utils.PLAYER1_PARAM
import info.mylabstudio.tictactoe.utils.PLAYER2_PARAM
import kotlinx.android.synthetic.main.fragment_registration.*

class RegistrationFragment() : Fragment() {

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
            val bundle =
                bundleOf(
                    PLAYER1_PARAM to player1Text.toString(),
                    PLAYER2_PARAM to player2Text.toString()
                )
            view.findNavController()
                .navigate(R.id.action_registrationFragment_to_boardFragment, bundle)
        }
    }


    companion object {
        @JvmStatic
        fun newInstance() = RegistrationFragment()

        const val TAG = "REGISTRATION_FRAGMENT"
    }
}