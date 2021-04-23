package br.com.dikastis.app.model

class Organization (
    val id: String,
    val name: String,
    val groupsCount: Int,
    val membersCount: Int,
    val adminsCount: Int,
    val teams: Array<Team>) {

}