package com.home.mosbymvpdemo.main.model.repository

import com.home.mosbymvpdemo.main.model.entity.MainListEntity
import io.reactivex.Single
import java.util.concurrent.TimeUnit

/**
 * In a Production app, inject the Repository into your Use Case (Domain layer).
 */
object MainRepository {

    fun getData(): Single<MutableList<MainListEntity>> =
        Single.just(generateData()).delay(2, TimeUnit.SECONDS)

    private fun generateData(): MutableList<MainListEntity> {
        val list = mutableListOf<MainListEntity>()
        list.add(
            MainListEntity(
                "2019/12/01",
                "https://www.celebremagazine.world/wp-content/uploads/2019/07/mirazur-1170x600.jpg",
                "Mirazur",
                "（門頓，法國）",
                "去年排第三的Mirazur，今年更上一層樓，早前亦榮獲米芝蓮三星評級。42歲的科拉格雷科有阿根廷和意大利血統，成為廚師後到法國闖天下，2006年在接近意大利的邊境城市芒通（Menton）開設Mirazur，不足一年已獲米芝蓮賜予第一顆星，2012年得第二顆。科拉格雷科2009年獲法國美食指南《Gault & Millau》選為「年度大廚」，是首位獲該殊榮的非法籍主廚。"
            )
        )
        list.add(
            MainListEntity(
                "2019/12/07",
                "https://bnextmedia.s3.hicloud.net.tw/image/album/2018-09/img-1538118288-65242.jpg",
                "Noma",
                "（哥本哈根，丹麥）",
                "這是一個獨一無二的建築項目，從佈局到材料，從裝修到織物的選擇都與哥本哈根當地的景致和氣候完美融合：這就是Noma餐廳主廚雷內・雷德澤皮（René Redzepi）對於新址的設想。這家丹麥星級餐廳由他一手創立，曾四次獲得「全球最佳餐廳」稱號。對於雷德澤皮（Redzepi）而言，Noma不僅是一家餐廳，更是一種與大自然和北歐傳統息息相關的烹飪體驗。2017年，餐廳正處於發展的巔峰期，品牌選擇在那時停業修整，足見其獨特的個性。在歷時一年的休整後，Noma餐廳在丹麥首都哥本哈根郊區的一個舊倉庫中重新開業。早先，這間倉庫曾被丹麥皇家海軍用於存儲彈藥。"
            )
        )
        list.add(
            MainListEntity(
                "2019/12/22",
                "https://foodle.pro/restaurants-images/2019-05-05-20-40-43-cd35af1ccb37f19c74d06b91474fe09a.jpg",
                "Asador Etxebarri",
                "（Axpe, 西班牙）",
                "對於 Asador Etxebarri 的主廚 Victor Arguinzoniz 而言，駕馭火不是時尚，只是從小到大的生活方式。他成長於 Atxondo，西班牙巴斯克自治區的一個山中小鎮，一直到現在人口都只有 1,400 餘人，他小時候無電可用，要煮飯就是要燒柴，跟在媽媽與奶奶身邊，升火烹飪自然而然。\n" +
                        "\n" +
                        "與其說 Victor Arguinzoniz 的廚藝無師自通，不如說家人與家鄉就是他最受用的老師。於是他開餐廳，還是在他的出生地，Asador Etxebarri 就藏身在 Atxondo 翠綠山谷裡，距離畢爾包約 40 分鐘車程。不遠千里來朝聖的旅人可多了！米其林一星、世界排名第六，Asador Etxebarri 現在紅得發紫，下週二即將公布新一年的世界五十最佳餐廳，好成績拭目以待。"
            )
        )
        return list
    }
}