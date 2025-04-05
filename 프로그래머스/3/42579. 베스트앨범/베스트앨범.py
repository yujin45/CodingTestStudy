from dataclasses import dataclass
from collections import defaultdict

@dataclass
class Song:
    num:int
    play:int

def solution(genres, plays):
    total = defaultdict(int)
    songs = defaultdict(list)
    
    for index, (g, p) in enumerate(zip(genres, plays)):
        total[g] += p
        songs[g].append(Song(index, p))
    
    
    sorted_total = dict(sorted(total.items(), key = lambda x:x[1], reverse = True))
    for ge in songs:
        songs[ge].sort(key=lambda song:song.play, reverse = True)
    
    
    answer = []
    
    for key in sorted_total.keys():
        for s in songs[key][:2]:
            answer.append(s.num)
        
    return answer