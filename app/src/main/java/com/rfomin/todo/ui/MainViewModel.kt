package com.rfomin.todo.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rfomin.todo.database.dao.TaskDao
import com.rfomin.todo.database.entity.Task
import dagger.hilt.android.lifecycle.HiltViewModel
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import javax.inject.Inject
import kotlinx.coroutines.launch

@HiltViewModel
class MainViewModel @Inject constructor(
    private val taskDao: TaskDao
): ViewModel() {

    fun insertTask(title: String) {
        val task = createTask(title) ?: return

        viewModelScope.launch {
            taskDao.insertTask(task)
        }
    }
}

fun createTask(title: String): Task? {
    if (title.trim().isEmpty()) {
        return null
    }

    val newTitle = title.trim() + " " + getDate()
    return Task(title = newTitle)
}

fun getDate(): String {
    val currentDateTime = LocalDateTime.now()
    val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
    return currentDateTime.format(formatter)
}