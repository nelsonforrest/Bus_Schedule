package com.example.busschedule.data
import androidx.room.Dao
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

 // @Dao = Data Access Object, it provides methods/queries for accessing data in the database
@Dao
interface BusScheduleDAO {
    // This query is used to retrieve all bus schedules ordered by arrival time
    @Query(
        """
            SELECT * FROM schedule
            ORDER BY arrival_time ASC
        """
    )
    // Flow is used to observe changes in the data
    fun getAll(): Flow<List<BusSchedule>>

    // This query is used to retrieve all bus schedules ordered by stop name
    @Query(
        """
            SELECT * FROM schedule
            WHERE stop_name = :stopName
            ORDER BY arrival_time ASC
        """
    )
    // again, Flow is used to observe changes in the data
    fun getByStopName(stopName: String): Flow<List<BusSchedule>>
}