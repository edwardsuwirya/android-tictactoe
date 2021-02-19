package info.mylabstudio.tictactoe.presentation

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import info.mylabstudio.tictactoe.R
import info.mylabstudio.tictactoe.utils.PLAYER1_PARAM
import info.mylabstudio.tictactoe.utils.PLAYER2_PARAM

class MainActivity : AppCompatActivity(), OnNavigationListener {
    private lateinit var registrationFragment: RegistrationFragment
    private lateinit var boardFragment: BoardFragment
    private lateinit var splashFragment: SplashFragment
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_main)
//        player1 = intent.getStringExtra(PlayerRegistrationActivity.PLAYER1) ?: ""
//        player2 = intent.getStringExtra(PlayerRegistrationActivity.PLAYER2) ?: ""
//        activePlayer = player1
//        showCurrentPlayerName("'s turn")

        splashFragment = SplashFragment.newInstance(this)
        switchFragment(splashFragment)
    }

    private fun switchFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .setCustomAnimations(R.anim.slide_in, R.anim.slide_out)
            .replace(R.id.fragmentContainer, fragment)
            .commit()
    }

    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        if (hasFocus) hideSystemUI()
    }

    private fun hideSystemUI() {
        window.decorView.systemUiVisibility = (View.SYSTEM_UI_FLAG_IMMERSIVE
                or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                or View.SYSTEM_UI_FLAG_FULLSCREEN)
    }

    override fun onRegistration(player1: String, player2: String) {
//        boardFragment = BoardFragment.newInstance(player1, player2)
        boardFragment = BoardFragment()
        val bundle = Bundle()
        bundle.putString(PLAYER1_PARAM, player1)
        bundle.putString(PLAYER2_PARAM, player2)
        boardFragment.arguments = bundle
        switchFragment(boardFragment)
    }

    override fun onSplash() {
        registrationFragment = RegistrationFragment.newInstance(this)
        switchFragment(registrationFragment)
    }


}
