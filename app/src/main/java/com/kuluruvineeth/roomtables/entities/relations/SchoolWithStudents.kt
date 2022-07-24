package com.kuluruvineeth.roomtables.entities.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.kuluruvineeth.roomtables.entities.School
import com.kuluruvineeth.roomtables.entities.Student

//1-n relationship
data class SchoolWithStudents(
    @Embedded val school: School,
    @Relation(
        parentColumn = "schoolName", //from School entity
        entityColumn = "schoolName" //from Students entity
    )
    val students: List<Student>
)