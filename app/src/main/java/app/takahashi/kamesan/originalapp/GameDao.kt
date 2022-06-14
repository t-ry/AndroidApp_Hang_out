package app.takahashi.kamesan.originalapp

import androidx.room.*
import java.text.FieldPosition

@Dao
interface GameDao {

    // データを追加
    @Insert
    fun insert(game: GameInfo)

    // データを更新
    @Update
    fun update(game: GameInfo)

    // データを削除
    @Delete
    fun delete(game: GameInfo)

    // ゲームを登録
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertGame(game: GameInfo)

    // 全てのデータを取得
    @Query("select * from game_info")
    fun getAll(): List<GameInfo>

    // 全てのデータを削除
    @Query("delete from game_info")
    fun deleteAll()

    // IDからデータを取得
    @Query("select * from game_info where gameId = :id")
    fun getGameFromId(id: Int): GameInfo

    // お気に入りのゲームを取得
    @Query("select * from game_info where favorite = 1")
    fun getGameFromFav(): List<GameInfo>

    // 検索条件に当てはまるゲームを取得
    @Query("select * from game_info where difficulty = 0")
    fun getEasyGame(): List<GameInfo>

    // 検索条件に当てはまるゲームを取得
    @Query("select * from game_info where difficulty = 1")
    fun getDifficultGame(): List<GameInfo>

    // 検索条件に当てはまるゲームを取得
    @Query("select * from game_info where kinds = 0")
    fun getPlayingcardGame(): List<GameInfo>

    // 検索条件に当てはまるゲームを取得
    @Query("select * from game_info where kinds= 1")
    fun getBoardgamesGame(): List<GameInfo>

    // 検索条件に当てはまるゲームを取得
    @Query("select * from game_info where kinds = 2")
    fun getOnlineGame(): List<GameInfo>

}