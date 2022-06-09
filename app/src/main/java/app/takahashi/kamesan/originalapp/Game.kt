package app.takahashi.kamesan.originalapp

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "game_info")
data class GameInfo(

    @PrimaryKey(autoGenerate = true)
    val GameID: Int = 0,
    //ゲーム名
    @ColumnInfo(name = "game_title")
    var GameTitle: String,
    //推奨人数
    @ColumnInfo(name = "player_number")
    var PlayerNumber: Int,
    //推奨最大人数
    @ColumnInfo(name = "max_player_number")
    var MaxPlayerNumber: Int,
    //難易度
    @ColumnInfo(name = "difficulty")
    var Difficulty: Int,
    //ゲームのルール
    @ColumnInfo(name = "game_rule")
    var GameRule: Int,
    //ゲームの種別
    @ColumnInfo(name = "kinds")
    var Kinds: Int,
    //お気に入り
    @ColumnInfo(name = "favorite")
    var Favorite: Int,
    //遊んだ回数
    @ColumnInfo(name = "experience")
    var Experience: Int
)