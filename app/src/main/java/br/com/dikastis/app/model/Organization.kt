package br.com.dikastis.app.model

class Organization constructor(
    val id: String = "",
    val name: String = "",
    val groupsCount: Int = 0,
    val membersCount: Int = 0,
    val adminsCount: Int = 0,
    val teams: List<Team> = listOf()
) {

    override fun toString() : String {
        return "id: ${id}\n name: ${name}\ngroupsCount: ${groupsCount}\nadminsCount: ${adminsCount}\nmembersCount: ${membersCount}\nteams: $teams\n"
    }
}