package app.takahashi.kamesan.originalapp

// kinds
// 0 : トランプ
// 1 : ボードゲーム
// 2 : オンラインゲーム
val initialGameInfo = listOf<GameInfo>(
    createGameInfo(
        gameId = 0,
        gameTitle = "ババ抜き",
        playerNumber = 4,
        maxPlayerNumber = 8,
        requiredTime = 30,
        difficulty = 1,
        gameRule = "1.親と子を決定し、親がカードを均等に配る。\n" +
                "2.手札から同じ数字のカードをペアにして捨てる。\n" +
                "3.親の左隣の人が開始プレイヤーとなり、左隣のプレイヤーにカードを1枚ひかせる。\n" +
                "4.引いたプレイヤーは手札に同じ数字のペアになるカードがあれば一緒に捨て、なければ手札に加える。その後、左隣のプレイヤーにかーどを1枚ひかせる。\n" +
                "5.手札がなくなったらその時点で勝ちとなりゲームから抜け、最後の一人が残るまで繰り返す。\n" +
                "[オールドメイド]\n" +
                "ジョーカーの代わりにQを1枚,Jokerを2枚抜いた51枚で行う方式。\n",
        kinds = 0,
        url = "",
        favorite = 0,
        experience = 0,
    ),
    createGameInfo(
        gameId = 0,
        gameTitle = "大富豪",
        playerNumber = 4,
        maxPlayerNumber = 6,
        requiredTime = 60,
        difficulty = 3,
        gameRule = "4ゲームを1セットとし,3セット(合計12ゲーム)で1マッチとする。\n" +
                "マッチの総獲得ポイント数で順位が決定する。\n" +
                "各ゲームのポイントは「大富豪6p」「富豪4p」「貧民2p」「大貧民0p」、各セット第4ゲームに大富豪となったプレイヤーに2Pボーナス。\n" +
                "セットが終わると階級はリセットされ、次セットの第1ゲームは階級なしで行う。\n" +
                "[カードの強さと出し方]\n" +
                "カードの強さ : 3から順に4,5,6,...,10,J,Q,K,A,2,Jokerと強くなる。\n" +
                "自分の番では「場と同じ出し方で、場のカードより強いカードを出す」か「パス」のどちらかを選択する。\n" +
                "カードを出した後、自分以外の全プレイヤーがパスしたら、そのターンは流れ、新しいターンを自分から開始できる。\n" +
                "手持ちのカードを全部出しきったらあがりとなり、その順序で次のゲームの階級が決定し、1位より順に大富豪,富豪,(平民),貧民,大貧民となる。\n",
        kinds = 0,
        url = "",
        favorite = 0,
        experience = 0,
    ),
    createGameInfo(
        gameId = 0,
        gameTitle = "Gim Rummy",
        playerNumber = 2,
        maxPlayerNumber = 2,
        requiredTime = 60,
        difficulty = 1,
        gameRule = "jokerを抜いた通常のトランプ52枚を使用する。ディーラーは１ゲームごとに交代する。\n" +
                "[ゲームの流れ]\n" +
                "各自10枚ずつカードを配り、残りを山札とする。山札から1枚をめくり表向きで捨札置き場に出す。\n" +
                "ディーラーではないプレイヤーは公開された1枚を手札に入れることができる。入れなかった場合はディーラーからゲームを開始する。\n" +
                "手番では捨札置き場か、山札の1番上のカードを1枚引き、手札から1枚を捨てる。\n" +
                "[ゲームの目的]\n" +
                "手札の中でメルドと呼ばれる以下の組み合わせ\n" +
                "セット：同じランクの数字3枚以上\n" +
                "シークエンス : 同じスート(マーク)の3枚以上の連番(K→Aはつながらない)\n" +
                "をつくり、それ以外の手札の点数を減らしていく。\n" +
                "[カードの点数]\n" +
                "A : 1\n2～10 : カードの数値 = 点数\nJ・Q・K : 10点\n" +
                "順番に手番を繰り返し、手札のメルド以外の数字の合計が10点以下になったら「ノック」することができる。\n" +
                "ノックする場合、捨てるカードは裏向きにし、お互いの手札を公開する。\n" +
                "ノックしなかった方のプレイヤーは、ノックしたプレイヤーのメルドに対して付け札(自分の手札をメルドになるようにつなげる)ことができる。\n" +
                "付け札がおわったら、メルドや付け札以外のカードの点数を合計する。\n" +
                "ノックしたほうが点数が少なかった場合、二人の点数の差分がノックした方に入る。ノックしていないほうが点数が高かったり、同点だった場合、二人の点数の差分+25点がノックしなかった方に入る。\n" +
                "また、手札がすべてメルドになっている場合、「ジン」することができ、この場合ジンをしたプレイヤーに25点が入る。\n" +
                "山札の残りが2枚になった場合、そのゲームは引き分けとなり、0点でディーラーを交代する。\n" +
                "[ゲームの終了]\n" +
                "合計得点が100点以上になったプレイヤーの勝利。",
        kinds = 0,
        url = "",
        favorite = 0,
        experience = 0,
    ),
    createGameInfo(
        gameId = 0,
        gameTitle = "scull",
        playerNumber = 3,
        maxPlayerNumber = 6,
        requiredTime = 45,
        difficulty = 2,
        gameRule = "1.プレイヤーはそれぞれパネルを1枚選び、コースターに伏せておく。\n" +
                "2.親プレイヤーから順に「パネルを置く」または「チャレンジ」の動作を行う。\n" +
                "3.誰かが「チャレンジ」を宣言したとき、各プレイヤーは順に「チャレンジ」を上乗せするか「パス」を選択する。\n" +
                "4.宣言したプレイヤー以外の全員が「パス」を選択したとき、宣言した枚数分のパネルをめくっていく。\n" +
                "5.「どくろ」をひくことなく、宣言した枚数分「バラ」をめくることができればチャレンジ成功となる。このときコースターを裏返す。コースターが裏の状態で成功すればゲームに勝利となる。\n" +
                "チャレンジに失敗したプレイヤーは、手札をランダムに1枚、相手に見せないように捨てる。手札がすべてなくなった場合脱落となる。",
        kinds = 1,
        url = "https://boardgamearena.com/gamepanel?game=skull",
        favorite = 0,
        experience = 0,
    ),
    createGameInfo(
        gameId = 0,
        gameTitle = "GodField",
        playerNumber = 1,
        maxPlayerNumber = 9,
        requiredTime = 1,
        difficulty = 3,
        gameRule = "攻撃や防御を駆使し、ダメージを与えあって最後の一人になるまで戦う。詳しくはサイト内「教典」を参照。",
        kinds = 2,
        url = "https://godfield.net/",
        favorite = 1,
        experience = 26202,
    ),
)

private fun createGameInfo(
    gameId: Int,
    gameTitle: String,
    playerNumber: Int,
    maxPlayerNumber: Int,
    requiredTime: Int,
    difficulty: Int,
    gameRule: String,
    url: String,
    kinds: Int,
    favorite: Int,
    experience: Int,
): GameInfo = GameInfo(
    gameId = gameId,
    gameTitle = gameTitle,
    playerNumber = playerNumber,
    maxPlayerNumber = maxPlayerNumber,
    requiredTime = requiredTime,
    difficulty = difficulty,
    gameRule = gameRule,
    kinds = kinds,
    url = url,
    favorite = favorite,
    experience = experience,
)