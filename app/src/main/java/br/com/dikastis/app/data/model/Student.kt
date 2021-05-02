package br.com.dikastis.app.data.model

class Student (
        val name: String = "",
        val total: Int = 0,
        val solved: Int = 0,
        val submissions: Array<Submission> = arrayOf()) {
}
