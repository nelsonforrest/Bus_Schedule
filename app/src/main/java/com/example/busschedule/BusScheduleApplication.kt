package com.example.busschedule

import android.app.Application
import com.example.busschedule.data.BusScheduleDatabase

class BusScheduleApplication: Application() {
    // initialize database only when it is needed
    val database: BusScheduleDatabase by lazy { BusScheduleDatabase.getDatabase(this) }
}