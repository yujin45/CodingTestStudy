class Solution {
    fun solution(genres: Array<String>, plays: IntArray): IntArray {
        return genres.indices.groupBy { genres[it] }
            .toList()
            .sortedByDescending { it.second.sumBy { plays[it] } }
            .map { it.second.sortedByDescending { plays[it] }.take(2) }
            .flatten()
            .toIntArray()
    }
}


class Solution1 {
    fun solution(genres: Array<String>, plays: IntArray): IntArray {
    // 1. 장르별 총 재생 횟수와 곡 정보 저장
    val genrePlayCount = mutableMapOf<String, Int>() // 장르별 총 재생 횟수
    val genreToSongs = mutableMapOf<String, MutableList<Pair<Int, Int>>>() // 장르별 (재생 횟수, 고유 번호) 리스트

    for ((index, genre) in genres.withIndex()) {
        val playCount = plays[index]
        genrePlayCount[genre] = genrePlayCount.getOrDefault(genre, 0) + playCount
        genreToSongs.computeIfAbsent(genre) { mutableListOf() }.add(playCount to index)
    }

    // 2. 장르별 총 재생 횟수를 기준으로 내림차순 정렬
    val sortedGenres = genrePlayCount.entries.sortedByDescending { it.value }

    // 3. 각 장르에서 최대 두 곡 선택
    val bestAlbum = mutableListOf<Int>()
    for (genre in sortedGenres.map { it.key }) {
        val songs = genreToSongs[genre]!!
            .sortedWith(compareByDescending<Pair<Int, Int>> { it.first }.thenBy { it.second }) // 재생 횟수 내림차순 -> 고유 번호 오름차순
        bestAlbum.addAll(songs.take(2).map { it.second }) // 최대 두 곡 추가
    }

    return bestAlbum.toIntArray()
}
}


/*
채점을 시작합니다.
정확성  테스트
테스트 1 〉	통과 (18.86ms, 66.3MB)
테스트 2 〉	통과 (19.40ms, 67.4MB)
테스트 3 〉	통과 (18.39ms, 66.3MB)
테스트 4 〉	통과 (8.80ms, 63.5MB)
테스트 5 〉	통과 (18.19ms, 65.3MB)
테스트 6 〉	통과 (18.57ms, 66.6MB)
테스트 7 〉	통과 (18.64ms, 66.7MB)
테스트 8 〉	통과 (19.12ms, 66.2MB)
테스트 9 〉	통과 (27.39ms, 66.8MB)
테스트 10 〉	통과 (22.82ms, 65.9MB)
테스트 11 〉	통과 (22.82ms, 66.1MB)
테스트 12 〉	통과 (18.75ms, 66.4MB)
테스트 13 〉	통과 (25.89ms, 65.5MB)
테스트 14 〉	통과 (25.42ms, 65.8MB)
테스트 15 〉	통과 (19.94ms, 67.2MB)
채점 결과
정확성: 100.0
합계: 100.0 / 100.0
*/
