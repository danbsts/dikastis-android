package br.com.dikastis.app.model

object Constants {

    val teams = arrayOf(
        Team("timinho", "Meu timinho", 2, 1),
        Team("bbbzinho", "Big big", 20, 7),
        Team("cleydinha", "Bonde da cleyde", 2, 10),
        Team("zero", "Ninguem gosta de nois", 0, 0),
        Team("mais", "Sempre cabe mais um", 123, 4)
    )

    private val aLotOfTeams = teams + teams + teams + teams

    val organizations = arrayOf(
        Organization("rodinho","Turma do Rodinho", 3, 10, 2, teams),
        Organization("danzin","Turma do Danzin", 3, 10, 2, teams),
        Organization("glaubinho", "Turma do Glaubinho", 3, 10, 2, teams),
        Organization("cleydinha","Turma da Cleydinha", 3, 10, 2, aLotOfTeams)
    )
}