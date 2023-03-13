package id.ac.ubaya.informatika.exweek2160420154

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_main.*
import kotlin.random.Random

class MainFragment : Fragment() {

    // Bikin num random
    var randomNum1 = Random.nextInt(until = 20)
    var randomNum2 = Random.nextInt(until = 20)

    var hasil = randomNum1 + randomNum2

    // Point User
    var points : Int = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Ubah firstNum and secondNum sesuai huruf random
        firstNum.text = randomNum1.toString()
        secondNum.text = randomNum2.toString()

        btnSubmit.setOnClickListener {
            // Untuk menangkap pesan dari editText dan masukkan ke val answer
            var answer = view.findViewById<EditText>(R.id.textAnswer)
            val jawabUser = Integer.parseInt(answer.text.toString())

            if(jawabUser == hasil){
                // Point user
                points++

                // Bikin num random lagi
                randomNum1 = Random.nextInt(until = 20)
                randomNum2 = Random.nextInt(until = 20)
                hasil = randomNum1 + randomNum2

                // Ubah lagi firstNum and secondNum sesuai huruf random
                firstNum.text = randomNum1.toString()
                secondNum.text = randomNum2.toString()
                answer.setText("")

            } else {
                // Untuk mengirim nama player ke navigation(ACTIONNYA)
                val action = MainFragmentDirections.actionGameOverFragment(points)
                Navigation.findNavController(it).navigate(action)
            }
        }
    }
}