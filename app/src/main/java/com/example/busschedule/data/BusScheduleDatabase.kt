package com.example.busschedule.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

// @Database makes the class a Room db. It is used to manage the Room database
@Database(entities = [BusSchedule::class], version = 1)
abstract class BusScheduleDatabase: RoomDatabase() {
    // method to return the DAO in order to access the schedule data
    abstract fun busScheduleDao(): BusScheduleDAO

    companion object {
        // @Volatile prevents inconsistencies for the INSTANCE var
        @Volatile
        private var INSTANCE: BusScheduleDatabase? = null

        // function to create the database, or if already created, recreate it with any potential changes
        fun getDatabase(context: Context): BusScheduleDatabase {
            // check if INSTANCE is null, if it is, block it to stop potential errors
            return INSTANCE ?: synchronized(this) {

                // initialize Room > specify database class > app_database is used store/manage database
                Room.databaseBuilder(
                    context,
                    BusScheduleDatabase::class.java,
                    "app_database"
                )
                    // tells Room to initialize from the database file
                    .createFromAsset("database/bus_schedule.db")

                    // creates Room db instance
                    .build()

                    // assigns new Room db instance to the INSTANCE variable
                    .also {
                        INSTANCE = it
                    }
            }
        }
    }
}