package br.com.dikastis.app.model

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.LocalDateTime

object Constants {
    val submissions = arrayOf(
            Submission("A", "print('hi')", "ACCEPTED", "Python", 1000),
            Submission("B", "print('hello')", "TLE", "Python", 1000)
    )

    val daniel = Student("Daniel", "dmrb2@cin.ufpe.br", submissions)
    val rodrigo = Student("Rodrigo", "rfrl@cin.ufpe.br", submissions)

    val students = arrayOf(daniel, rodrigo)

    val teams = arrayOf(
        Team("timinho", "Meu timinho", 2, 1, students),
        Team("bbbzinho", "Big big", 20, 7, students),
        Team("cleydinha", "Bonde da cleyde", 2, 10, students),
        Team("zero", "Ninguem gosta de nois", 0, 0, students),
        Team("mais", "Sempre cabe mais um", 123, 4, students)
    )

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
        Organization("rodinho","Turma do Rodinho", 3, 10, 2, teams),
        Organization("danzin","Turma do Danzin", 3, 10, 2, teams),
        Organization("glaubinho", "Turma do Glaubinho", 3, 10, 2, teams),
        Organization("cleydinha","Turma da Cleydinha", 3, 10, 2, aLotOfTeams)
    )
}