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