package com.kuluruvineeth.roomtables.entities.relations

import androidx.room.Entity

//many-many relationships
@Entity(primaryKeys = ["studentName","subjectName"])
data class StudentSubjectCrossRef(
    val studentName: String,
    val subjectName: String
)