package br.com.dikastis.app.model

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.LocalDateTime

object Constants {
    val submissions = arrayOf(
            Submission("A", "print('hi')", "ACCEPTED", "Python", 1000),
            Submission("B", "print('hello')", "TLE", "Python", 1000),
            Submission("B", "print('hello')", "WA", "Python", 1000),
            Submission("B", "print('hello')", "RTE", "Python", 1000)
    )

    val daniel = Student("Daniel", 1, 2, submissions)
    val rodrigo = Student("Rodrigo", 2, 2, submissions)

    val students = arrayOf(daniel, rodrigo)

    val teams = arrayOf(
        Team("timinho", "Meu timinho", 2, 1),
        Team("bbbzinho", "Big big", 20, 7),
        Team("cleydinha", "Bonde da cleyde", 2, 10),
        Team("zero", "Ninguem gosta de nois", 0, 0),
        Team("mais", "Sempre cabe mais um", 123, 4)
    ).toList()

    val problems = arrayOf(
            Problem("A", "Printa hi"),
            Problem("B", "Printa hello")
    )

    @RequiresApi(Build.VERSION_CODES.O)
    val tasks = arrayOf(
        Task("minha taskinha", LocalDateTime.of(2021, 4, 22, 23, 40), problems),
        Task("nossa taskinha", LocalDateTime.of(2021, 4, 22, 23, 40), problems),
        Task("taskinha deles", LocalDateTime.of(2021, 4, 22, 23, 40), problems),
        Task("taskinha delas", LocalDateTime.of(2021, 4, 22, 23, 40), problems),
        Task("taskinha de ninguem", LocalDateTime.of(2021, 4, 22, 23, 40), problems),
        Task("taskinha de todos", LocalDateTime.of(2021, 4, 22, 23, 40), problems)
    )

    private val aLotOfTeams = teams + teams + teams + teams

    val organizations = arrayOf(
        Organization("rodinho","Turma do Rodinho", 3, 10, 2),
        Organization("danzin","Turma do Danzin", 3, 10, 2),
        Organization("glaubinho", "Turma do Glaubinho", 3, 10, 2),
        Organization("cleydinha","Turma da Cleydinha", 3, 10, 2)
    )
}