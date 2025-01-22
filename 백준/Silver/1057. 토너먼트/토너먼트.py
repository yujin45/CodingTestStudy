import sys

input = sys.stdin.readline


def tornament(kim, lim):
    round_count = 0
    while kim != lim:
        kim = (kim + 1) // 2
        lim = (lim + 1) // 2
        round_count += 1  # 다음 라운드에 올라갈 숫자로 만들고 라운드업. 여기에서 같은 숫자되면 대결한 것
    return round_count


n, kim, lim = map(int, input().split())
print(tornament(kim, lim))
