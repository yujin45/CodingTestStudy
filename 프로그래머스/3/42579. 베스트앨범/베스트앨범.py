from collections import defaultdict
from dataclasses import dataclass

@dataclass
class Song:
    number : int 
    play : int

def solution(genres, plays):
    result = []
    
    # 기본 구조 제작
    playcount_dict = defaultdict(int)
    songs = defaultdict(list)
    for i, (g, p) in enumerate(zip(genres, plays)):
        playcount_dict[g]+= p
        songs[g].append(Song(i, p))
        
    # songs plays 많은 순으로 정렬
    for _, v in songs.items():
        v.sort(key = lambda s : -s.play)

    # 총 재생 수 많은 순으로 정렬
    sorted_playcount_dict = sorted(playcount_dict.items(), key = lambda x : -x[1])

    for g, _ in sorted_playcount_dict:
        songses = songs.get(g)
        result.append(songses[0].number)
        if len(songses) > 1:
            result.append(songses[1].number)
        
    
    return result