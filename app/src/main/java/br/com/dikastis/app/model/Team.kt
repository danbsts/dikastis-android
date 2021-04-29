package br.com.dikastis.app.model

class Team (
    val id: String,
    val name: String,
    val membersCount: Int,
    val adminsCount: Int,
    val students: Array<Student>) {
}
