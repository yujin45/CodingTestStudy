import sys

input = sys.stdin.readline

# 입력 받기
n = int(input())
atk_list = list(map(int, input().split()))
hp_list = list(map(int, input().split()))

# 초기화
players = [(i + 1, atk, hp) for i, (atk, hp) in enumerate(zip(atk_list, hp_list))]
atk_sum = 0  # 공격력 누적합
loop = 0  # 라운드 수

while len(players) > 1:
    players = [player for player in players if player[2] > atk_sum - player[1] * loop and (atk_sum := atk_sum + player[1])]
    loop += 1

# 마지막 남은 플레이어 출력
print(players[0][0])