package id.ac.ubaya.informatika.exweek2160420154

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI

class MainActivity : AppCompatActivity() {
    // untuk softback, turnback di android
    private lateinit var navControler: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        navControler = (supportFragmentManager.findFragmentById(R.id.hostFragment) as
                        NavHostFragment).navController
        NavigationUI.setupActionBarWithNavController(this, navControler)
    }

    // Untuk mengaktifkan tombol back pakai ini
    override fun onSupportNavigateUp(): Boolean {
        return navControler.navigateUp()
    }
}