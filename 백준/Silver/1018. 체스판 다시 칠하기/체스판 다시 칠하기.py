import sys
input = sys.stdin.readline

N, M = map(int, input().split())
board = [input().strip() for _ in range(N)]

def count_repaints(x, y):
    repaint_w_start = 0  # 시작이 'W'
    repaint_b_start = 0  # 시작이 'B'

    for i in range(8):
        for j in range(8):
            expected_w = 'W' if (i + j) % 2 == 0 else 'B'
            expected_b = 'B' if (i + j) % 2 == 0 else 'W'
            if board[x + i][y + j] != expected_w:
                repaint_w_start += 1
            if board[x + i][y + j] != expected_b:
                repaint_b_start += 1

    return min(repaint_w_start, repaint_b_start)

min_repaint = float('inf')
for i in range(N - 7):
    for j in range(M - 7):
        min_repaint = min(min_repaint, count_repaints(i, j))

print(min_repaint)
