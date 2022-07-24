package com.kuluruvineeth.roomtables

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import com.kuluruvineeth.roomtables.entities.Director
import com.kuluruvineeth.roomtables.entities.School
import com.kuluruvineeth.roomtables.entities.Student
import com.kuluruvineeth.roomtables.entities.Subject
import com.kuluruvineeth.roomtables.entities.relations.StudentSubjectCrossRef
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val dao = SchoolDatabase.getInstance(this).schoolDao

        val directors = listOf<Director>(
            Director("kavi","IIIT Dharwad"),
            Director("shiva","ISRO"),
            Director("vineeth","AgriRize")
        )

        val schools = listOf<School>(
            School("Google School"),
            School("Kotlin School"),
            School("JetBrains School")
        )
        val subjects = listOf<Subject>(
            Subject("Dating for programmers"),
            Subject("DSA and Algorithms"),
            Subject("Android Mastering"),
            Subject("Building Products"),
            Subject("How to use Google")
        )
        val students = listOf<Student>(
            Student("Beff Jezos", 2, "Kotlin School"),
            Student("Mark Suckerberg", 5, "Google School"),
            Student("Gill Bates", 8, "Kotlin School"),
            Student("Donny Jepp", 1, "Kotlin School"),
            Student("Hom Tanks", 2, "JetBrains School")
        )
        val studentSubjectRelations = listOf<StudentSubjectCrossRef>(
            StudentSubjectCrossRef("Beff Jezos", "Dating for programmers"),
            StudentSubjectCrossRef("Beff Jezos", "DSA and Algorithms"),
            StudentSubjectCrossRef("Beff Jezos", "Android Mastering"),
            StudentSubjectCrossRef("Beff Jezos", "Building Products"),
            StudentSubjectCrossRef("Mark Suckerberg", "Dating for programmers"),
            StudentSubjectCrossRef("Gill Bates", "How to use Google"),
            StudentSubjectCrossRef("Donny Jepp", "Building Products"),
            StudentSubjectCrossRef("Hom Tanks", "Android Mastering"),
            StudentSubjectCrossRef("Hom Tanks", "Dating for programmers")
        )

        lifecycleScope.launch {
            directors.forEach{dao.insertDirector(it)}
            schools.forEach { dao.insertSchool(it) }
            subjects.forEach { dao.insertSubject(it) }
            students.forEach { dao.insertStudent(it) }
            studentSubjectRelations.forEach { dao.insertStudentSubjectCrossRef(it) }
        }
    }
}