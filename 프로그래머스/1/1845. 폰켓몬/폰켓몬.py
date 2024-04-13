import collections
# 1. 총 N 마리의 폰켓몬 중에서 N/2마리 가져가기 
# 2. 폰켓몬은 종류에 따라 번호를 붙여 구분 => 같은 종류의 폰켓몬은 같은 번호
# ex) 총 4마리의 폰켓몬 [3번, 1번, 2번, 3번]  3번 폰켓몬 두 마리, 1번 폰켓몬 한 마리, 2번 폰켓몬 한 마리
# 3. 최대한 많은 종류의 폰켓몬을 포함해서 N/2마리를 선택
# N마리 폰켓몬의 종류 번호가 담긴 배열 nums
def solution(nums):
    # N/2마리의 폰켓몬을 선택하는 방법 중, 
    ## n/2 마리 개수 구하기
    n_2 = len(nums)//2 # 무조건 2의 배수라 했음
    #print("n_2:", n_2)
    
    # 가장 많은 종류의 폰켓몬을 선택하는 방법을 찾아, 
    ## 몇가지 종류 있는가?
    #nums_uni = set(nums) # 무슨 종류
    #nums_uni_count = len(nums_uni) # 종류 개수
    nums_dict = collections.Counter(nums)
    #print("nums_dict:", nums_dict)
    nums_type = nums_dict.keys()
    #print("nums_type:", nums_type)
    type_len = len(nums_type)
    #print("type_len: ", type_len)
    
    if type_len <=n_2:
        answer = type_len
    else:
        answer = n_2
    
    
    #그때의 폰켓몬 종류 번호의 개수를 return 하도록 solution 함수를 완성해주세요.
    #answer = 0
    return answer