package info.mylabstudio.tictactoe.presentation

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import info.mylabstudio.tictactoe.R
import kotlinx.android.synthetic.main.fragment_registration.*

class RegistrationFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
//        btnPlay.setOnClickListener { goToBoard() }
        return inflater.inflate(R.layout.fragment_registration, container, false)
    }

//    private fun goToBoard() {
//        val boardIntent = Intent(this, MainActivity::class.java)
//        boardIntent.putExtra(PlayerRegistrationActivity.PLAYER1, etPlayer1Name.text.toString())
//        boardIntent.putExtra(PlayerRegistrationActivity.PLAYER2, etPlayer2Name.text.toString())
//        startActivity(boardIntent)
//    }

    companion object {
        @JvmStatic
        fun newInstance() = RegistrationFragment()
    }
}