def solution(participant, completion):
    player = {}
    for name in participant:
        player[name] = player.get(name, 0) + 1
    for name in completion:
        player[name]-=1
        if player[name] == 0:
            del player[name]
    
    return list(player.keys())[0]