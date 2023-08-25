package com.rfomin.todo.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.rfomin.todo.database.entity.Task
import kotlinx.coroutines.flow.Flow

@Dao
interface TaskDao {
    @Query("SELECT * FROM Task WHERE isCompleted=0")
    fun getAllTasks(): Flow<List<Task>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertTask(task: Task)

    @Delete
    suspend fun deleteDask(task: Task)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateTask(task: Task)
}