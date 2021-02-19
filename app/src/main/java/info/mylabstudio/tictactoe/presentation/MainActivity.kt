package info.mylabstudio.tictactoe.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import info.mylabstudio.tictactoe.R

class MainActivity : AppCompatActivity() {
    private lateinit var registrationFragment: RegistrationFragment
//    private lateinit var boardFragment: BoardFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_main)
//        player1 = intent.getStringExtra(PlayerRegistrationActivity.PLAYER1) ?: ""
//        player2 = intent.getStringExtra(PlayerRegistrationActivity.PLAYER2) ?: ""
//        activePlayer = player1
//        showCurrentPlayerName("'s turn")
        registrationFragment = RegistrationFragment.newInstance()
//        boardFragment = BoardFragment.newInstance()
        switchFragment(registrationFragment)
    }

    private fun switchFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().replace(R.id.fragmentContainer, fragment).commit()
    }
}
