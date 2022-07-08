package com.youxiang8727.ubike20_info.model

data class UbikeResponse(
    val sno: String,
    val sna: String,
    val tot: Int,
    val sbi: Int,
    val sarea: String,
    val mday: String,
    val lat: Double,
    val lng: Double,
    val ar: String,
    val sareaen: String,
    val snaen: String,
    val aren: String,
    val bemp: Int,
    val act: String,
    val srcUpdateTime: String,
    val updateTime: String,
    val infoTime: String,
    val infoDate: String
) {
//        "sno": 序號,
//        "sna": 站名,
//        "tot": 總格數,
//        "sbi": 可租借數量,
//        "sarea": 區域,
//        "mday": 各場站來源資料更新時間,
//        "lat": 緯度,
//        "lng": 經度,
//        "ar": "地址",
//        "sareaen": 區域(EN),
//        "snaen": 站名(EN),
//        "aren": 地址(EN),
//        "bemp": 可還車空位數量,
//        "act": 場站是否暫停營運(未確認),
//        "srcUpdateTime": 微笑單車系統發布資料更新的時間,
//        "updateTime": 北市府交通局數據平台經過處理後將資料存入DB的時間,
//        "infoTime": 微笑單車各場站來源資料更新時間,
//        "infoDate": 微笑單車各場站來源資料更新時間
}