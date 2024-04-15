def solution(citations):
    answer = 0
    citations.sort(reverse=True)
    
    for i in range(len(citations)):
        h = citations[i]
        count = 0
        for j in range(len(citations)):
            if h <= citations[j]:
                count+=1
            else:
                break
        if h == count:
            return h

print(solution([2,5,4,4,6, 0]))