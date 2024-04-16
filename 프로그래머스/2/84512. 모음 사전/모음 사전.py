import itertools

def solution(word):
    alpha_list = ['A', 'E', 'I', 'O', 'U']
    permutations_list = []
    for i in range(1, len(alpha_list)+1):
        permutations_list += [''.join(item) for item in itertools.product(alpha_list, repeat = i)]
    dictionary = sorted(permutations_list)
    
    answer=0
    for i in range(len(dictionary)):
        if dictionary[i] ==word:
            answer = i+1
    
    return answer