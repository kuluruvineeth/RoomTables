package com.kuluruvineeth.roomtables.entities.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.kuluruvineeth.roomtables.entities.Director
import com.kuluruvineeth.roomtables.entities.School

data class SchoolAndDirector(
    @Embedded val school: School, //fetches all properties of that entity
    @Relation(
        parentColumn = "schoolName", //from School entity
        entityColumn = "schoolName"  //from Director entity
    )
    val director: Director
)