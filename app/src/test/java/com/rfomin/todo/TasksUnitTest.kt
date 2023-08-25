package com.rfomin.todo

import com.rfomin.todo.ui.createTask
import com.rfomin.todo.ui.getDate
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
}