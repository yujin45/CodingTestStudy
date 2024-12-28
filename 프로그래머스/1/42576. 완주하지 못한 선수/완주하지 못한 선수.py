def solution(participant, completion):
    p_dict = {}
    for p in participant:
        p_dict[p] = p_dict.setdefault(p, 0) + 1

    for c in completion:
        if(p_dict[c] == 1):
            del p_dict[c]
        else:
            p_dict[c] -=1
    no_completion = list(p_dict.keys())

    return no_completion[0]