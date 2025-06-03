from itertools import product

def solution(word):
    dictionary = []
    
    for i in range(1, 6):
        dictionary.extend(list(''.join(temp) for temp in product("AEIOU", repeat =i)))
    
    dictionary.sort()
    return dictionary.index(word) + 1