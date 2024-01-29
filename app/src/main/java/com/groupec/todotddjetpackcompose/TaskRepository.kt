package com.groupec.todotddjetpackcompose

interface TaskRepository {
    fun getTasks(): List<Task>
}