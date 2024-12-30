class Solution {
    fun solution(genres: Array<String>, plays: IntArray): IntArray {
        val genrePlayCount = mutableMapOf<String, Int>()
        val genreToSongs = mutableMapOf<String, MutableList<Pair<Int, Int>>>()
        
        for((index, genre) in genres.withIndex()){
            val playCount = plays[index]
            genrePlayCount[genre] = genrePlayCount.getOrDefault(genre, 0) + playCount
            genreToSongs.computeIfAbsent(genre){mutableListOf()}.add(playCount to index)
        }
        
        val sortedGenres = genrePlayCount.entries.sortedByDescending{it.value}
        
        val bestAlbum = mutableListOf<Int>()
        for(genre in sortedGenres.map{it.key}){
            val songs = genreToSongs[genre]!!.sortedWith(compareByDescending<Pair<Int, Int>>{it.first}.thenBy{it.second})
            bestAlbum.addAll(songs.take(2).map{it.second})
        }
        return bestAlbum.toIntArray()
    }
}