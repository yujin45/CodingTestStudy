from collections import defaultdict

def solution(genres, plays):
    # 장르별 총 재생 횟수와 곡 정보 저장
    genre_play_count = defaultdict(int)
    song_info = defaultdict(int)
    
    for i, (genre, play) in enumerate(zip(genres, plays)):
        genre_play_count[genre] += play
        song_info[genre].append((play, i)) # (재생횟수, 고유번호)
    
    # 장르별 총 재생 횟수를 기준으로 내림차순 정렬
    sorted_genres = sorted(genre_play_count.items(), key = lambda x: x[1], reverse = True)
    
    # 각 장르 내에서 곡을 재생 횟수와 고유 번호를 기준으로 정렬 후 최대 두 곡 선택
    best_album = []
    for genre, _ in sorted_genres:
        # 곡 정렬: 재생 횟수 내림 차순 -> 고유 번호 오름차순
        songs = sorted(song_info[genre], key = lambda x : (-x[0], x[1]))
        best_album.extend([song[1] for song in songs[:2]])
    return best_album





def solution(genres, plays):
    music = {}
    gens = {}
    for i in range(len(genres)):
        gen = genres[i]
        if gen not in music:
            music[gen] = []
        
        music[gen].append([plays[i], i])
        gens[gen] = gens.setdefault(gen, 0) + plays[i]

    gen_list = [(k, v) for k, v in gens.items()]
    gen_list.sort(key = lambda x : -x[1],)

    answer = []
    for k, _ in gen_list:
        check = music[k]
        check.sort(key = lambda x : (-x[0], x[1]))
        check=[v for _, v in check]
        if len(check) >=2:
            answer+= check[:2]
        else:
            answer += check[:1]
    return answer

# 채점을 시작합니다.
# 정확성  테스트
# 테스트 1 〉	통과 (0.02ms, 10.2MB)
# 테스트 2 〉	통과 (0.01ms, 10.3MB)
# 테스트 3 〉	통과 (0.01ms, 10.2MB)
# 테스트 4 〉	통과 (0.01ms, 10.4MB)
# 테스트 5 〉	통과 (0.07ms, 10.2MB)
# 테스트 6 〉	통과 (0.12ms, 10.2MB)
# 테스트 7 〉	통과 (0.07ms, 10.2MB)
# 테스트 8 〉	통과 (0.04ms, 10.2MB)
# 테스트 9 〉	통과 (0.01ms, 10.2MB)
# 테스트 10 〉	통과 (0.13ms, 10.4MB)
# 테스트 11 〉	통과 (0.03ms, 10.3MB)
# 테스트 12 〉	통과 (0.04ms, 10.2MB)
# 테스트 13 〉	통과 (0.08ms, 10.2MB)
# 테스트 14 〉	통과 (0.07ms, 10.3MB)
# 테스트 15 〉	통과 (0.01ms, 10.3MB)
# 채점 결과
# 정확성: 100.0
# 합계: 100.0 / 100.0
