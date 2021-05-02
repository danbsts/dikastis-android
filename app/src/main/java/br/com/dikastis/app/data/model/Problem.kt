package br.com.dikastis.app.data.model

class Problem (
        val id: String = "",
        val name: String = "") {

        override fun toString(): String {
                return "PROBLEM - id: $id\nname: $name\n"
        }
}