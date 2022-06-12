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

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertGame(game: GameInfo)

    // 全てのデータを取得
    @Query("select * from game_info")
    fun getAll(): List<GameInfo>

    // IDからデータを取得
    @Query("select * from game_info where gameId = :id")
    fun getGameFromId(id: Int): GameInfo

    @Query("select game_title from game_info where gameId = :id")
    fun getGameFromDIffi(id: Int): String

    @Query("select game_rule from game_info where gameId = :id")
    fun getGameRule(id: Int): String

    // 全てのデータを削除
    @Query("delete from game_info")
    fun deleteAll()

    // お気に入り(またはお気に入りではない)ゲームを取得
    @Query("select * from game_info where favorite = 1")
    fun getFav(): List<GameInfo>

    // 難易度別にゲームを取得
    @Query("select * from game_info where difficulty = :diff")
    fun getGameDiff(diff: Int): List<GameInfo>

    // 推奨最大人数と推奨最小人数を満たしているゲームを取得
    @Query("select * from game_info where player_number <= :people")
    fun getGamePeople(people: Int): List<GameInfo>

    // 条件指定検索
    @Query("select * from game_info where difficulty = :diff and favorite = :favo and kinds = :kinds")
    fun searchGames(favo: Int, diff: Int, kinds: Int): List<GameInfo>
}