package br.com.dikastis.app.model

import java.time.LocalDateTime

class Task (
    val id: String = "",
    val name: String = "",
    val endDate: String = "",
    val problems: Array<Problem> = arrayOf()) {

    override fun toString(): String {
        return "TASK - id: $id\nname: $name\nendDate: $endDate\nproblems: $problems\n"
    }
}
