package com.example.praktikum_app1;


import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.praktikum_app1.R
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textGreeting = findViewById<TextView>(R.id.textGreeting)
        val textDate = findViewById<TextView>(R.id.textDate)
        val textNextMeal = findViewById<TextView>(R.id.textNextMeal)
        val btnGantiMenu = findViewById<Button>(R.id.btnGantiMenu)

        // Ambil nama dari intent (opsional)
        val userName = intent.getStringExtra("USERNAME") ?: "User"
        textGreeting.text = "Hai, $userName!"

        // Tanggal hari ini
        val currentDate = SimpleDateFormat("EEEE, dd MMMM yyyy", Locale("id", "ID"))
            .format(Date())
        textDate.text = "Hari ini: $currentDate"

        // Simulasi next meal
        textNextMeal.text = "Jadwal makan berikutnya: 18.00"

        // Tombol ganti menu
        btnGantiMenu.setOnClickListener {
            // Ganti menu secara acak (dummy)
            val menuText = findViewById<TextView>(R.id.textMenu)
            menuText.text = "- Salad Tuna + Roti Gandum\n- 430 Kalori | 28g Protein"
        }
    }
}
