package com.kuluruvineeth.roomtables

import androidx.room.*
import com.kuluruvineeth.roomtables.entities.Director
import com.kuluruvineeth.roomtables.entities.School
import com.kuluruvineeth.roomtables.entities.relations.SchoolAndDirector

@Dao
interface SchoolDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSchool(school: School)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDirector(director: Director)

    @Transaction
    @Query("SELECT * FROM school WHERE schoolName= :schoolName")
    suspend fun getSchoolAndDirectorWithSchoolName(schoolName: String): List<SchoolAndDirector>
}