N = int(input())
cards = set(map(int, input().split())) # 상근이 카드
M = int(input())
check_cards = list(map(int, input().split())) # 체크해야 하는 것

for i in range(M):
    if check_cards[i] in cards:
        print(1, end=" ")
    else:
        print(0, end=" ")
    
                   