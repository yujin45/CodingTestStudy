import sys
from collections import Counter
input = sys.stdin.readline

# 입력 처리
_ = input()  # 첫 번째 입력 (N), 필요 없으므로 무시
having = map(int, input().split())
M = int(input().strip())
check_cards = map(int, input().split())

# 카운터 생성
having_counter = Counter(having)

# 결과 출력 (join 대신 직접 출력으로 메모리 절약)
print(' '.join(str(having_counter[c]) for c in check_cards))
