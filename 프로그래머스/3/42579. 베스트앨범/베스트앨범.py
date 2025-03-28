from collections import defaultdict
def solution(genres, plays):
    songs = {}
    total = {}
    for i in range(0, len(plays)):
        songs.setdefault(genres[i], []).append((i, plays[i]))
        total.setdefault(genres[i], 0) 
        total[genres[i]] += plays[i]
        
    sorted_total_items = dict(sorted(total.items(), key = lambda x: x[1], reverse=True))

    
    for key, value in songs.items():
        songs[key].sort(key = lambda x: x[1], reverse=True)
    
    ret = []
    
    for key in sorted_total_items.keys():
        ret.append(songs[key][0][0])
        if len(songs[key]) >= 2:
            ret.append(songs[key][1][0])
            
    
    return ret