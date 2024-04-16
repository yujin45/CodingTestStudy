# 피로도 0 이상의 정수
# "최소 필요 피로도">= 항상 "소모 피로도"
# 서로 다른 던전의 ["최소 필요 피로도", "소모 피로도"]가 서로 같을 수 있습니다. => 중복
# 순서

import itertools
def solution(k, dungeons):
    answer = -1
    
    d_list = list(itertools.permutations(dungeons, len(dungeons)))
    #print(d_list)
    maxe = 0
    count =0
    ori_k = k
    for d in d_list:
        #print("d", d)
        count =0
        k = ori_k
        for i in range(len(d)):
            #print("d[i][0] >= k:", d[i][0] , k)
            if d[i][0] <= k:
                #print()
                # 동굴 입장 조건
                count+=1
                k -=d[i][1]
        if count > maxe:
            maxe = count
    answer = maxe
    return answer

#a=solution(50, [[40, 10], [30, 20], [30,20]])
#print(a)