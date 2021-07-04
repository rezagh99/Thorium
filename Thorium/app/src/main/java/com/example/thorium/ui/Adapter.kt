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
    private var data = emptyList<CellInfo>() // Cached copy of infos

    inner class WordViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val type_ItemView: TextView = itemView.findViewById(R.id.type)
        val cid_ItemView : TextView = itemView.findViewById(R.id.cid)
        val lac_ItemView: TextView = itemView.findViewById(R.id.lac)
        val tac_ItemView: TextView = itemView.findViewById(R.id.tac)
        val plmn_ItemView : TextView = itemView.findViewById(R.id.plmn)
        val arfcn_ItemView: TextView = itemView.findViewById(R.id.arfcn)

        val mnc_ItemView: TextView = itemView.findViewById(R.id.mnc)
        val mcc_ItemView: TextView = itemView.findViewById(R.id.mcc)
        val gsm_rssi_ItemView: TextView = itemView.findViewById(R.id.gsm_rssi)
        val strengthItemView: TextView = itemView.findViewById(R.id.strength)
        val time_ItemView: TextView = itemView.findViewById(R.id.time)
        val altitude_ItemView: TextView = itemView.findViewById(R.id.altitude)
        val longitude_ItemView: TextView = itemView.findViewById(R.id.longitude)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordViewHolder {
        val itemView = inflater.inflate(R.layout.recyclerview_item, parent, false)
        return WordViewHolder(itemView)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: WordViewHolder, position: Int) {
        val current = data[position]

        holder.type_ItemView.text = "Technology: ${current.type}"
        holder.cid_ItemView.text = "CId: ${current.cid}"
        holder.lac_ItemView.text = "LAC: ${current.lac}"
        holder.tac_ItemView.text = "TAC: ${current.tac}"
        holder.plmn_ItemView.text = "PLMN: ${current.plmn}"
        holder.arfcn_ItemView.text = "ARFCN: ${current.arfcn}"
        holder.mnc_ItemView.text = "MNC: ${current.mnc}"
        holder.mcc_ItemView.text = "MCC: ${current.mcc}"

        holder.strengthItemView.text = "Strength: ${current.strength}"
        holder.time_ItemView.text = "Time: ${current.time}"
        holder.altitude_ItemView.text = "Altitude: ${current.altitude}"
        holder.longitude_ItemView.text = "Longitude: ${current.longitude}"



        try {
            val parent: ViewGroup = holder.type_ItemView.parent as ViewGroup

            if (current.type != "LTE")
            {
                parent.removeView(holder.tac_ItemView)
            }
            if (current.type == "LTE")
            {
                parent.removeView(holder.lac_ItemView)
            }


            if (current.type != "GSM")
            {
                parent.removeView(holder.gsm_rssi_ItemView)
            }

        }
        catch (a: TypeCastException)
        {

        }

    }

    internal fun setWords(data: List<CellInfo>) {
        this.data = data
        notifyDataSetChanged()
    }

    override fun getItemCount() = data.size
}