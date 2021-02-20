package info.mylabstudio.tictactoe.presentation

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
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
        splashFragment = SplashFragment.newInstance(this)
        switchFragment(splashFragment)
    }

    private fun switchFragment(fragment: Fragment) {
//        supportFragmentManager.beginTransaction()
//            .setCustomAnimations(R.anim.slide_in, R.anim.slide_out)
        //Tidak bisa karena semua fragment bisa memiliki kemampuan backstack
//            .addToBackStack(null)
//            .replace(R.id.fragmentContainer, fragment)
//            .commit()

//        when {
//            fragment is SplashFragment -> {
//                supportFragmentManager.beginTransaction()
//                    .setCustomAnimations(R.anim.slide_in, R.anim.slide_out)
//                    .replace(R.id.fragmentContainer, fragment, SPLASH_FRAGMENT_TAG)
//                    .commit()
//            }
//            fragment is BoardFragment -> {
//                supportFragmentManager.beginTransaction()
//                    .replace(R.id.fragmentContainer, fragment, BOARD_FRAGMENT_TAG)
//                    .addToBackStack(REGISTRATION_FRAGMENT_TAG)
//                    .commit()
//            }
//            fragment is RegistrationFragment -> {
//                supportFragmentManager.beginTransaction()
//                    .replace(R.id.fragmentContainer, fragment, REGISTRATION_FRAGMENT_TAG)
//                    .commit()
//            }
//        }
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.apply {
            when {
                fragment is SplashFragment -> tictactoeNav(
                    fragment,
                    SPLASH_FRAGMENT_TAG,
                    null
                ).commit()
                fragment is BoardFragment -> tictactoeNav(
                    fragment,
                    BOARD_FRAGMENT_TAG,
                    REGISTRATION_FRAGMENT_TAG
                ).commit()
                fragment is RegistrationFragment -> tictactoeNav(
                    fragment,
                    REGISTRATION_FRAGMENT_TAG,
                    null
                ).commit()
            }
        }

    }


    fun FragmentTransaction.tictactoeNav(
        fragment: Fragment,
        tag: String,
        backStackTag: String?
    ): FragmentTransaction {
        backStackTag?.apply {
            this@tictactoeNav.replace(R.id.fragmentContainer, fragment, tag)
                .addToBackStack(this)
        } ?: run {
            this@tictactoeNav.replace(R.id.fragmentContainer, fragment, tag)
        }
        return this
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
        boardFragment = BoardFragment(this)
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

    override fun onExit() {
        supportFragmentManager.popBackStack()
    }

    companion object {
        const val BOARD_FRAGMENT_TAG = "BOARD_FRAGMENT"
        const val REGISTRATION_FRAGMENT_TAG = "REGISTRATION_FRAGMENT"
        const val SPLASH_FRAGMENT_TAG = "SPLASH_FRAGMENT"
    }


}
