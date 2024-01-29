package com.groupec.todotddjetpackcompose

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow

class TodoViewModel(
    private val taskRepository: TaskRepository
) : ViewModel() {
    val tasks = MutableStateFlow(taskRepository.getTasks())
}