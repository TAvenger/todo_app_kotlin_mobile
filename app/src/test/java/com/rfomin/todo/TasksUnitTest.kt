package com.rfomin.todo

import com.rfomin.todo.database.entity.Task
import com.rfomin.todo.ui.createTask
import com.rfomin.todo.ui.getDate
import com.rfomin.todo.ui.markTaskAsCompleted
import org.junit.Test

import org.junit.Assert.*

class TasksUnitTest {
    @Test
    fun createTask_EmtpyTitle() {
        val task = createTask("")
        assertNull(task)
    }

    @Test
    fun createTask_OnlySpacesInTitle() {
        val task = createTask("  ")
        assertNull(task)
    }

    @Test
    fun createTask_regularTask() {
        val task = createTask("title")
        assertEquals("title ${getDate()}", task?.title)
    }

    @Test
    fun completeTask_field() {
        val task = createTask("title")
        val completedTask = task?.let { markTaskAsCompleted(it) }
        assertEquals(1, completedTask?.isCompleted)
    }

    @Test
    fun completeTask_object() {
        val task = Task(title = "title")
        val completedTask = markTaskAsCompleted(task)
        val expectedTask = Task(title = "title", isCompleted = 1)
        assertEquals(expectedTask, completedTask)
    }
}