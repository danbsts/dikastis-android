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
            "A",
            "B"
    )

    @RequiresApi(Build.VERSION_CODES.O)
    val tasks = arrayOf(
        Task("1","minha taskinha", "2021-05-01T10:00:00Z", problems),
        Task("1","nossa taskinha", "2021-05-01T10:00:00Z", problems),
        Task("1","taskinha deles", "2021-05-01T10:00:00Z", problems),
        Task("1","taskinha delas", "2021-05-01T10:00:00Z", problems),
        Task("1","taskinha de ninguem", "2021-05-01T10:00:00Z", problems),
        Task("1","taskinha de todos", "2021-05-01T10:00:00Z", problems)
    )

    private val aLotOfTeams = teams + teams + teams + teams

    val organizations = arrayOf(
        Organization("rodinho","Turma do Rodinho", 3, 10, 2),
        Organization("danzin","Turma do Danzin", 3, 10, 2),
        Organization("glaubinho", "Turma do Glaubinho", 3, 10, 2),
        Organization("cleydinha","Turma da Cleydinha", 3, 10, 2)
    )
}