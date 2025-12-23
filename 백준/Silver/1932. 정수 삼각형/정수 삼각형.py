n = int(input())
graph = []
for _ in range(n):
    line = list(map(int, input().split()))
    graph.append(line)

for i in range(1, n):
    for j in range(i + 1):
        if j == 0:
            graph[i][j] += graph[i-1][j]
        elif j == i:
            graph[i][j] += graph[i-1][j-1]
        else:
            graph[i][j] += max(graph[i-1][j-1], graph[i-1][j])

print(max(graph[n-1]))