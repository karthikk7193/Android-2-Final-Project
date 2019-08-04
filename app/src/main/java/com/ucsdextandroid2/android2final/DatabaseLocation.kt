package com.ucsdextandroid2.android2final

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

/**
 * Created by rjaylward on 2019-07-05
 */

@Entity(tableName = "DatabaseLocations")
@Parcelize
data class DatabaseLocation(

    @ColumnInfo(name = "title") val title: String?,

    @ColumnInfo(name = "locationType") val locationType: String?,

    @PrimaryKey @ColumnInfo(name = "woeid") val woeid: Long,

    @ColumnInfo(name = "timestamp") val timestamp: Long

): Parcelable