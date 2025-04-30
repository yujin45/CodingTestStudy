from collections import defaultdict
from dataclasses import dataclass

@dataclass
class Song:
    num : int
    play : int

def solution(genres, plays):
    gens = defaultdict(int)
    songs = defaultdict(list)
    for i, (g, p) in enumerate(zip(genres, plays)):
        gens[g] += p
        songs[g].append(Song(i, p))
    
    gens = sorted(gens.items(), key = lambda x : x[1], reverse =True)
    
    for _, value in songs.items():
        value.sort(key = lambda x : (-x.play, x.num))
    answer = []
    for g, _ in gens:
        song_list = songs[g]
        answer.append(song_list[0].num)
        if len(song_list) >= 2:
            answer.append(song_list[1].num)
    
    return answer