
def solution(genres, plays):
    answer = []
    #1.  속한 노래가 많이 재생된 장르를 먼저 수록합니다
    ## 속한 노래 재생 횟수 합해서 장르 정렬
    hash = {}
    hash_g = {}
    for i in range(len(plays)):
        if genres[i] in hash:
            hash[genres[i]] += plays[i]
            hash_g[genres[i]] +=[(plays[i], i)]
        else:
            hash[genres[i]] =  plays[i]
            hash_g[genres[i]] =[(plays[i], i)]
        
    #print(hash)
    # 딕셔너리를 내림차순으로 정렬하여 튜플 리스트로 변환
    sorted_data = sorted(hash.items(), key=lambda x: x[1], reverse=True)
    #print(sorted_data)
    # 정렬된 결과에서 키만 추출하여 리스트로 변환
    sorted_keys = [item[0] for item in sorted_data]
    #print(sorted_keys)
    #print(hash_g[sorted_keys[0]])
    #장르 내에서 많이 재생된 노래를 먼저 수록합니다.
    for k in sorted_keys:
        # 내림, 올림
        sorted_data = sorted(hash_g[k], key=lambda x: (-x[0], x[1]))
        #print(sorted_data)
        
        answer+= [item[1] for item in sorted_data][:2]

    
    return answer