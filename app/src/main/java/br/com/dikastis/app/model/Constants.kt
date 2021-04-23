package br.com.dikastis.app.model

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.LocalDateTime

object Constants {

    val teams = arrayOf(
        Team("timinho", "Meu timinho", 2, 1),
        Team("bbbzinho", "Big big", 20, 7),
        Team("cleydinha", "Bonde da cleyde", 2, 10),
        Team("zero", "Ninguem gosta de nois", 0, 0),
        Team("mais", "Sempre cabe mais um", 123, 4)
    )

    @RequiresApi(Build.VERSION_CODES.O)
    val tasks = arrayOf(
        Task("minha taskinha", LocalDateTime.of(2021, 4, 22, 23, 40)),
        Task("nossa taskinha", LocalDateTime.of(2021, 4, 22, 23, 40)),
        Task("taskinha deles", LocalDateTime.of(2021, 4, 22, 23, 40)),
        Task("taskinha delas", LocalDateTime.of(2021, 4, 22, 23, 40)),
        Task("taskinha de ninguem", LocalDateTime.of(2021, 4, 22, 23, 40)),
        Task("taskinha de todos", LocalDateTime.of(2021, 4, 22, 23, 40))
    )

    private val aLotOfTeams = teams + teams + teams + teams

    val organizations = arrayOf(
        Organization("rodinho","Turma do Rodinho", 3, 10, 2, teams),
        Organization("danzin","Turma do Danzin", 3, 10, 2, teams),
        Organization("glaubinho", "Turma do Glaubinho", 3, 10, 2, teams),
        Organization("cleydinha","Turma da Cleydinha", 3, 10, 2, aLotOfTeams)
    )
}