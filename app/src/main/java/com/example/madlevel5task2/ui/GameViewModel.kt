package com.example.madlevel5task2.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.madlevel5task2.model.Game
import com.example.madlevel5task2.repository.GameRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class GameViewModel(application: Application) : AndroidViewModel(application){
    private val gameRository = GameRepository(application.applicationContext)
    private val mainScope = CoroutineScope(Dispatchers.Main)

    val games: LiveData<List<Game>> = gameRository.getAllGames()

    fun insertGame(game: Game){
        mainScope.launch {
            gameRository.insertGame(game)
        }
    }

    fun deleteGame(game: Game){
        mainScope.launch {
            gameRository.deleteGame(game)
        }
    }

    fun deleteAllGames(){
        mainScope.launch {
            gameRository.deleteAllGames()
        }
    }
}