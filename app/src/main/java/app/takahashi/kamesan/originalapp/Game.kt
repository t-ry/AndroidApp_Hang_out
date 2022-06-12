package app.takahashi.kamesan.originalapp

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "game_info")
data class GameInfo(

    @PrimaryKey(autoGenerate = true)
    val gameId: Int = 0,
    //ゲーム名
    @ColumnInfo(name = "game_title")
    var gameTitle: String,
    //推奨人数
    @ColumnInfo(name = "player_number")
    var playerNumber: Int,
    //推奨最大人数
    @ColumnInfo(name = "max_player_number")
    var maxPlayerNumber: Int,
    //所要時間
    @ColumnInfo(name = "required_time")
    var requiredTime: Int,
    //難易度
    @ColumnInfo(name = "difficulty")
    var difficulty: Int,
    //ゲームのルール
    @ColumnInfo(name = "game_rule")
    var gameRule: String,
    //ゲームの種別 (0 = トランプ, 1 = ボードゲーム, 2 = オンラインゲーム)
    @ColumnInfo(name = "kinds")
    var kinds: Int,
    //(オンラインゲームなら)URLを表示
    @ColumnInfo(name = "url")
    var url: String,
    //お気に入り
    @ColumnInfo(name = "favorite")
    var favorite: Int,
    //遊んだ回数
    @ColumnInfo(name = "experience")
    var experience: Int
)