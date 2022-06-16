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

    // IDからデータを取得
    @Query("select * from game_info where game_title = :title")
    fun getGameFromTitle(title: String): GameInfo

    // お気に入りのゲームを取得
    @Query("select * from game_info where favorite = 1")
    fun getGameFromFav(): List<GameInfo>

    // 検索条件に合致するゲームを取得
    @Query("select * from game_info where difficulty in (:diff) " +
            "and kinds in (:kinds) " +
            "and favorite in (:fav)" +
            "and player_number <= :player and :player <= max_player_number " +
            "and required_time <= :time")
    fun searchGame(diff: List<Int>, kinds: List<Int>, fav: List<Int>, player: Int, time: Int): List<GameInfo>

}