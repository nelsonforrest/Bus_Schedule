/*
 * Copyright (C) 2023 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.busschedule.data
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.annotation.NonNull
import androidx.room.ColumnInfo

// use @Entity to mark class as a Room db entity
@Entity(tableName = "Schedule")
data class BusSchedule(
    // mark 'id' as the primary key
    @PrimaryKey val id: Int,
    // primary keys automatically cannot be null, insure stop_name & arrival_time are also notnull
    @NonNull
    // @ColumnInfo names the column
    @ColumnInfo(name ="stop_name")
    val stopName: String,
    @NonNull
    @ColumnInfo(name ="arrival_time")
    val arrivalTimeInMillis: Int
)
