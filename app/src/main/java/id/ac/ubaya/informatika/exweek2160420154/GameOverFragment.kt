package id.ac.ubaya.informatika.exweek2160420154

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_game_over.*


class GameOverFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_game_over, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // Buat pengecekan argumen ada ato ga, jika ada simpan args to text in this fragment
        if (arguments != null){
            val score = GameOverFragmentArgs.fromBundle(requireArguments()).playerScore
            txtScore.text = "Your score is $score"
        }

        // Aktifkan btnBack's Action untuk menuju ke halaman MainFragment lagi
        btnBack.setOnClickListener {
            val action = GameOverFragmentDirections.actionMainFragment()
            Navigation.findNavController(it).navigate(action)
        }
    }
}