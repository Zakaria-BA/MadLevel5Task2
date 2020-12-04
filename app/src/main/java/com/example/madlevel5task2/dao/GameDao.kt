package com.example.madlevel5task2.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.madlevel5task2.model.Game

@Dao
interface GameDao {
    @Insert
    suspend fun insertGame(game: Game)

    @Delete
    suspend fun deleteNote(game: Game)

    @Query("DELETE FROM gameTable")
    suspend fun deleteAllGames()
}