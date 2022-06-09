package app.myoji.nickname.viewpager

import androidx.lifecycle.LiveData

class GameRepository (private val gameDao: GameDao) {

    val readAllData: List<GameInfo> = gameDao.getAll()

    suspend fun insertGame(game: GameInfo) {
        gameDao.insertGame(game)
    }

    suspend fun deleteAll() {
        gameDao.deleteAll()
    }

}