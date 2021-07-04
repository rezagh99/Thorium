package com.example.thorium.ui

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.thorium.R
import com.example.thorium.model.entity.CellInfo

class Adapter internal constructor(
    context: Context
) : RecyclerView.Adapter<Adapter.WordViewHolder>() {

    private val inflater: LayoutInflater = LayoutInflater.from(context)
    private var data = emptyList<CellInfo>()

    inner class WordViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        //Shown data
        val tech_ItemView: TextView = itemView.findViewById(R.id.tech)
        val plmn_ItemView : TextView = itemView.findViewById(R.id.plmn)
        val arfcn_ItemView: TextView = itemView.findViewById(R.id.arfcn)
        val lac_ItemView: TextView = itemView.findViewById(R.id.lac)
        val tac_ItemView: TextView = itemView.findViewById(R.id.tac)
        val cid_ItemView : TextView = itemView.findViewById(R.id.cid)
        val time_ItemView: TextView = itemView.findViewById(R.id.time)
        val strengthItemView: TextView = itemView.findViewById(R.id.strength)
        val mnc_ItemView: TextView = itemView.findViewById(R.id.mnc)
        val mcc_ItemView: TextView = itemView.findViewById(R.id.mcc)
        val altitude_ItemView: TextView = itemView.findViewById(R.id.altitude)
        val longitude_ItemView: TextView = itemView.findViewById(R.id.longitude)
       val gsm_rssi_ItemView: TextView = itemView.findViewById(R.id.gsm_rssi)

//        val latency_ItemView: TextView = itemView.findViewById(R.id.latency)
//        val content_latency_ItemView: TextView = itemView.findViewById(R.id.content_latency)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordViewHolder {
        val view = inflater.inflate(R.layout.recyclerview_item, parent, false)
        return WordViewHolder(view)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: WordViewHolder, position: Int) {
        val current = data[position]
        holder.strengthItemView.text = "Strength: ${current.strength}"
        holder.time_ItemView.text = "Time: ${current.time}"
        holder.altitude_ItemView.text = "Altitude: ${current.altitude}"
        holder.longitude_ItemView.text = "Longitude: ${current.longitude}"
        holder.tech_ItemView.text = "Technology: ${current.tech}"
        holder.lac_ItemView.text = "Lac: ${current.lac}"
        holder.tac_ItemView.text = "Tac: ${current.tac}"
        holder.cid_ItemView.text = "Cid: ${current.cid}"
        holder.mnc_ItemView.text = "MNC: ${current.mnc}"
        holder.mcc_ItemView.text = "MCC: ${current.mcc}"
        holder.plmn_ItemView.text = "PLMN: ${current.plmn}"
        holder.arfcn_ItemView.text = "ARFCN: ${current.arfcn}"

//        holder.latency_ItemView.text = "Latency: ${current.latency}"
//        holder.content_latency_ItemView.text = "Content Latency: ${current.content_latency}"



        try {
            val parent: ViewGroup = holder.gsm_rssi_ItemView.parent as ViewGroup

            if (current.tech != "GSM")
            {
                parent.removeView(holder.gsm_rssi_ItemView)
            }
            if (current.tech != "LTE")
            {
                parent.removeView(holder.tac_ItemView)
            }
            if (current.tech == "LTE")
            {
                parent.removeView(holder.lac_ItemView)
            }
        }
        catch (a: TypeCastException)
        {

        }

    }

    internal fun setWords(words: List<CellInfo>) {
        this.data = words
        notifyDataSetChanged()
    }

    override fun getItemCount() = data.size
}