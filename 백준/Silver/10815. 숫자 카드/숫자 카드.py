import sys
input = sys.stdin.readline
write = sys.stdout.write

N = int(input())
cards = set(map(int, input().split()))
M = int(input())
check_cards = list(map(int, input().split()))

result = ['1' if card in cards else '0' for card in check_cards]
write(' '.join(result) + '\n')
