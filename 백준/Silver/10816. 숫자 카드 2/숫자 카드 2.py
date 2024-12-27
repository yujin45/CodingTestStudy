import sys
from collections import Counter
input = sys.stdin.readline
write = sys.stdout.write

_ = input()
having = map(int, input().split())
M = int(input().strip())
check_cards = map(int, input().split())

having_counter = Counter(having)

write(' '.join(str(having_counter[c]) for c in check_cards))