package com.example.tugaspertemuan10

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tugaspertemuan10.databinding.ItemPahlawanBinding


typealias onClickPahlawan = (Pahlawan) -> Unit

class PahlawanAdapter(private val listPahlawan: List<Pahlawan>, private val onClickPahlawan: onClickPahlawan):
    RecyclerView.Adapter<PahlawanAdapter.ItemPahlawanViewHolder>() {

    inner class ItemPahlawanViewHolder(private val binding: ItemPahlawanBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(data: Pahlawan) {
            with(binding) {
                namaPahlawan.text = data.namaPahlawan
                tanggalLahirPahlawan.text = data.tanggalLahirPahlawan
                jenisPahlawan.text = data.jenisPahlawan
                DeskripsiPahlawan.text = data.deskripsiPahlawan

                val gambar_pahlawan = when (data.gambarPahlawan) {
                    R.drawable.kartini -> R.drawable.kartini
                    R.drawable.dewantara -> R.drawable.dewantara
                    R.drawable.pattimura -> R.drawable.pattimura
                    else -> R.drawable.default_image

                }

                GambarPahlawan.setImageResource(gambar_pahlawan)

                itemView.setOnClickListener {
                    onClickPahlawan(data)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemPahlawanViewHolder {
        val binding = ItemPahlawanBinding.inflate(
            LayoutInflater.from(parent.context),
            parent, false)
        return ItemPahlawanViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemPahlawanViewHolder, position: Int) {
        holder.bind(listPahlawan[position])
    }

    override fun getItemCount(): Int = listPahlawan.size

}
