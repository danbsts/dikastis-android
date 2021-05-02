package br.com.dikastis.app.model

class Team (
    val id: String = "",
    val name: String = "",
    val membersCount: Int = 0,
    val adminsCount: Int = 0,
    val tasks: Array<Task> = arrayOf()) {

    override fun toString(): String {
        return "TEAM - id: $id\nname: $name\nmembersCount: $membersCount\nadminsCount: $adminsCount\ntasks: $tasks\n"
    }
}
