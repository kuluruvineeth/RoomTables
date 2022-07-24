package com.kuluruvineeth.roomtables.entities.relations

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.kuluruvineeth.roomtables.entities.Student
import com.kuluruvineeth.roomtables.entities.Subject

//get subject with many students
data class SubjectWithStudents(
    @Embedded val subject : Subject,
    @Relation(
        parentColumn = "subjectName",
        entityColumn = "studentName",
        associateBy = Junction(StudentSubjectCrossRef::class)
    )
    val students : List<Student>
)