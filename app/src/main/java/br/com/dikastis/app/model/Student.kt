package br.com.dikastis.app.model

import java.time.LocalDateTime

class Student (
        val name: String,
        val email: String,
        val submissions: Array<Submission>) {
}
