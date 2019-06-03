package com.example.parcial1_00118717.dao

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "partido")
data class matchEntitie(
@PrimaryKey(autoGenerate = true) @ColumnInfo(name="nPartido") val partido:Int,
@ColumnInfo(name="team1") val team1:String,
@ColumnInfo(name="team12") val team2:String,
@ColumnInfo(name="p1") val p1:Int,
@ColumnInfo(name="p2") val p2:Int,
@ColumnInfo(name="date") val date:String
)
