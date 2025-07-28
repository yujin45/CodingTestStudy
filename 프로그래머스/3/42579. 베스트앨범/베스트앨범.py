from dataclasses import dataclass
from collections import defaultdict
# class Song:
#     def __init__(self, id, play):
#         self.id = id
#         self.play = play
#     def __repr__(self):
#         return f"Song({self.id}, {self.play})"
@dataclass
class Song:
    id : int 
    play : int

def solution(genres, plays):
    answer = []
    
    g_dict = defaultdict(int)
    p_dict = defaultdict(list)
    
    for i, (g, p) in enumerate(zip(genres, plays)):
        g_dict[g] += p
        p_dict[g].append(Song(i, p))
        
    sorted_g_entry = sorted(g_dict.items(), key = lambda x: -x[1]) # value 기준 내림차순
    for g, _ in sorted_g_entry:
        p_dict[g].sort(key = lambda x : (-x.play, x.id))
        for i in range(min(2, len(p_dict[g]))):
            answer.append(p_dict[g][i].id)
    
    return answer