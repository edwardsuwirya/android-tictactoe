package info.mylabstudio.tictactoe.presentation

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import info.mylabstudio.tictactoe.R
import kotlinx.android.synthetic.main.activity_player_registration.*

class PlayerRegistrationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_player_registration)
        btnPlay.setOnClickListener { goToBoard() }
    }

    private fun goToBoard() {
        val boardIntent = Intent(this, MainActivity::class.java)
        boardIntent.putExtra(PLAYER1, etPlayer1Name.text.toString())
        boardIntent.putExtra(PLAYER2, etPlayer2Name.text.toString())
        startActivity(boardIntent)
    }

    companion object {
        val PLAYER1 = "player1"
        val PLAYER2 = "player2"
    }

}
