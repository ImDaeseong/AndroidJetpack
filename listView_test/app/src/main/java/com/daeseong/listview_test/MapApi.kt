package com.daeseong.listview_test

import android.util.Log

class ItemData(
    var locName: String,
    var latitude: Double,
    var longitude: Double
)

object MapApi {

    private val TAG = MapApi::class.java.simpleName

    private val list = mutableListOf<String>()
    private val map = mutableMapOf<String, ArrayList<ItemData>>()

    init {
        initList()
        initMap()
    }

    fun getItem(index: String): ArrayList<ItemData>? {
        return map[index]
    }

    fun getMap(): Map<String, ArrayList<ItemData>> {
        return map
    }

    fun getList(): List<String> {
        return list
    }

    fun addList(value: String) {
        list.add(value)
    }

    fun updateList(select: Int, value: String) {
        list[select] = value
    }

    fun removeList(select: Int) {
        list.removeAt(select)
    }

    private fun initList() {
        list.addAll(
            listOf(
                "서울", "경기", "인천", "강원", "부산", "경남", "대구", "경북", "울산",
                "대전", "충남", "충북", "광주", "전남", "전북", "제주"
            )
        )
    }

    private fun initMap() {
        val seoulList = arrayListOf(
            ItemData("강남 역삼 삼성 논현", 0.0, 0.0),
            ItemData("서초 방배 반포", 0.0, 0.0),
            ItemData("신길 영등포 여의도 문래", 0.0, 0.0),
            ItemData("구로 금천 신도림", 0.0, 0.0),
            ItemData("강서 화곡 까치산 목동", 0.0, 0.0),
            ItemData("천호 길동 둔촌", 0.0, 0.0),
            ItemData("서울대 신림 봉천", 0.0, 0.0),
            ItemData("대방 노량진 사당", 0.0, 0.0),
            ItemData("종로 대학로", 0.0, 0.0),
            ItemData("용산 중구 명동 이태원", 0.0, 0.0),
            ItemData("성북 도봉 노원", 0.0, 0.0),
            ItemData("강북 수유 미아", 0.0, 0.0),
            ItemData("왕십리 성수", 0.0, 0.0),
            ItemData("건대 광진", 0.0, 0.0),
            ItemData("동대문 장안 청량리", 0.0, 0.0),
            ItemData("중랑 상봉 면목 태릉", 0.0, 0.0),
            ItemData("신촌 홍대 서대문 마포", 0.0, 0.0),
            ItemData("은평 연신내 불광", 0.0, 0.0),
            ItemData("잠실 신천 송파 석촌", 0.0, 0.0)
        )
        setMap("서울", seoulList)

        val gyeonggiList = arrayListOf(
            ItemData("수원 인계 권선 영통", 0.0, 0.0),
            ItemData("수원역 세류 팔달문 구운 장안", 0.0, 0.0),
            ItemData("안성 평택 송탄", 0.0, 0.0),
            ItemData("오산 화성 동탄", 0.0, 0.0),
            ItemData("파주 김포", 0.0, 0.0),
            ItemData("고양 일산", 0.0, 0.0),
            ItemData("의정부", 0.0, 0.0),
            ItemData("부천", 0.0, 0.0),
            ItemData("안양 평촌", 0.0, 0.0),
            ItemData("군포 금정 산본 의왕", 0.0, 0.0),
            ItemData("안산", 0.0, 0.0),
            ItemData("광명 시흥", 0.0, 0.0),
            ItemData("용인", 0.0, 0.0),
            ItemData("이천 광주 여주", 0.0, 0.0),
            ItemData("성남", 0.0, 0.0),
            ItemData("구리 남양주 하남", 0.0, 0.0),
            ItemData("가평 양평", 0.0, 0.0),
            ItemData("포천 동두천 연천 양주", 0.0, 0.0)
        )
        setMap("경기", gyeonggiList)

        val incheonList = arrayListOf(
            ItemData("부평", 0.0, 0.0),
            ItemData("주안", 0.0, 0.0),
            ItemData("동암 남동구", 0.0, 0.0),
            ItemData("계양 서구", 0.0, 0.0),
            ItemData("남구 동구 중구 월미도", 0.0, 0.0),
            ItemData("연수구 송도 강화 옹진", 0.0, 0.0)
        )
        setMap("인천", incheonList)

        val gangwonList = arrayListOf(
            ItemData("경포대 강릉 정동진", 0.0, 0.0),
            ItemData("속초 양양 고성 인제", 0.0, 0.0),
            ItemData("춘천 홍천 철원", 0.0, 0.0),
            ItemData("원주 횡성", 0.0, 0.0),
            ItemData("동해 삼척 태백", 0.0, 0.0),
            ItemData("평창 영월 정선", 0.0, 0.0)
        )
        setMap("강원", gangwonList)

        val busanList = arrayListOf(
            ItemData("해운대 재송", 0.0, 0.0),
            ItemData("송정 기장", 0.0, 0.0),
            ItemData("서면 초읍 양정", 0.0, 0.0),
            ItemData("연산 토곡", 0.0, 0.0),
            ItemData("동래 온천장 부산대 구서 사직", 0.0, 0.0),
            ItemData("동구 부산역 남포동 송도 영도", 0.0, 0.0),
            ItemData("광안리 경성대 남구", 0.0, 0.0),
            ItemData("사상", 0.0, 0.0),
            ItemData("덕천 북구", 0.0, 0.0),
            ItemData("하단 사하 명지", 0.0, 0.0)
        )
        setMap("부산", busanList)

        val gyeongnamList = arrayListOf(
            ItemData("김해 장유", 0.0, 0.0),
            ItemData("양산", 0.0, 0.0),
            ItemData("거제 통영 고성군", 0.0, 0.0),
            ItemData("진주 사천", 0.0, 0.0),
            ItemData("남해 하동", 0.0, 0.0),
            ItemData("창원 진해", 0.0, 0.0),
            ItemData("마산", 0.0, 0.0),
            ItemData("거창 함안 창녕 합천 산청", 0.0, 0.0),
            ItemData("밀양", 0.0, 0.0)
        )
        setMap("경남", gyeongnamList)

        val daeguList = arrayListOf(
            ItemData("동구", 0.0, 0.0),
            ItemData("중구", 0.0, 0.0),
            ItemData("남구", 0.0, 0.0),
            ItemData("북구", 0.0, 0.0),
            ItemData("울주군", 0.0, 0.0)
        )
        setMap("대구", daeguList)

        val gyeongbukList = arrayListOf(
            ItemData("경주", 0.0, 0.0),
            ItemData("구미 김천 의성", 0.0, 0.0),
            ItemData("포항 영덕", 0.0, 0.0),
            ItemData("울진 울릉도 청송", 0.0, 0.0),
            ItemData("영천 칠곡 경산 청도 성주 고령", 0.0, 0.0),
            ItemData("문경 상주 안동 영주 예천", 0.0, 0.0)
        )
        setMap("경북", gyeongbukList)

        val ulsanList = arrayListOf(
            ItemData("유성구", 0.0, 0.0),
            ItemData("중구 은행", 0.0, 0.0),
            ItemData("동구 대덕 용전", 0.0, 0.0),
            ItemData("서구 둔산 괴정", 0.0, 0.0)
        )
        setMap("대전", ulsanList)

        val chungnamList = arrayListOf(
            ItemData("천안", 0.0, 0.0),
            ItemData("세종", 0.0, 0.0),
            ItemData("계룡 공주 금산 논산", 0.0, 0.0),
            ItemData("아산 예산 청양 홍성", 0.0, 0.0),
            ItemData("서산 태안 당진 안면도", 0.0, 0.0),
            ItemData("대천 서천 보령 부여", 0.0, 0.0)
        )
        setMap("충남", chungnamList)

        val chungbukList = arrayListOf(
            ItemData("청주", 0.0, 0.0),
            ItemData("충주 제천", 0.0, 0.0),
            ItemData("진천 음성 단양", 0.0, 0.0),
            ItemData("증평 괴산 영동 옥천 보은", 0.0, 0.0)
        )
        setMap("충북", chungbukList)

        // Log the data
        map.forEach { (key, itemList) ->
            itemList.forEach { item ->
                Log.e(TAG, "$key ${item.locName}")
            }
        }
    }

    private fun setMap(index: String, itemList: ArrayList<ItemData>): Boolean {
        if (map.containsKey(index)) {
            return false
        }
        map[index] = itemList
        return true
    }
}
