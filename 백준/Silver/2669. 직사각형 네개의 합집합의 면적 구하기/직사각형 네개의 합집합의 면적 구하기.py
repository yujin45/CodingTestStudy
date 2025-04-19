import sys

input = sys.stdin.readline


def count_area(graph):
    count = 0
    for i in range(len(graph)):
        for j in range(len(graph[0])):
            if graph[i][j] == 1:
                count += 1
    return count


def make_graph(graph, x1, y1, x2, y2):
    for i in range(x1, x2):
        for j in range(y1, y2):
            graph[i][j] = 1


MAX = 102
graph = [[0] * MAX for _ in range(MAX)]

for _ in range(4):
    x1, y1, x2, y2 = map(int, input().split())
    #x1, y1, x2, y2 = x1 * 2, y1 * 2, x2 * 2, y2 * 2
    make_graph(graph, x1, y1, x2, y2)

area = count_area(graph)

print(area)