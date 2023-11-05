package com.example.tugaspertemuan10

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tugaspertemuan10.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapterPahlawan = PahlawanAdapter(generateDummy()){pahlawan ->
            Toast.makeText(this@MainActivity,"You clicked on ${pahlawan.namaPahlawan}", Toast.LENGTH_SHORT).show()
        }
        with(binding){
            rvPahlawan.apply {
                adapter = adapterPahlawan
                layoutManager = LinearLayoutManager(this@MainActivity)
            }
        }
    }

    private fun generateDummy(): List<Pahlawan> {
        val deskripsiKartini: String = resources.getString(R.string.desk_kartini)
        val deskripsiDewantara: String = resources.getString(R.string.desk_dewantara)
        val deskripsiPattimura: String = resources.getString(R.string.desk_pattimura)

        return listOf(
            Pahlawan("Kartini", "Pahlawan Nasional", "21 April 1879", deskripsiKartini, R.drawable.kartini),
            Pahlawan("Ki Hajar Dewantara", "Pahlawan Nasional", "2 Mei 1889", deskripsiDewantara, R.drawable.dewantara),
            Pahlawan("Thomas Matulessy", "Pahlawan Nasional", "8 Juni 1783 ", deskripsiPattimura, R.drawable.pattimura)
        )
    }
}