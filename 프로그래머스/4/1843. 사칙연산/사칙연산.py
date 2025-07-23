def solution(arr):
    n = len(arr)
    dp_max = [[None] * n for _ in range(n)]
    dp_min = [[None] * n for _ in range(n)]

    def dfs(start, end):
        if dp_max[start][end] is not None:
            return dp_min[start][end], dp_max[start][end]

        if start == end:
            val = int(arr[start])
            dp_min[start][end] = dp_max[start][end] = val
            return val, val

        min_val = float('inf')
        max_val = float('-inf')

        for i in range(start + 1, end, 2):
            op = arr[i]
            left_min, left_max = dfs(start, i - 1)
            right_min, right_max = dfs(i + 1, end)

            for a in (left_min, left_max):
                for b in (right_min, right_max):
                    if op == '+':
                        result = a + b
                    else:
                        result = a - b
                    min_val = min(min_val, result)
                    max_val = max(max_val, result)

        dp_min[start][end] = min_val
        dp_max[start][end] = max_val
        return min_val, max_val

    return dfs(0, n - 1)[1]
