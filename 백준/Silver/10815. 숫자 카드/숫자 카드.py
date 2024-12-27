import sys
input = sys.stdin.readline
write = sys.stdout.write

N = input()
cards = set(map(int, input().split(" ")))
M = input()
check_cards = list(map(int, input().split(" ")))

result = ['1' if card in cards else '0' for card in check_cards]
write(' '.join(result) + '\n')