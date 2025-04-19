from collections import Counter
from collections import defaultdict

def solution(want, number, discount):
    answer = 0
    want_dict = {}
    for w, n in zip(want, number):
        want_dict[w] = n
        
    want_dict = Counter(want_dict)
    for i in range(len(discount) - 9):
        
        discount_dict = Counter(discount[i:i+10])
        
        if want_dict == discount_dict:
            answer+=1
    
    
    return answer