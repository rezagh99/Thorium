package com.example.thorium.model.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "cell_info_table")
class CellInfo(
    @PrimaryKey(autoGenerate = true) val id: Int? = null,

    val tech: String,
    val plmn: String,
    val arfcn: String,
    val lac: String,
    val tac: String,
    val cid: String,
    val time: Long,
    val strength: String,

    val mcc : String,
    val mnc : String,
    val gsm_rssi: String,
    val longitude: Double,
    val altitude: Double,
    val latency: Long,
    val content_latency: Long

)