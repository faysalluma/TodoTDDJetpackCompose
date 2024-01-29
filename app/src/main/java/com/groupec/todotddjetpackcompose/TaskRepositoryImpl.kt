package com.groupec.todotddjetpackcompose

class TaskRepositoryImpl : TaskRepository {
    override fun getTasks(): List<Task> {
        return listOf(
            Task("Hello TDD"),
            Task("This is fun"),
            Task("I can not live without TDD")
        )
    }
}