package info.mylabstudio.tictactoe.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import info.mylabstudio.tictactoe.R
import kotlinx.android.synthetic.main.fragment_winner.*

/**
 * A simple [Fragment] subclass.
 * Use the [WinnerFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class WinnerFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_winner, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
            Glide.with(requireContext())
                .load(R.drawable.winner)
                .into(imageView3);
    }

    companion object {
        @JvmStatic
        fun newInstance() = WinnerFragment()
    }
}