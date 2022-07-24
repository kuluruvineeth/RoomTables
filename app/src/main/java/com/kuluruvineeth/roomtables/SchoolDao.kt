package com.kuluruvineeth.roomtables

import androidx.room.*
import com.kuluruvineeth.roomtables.entities.Director
import com.kuluruvineeth.roomtables.entities.School
import com.kuluruvineeth.roomtables.entities.Student
import com.kuluruvineeth.roomtables.entities.relations.SchoolAndDirector
import com.kuluruvineeth.roomtables.entities.relations.SchoolWithStudents

@Dao
interface SchoolDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSchool(school: School)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDirector(director: Director)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertStudent(student: Student)

    @Transaction
    @Query("SELECT * FROM school WHERE schoolName= :schoolName")
    suspend fun getSchoolAndDirectorWithSchoolName(schoolName: String): List<SchoolAndDirector>

    @Transaction
    @Query("SELECT * FROM school WHERE schoolName = :schoolName")
    suspend fun getSchoolWithStudents(schoolName: String) : List<SchoolWithStudents>
}