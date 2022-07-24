package com.kuluruvineeth.roomtables.entities.relations

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.kuluruvineeth.roomtables.entities.Student
import com.kuluruvineeth.roomtables.entities.Subject

//single student get all subjects
data class StudentWithSubjects(
    @Embedded val student: Student,
    @Relation(
        parentColumn = "studentName", //primary key of student entity
        entityColumn = "subjectName", //primary key of subject entity
        associateBy = Junction(StudentSubjectCrossRef::class)
    )
    val subjects: List<Subject>
)