package app.takahashi.kamesan.originalapp

import androidx.room.*

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

    // 全てのデータを削除
    @Query("delete from game_info")
    fun deleteAll()

    // お気に入り(またはお気に入りではない)ゲームを取得
    @Query("select * from game_info where favorite = :favo")
    fun getFav(favo: Int): List<GameInfo>

    // 難易度別にゲームを取得
    @Query("select * from game_info where difficulty = :diff")
    fun getGameDiff(diff: Int): List<GameInfo>

    // 推奨最大人数と推奨最小人数を満たしているゲームを取得
    @Query("select * from game_info where player_number <= :people")
    fun getGamePeople(people: Int): List<GameInfo>
}