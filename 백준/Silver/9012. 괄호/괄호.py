

def is_vps(ps):
    stack = []
    for char in ps:
        if char == '(':
            stack.append(char)
        elif char == ')':
            if not stack: # 닫는 괄호가 더 많음
                return "NO"
            stack.pop() # 여는 괄호 제거
    return "YES" if not stack else "NO" # 스택 비어 있으면 YPS

def solution():
    import sys
    input = sys.stdin.read
    data = input().splitlines()

    T = int(data[0])
    results = []
    for i in range(1, T+1):
        results.append(is_vps(data[i]))

    sys.stdout.write("\n".join(results) + "\n")

solution()