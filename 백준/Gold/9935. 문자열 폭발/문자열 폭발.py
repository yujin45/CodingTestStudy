import sys

input = sys.stdin.readline

original = input().strip()
boom = input().strip()
stack = []
boom_size = len(boom)
last_char = boom[-1]  # 폭발 문자열의 마지막 문자

for char in original:
    stack.append(char)
    # 스택의 마지막 문자가 폭발 문자열의 마지막 문자와 같을 때만 검사
    if char == last_char and ''.join(stack[-boom_size:]) == boom:
        del stack[-boom_size:]  # 슬라이싱 삭제

# 결과 출력
if not stack:
    print("FRULA")
else:
    print(''.join(stack))
