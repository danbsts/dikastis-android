package br.com.dikastis.app.model

import java.time.LocalDateTime

class Student (
        val name: String,
        val total: Int,
        val solved: Int,
        val submissions: Array<Submission>) {
}
