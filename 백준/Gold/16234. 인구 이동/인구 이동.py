from collections import deque

n,l,r = map(int, input().split())
population = []
for i in range(n):
    p = list(map(int, input().split()))
    population.append(p)

def bfs(sx, sy, visited):
    q = deque()
    q.append((sx,sy))
    visited[sx][sy] = True

    union = [(sx,sy)]
    population_sum = population[sx][sy]

    while q:
        x,y = q.popleft()
        for dx, dy in [(1,0),(-1,0),(0,1),(0,-1)]:
            nx, ny = x + dx, y + dy
            if 0 <= nx < n and 0 <= ny < n and not visited[nx][ny]:
                if l <= abs(population[x][y] - abs(population[nx][ny])) <= r:
                    visited[nx][ny] = True
                    q.append((nx,ny))
                    union.append((nx,ny))
                    population_sum += population[nx][ny]
    return union, population_sum

days = 0

while True:
    visited = [[False] * n for _ in range(n)]
    moved = False

    for i in range(n):
        for j in range(n):
            if not visited[i][j]:
                union, total = bfs(i,j,visited)
                if len(union) > 1:
                    moved = True
                    new_pop = total // len(union)
                    for x, y in union:
                        population[x][y] = new_pop

    if not moved:
        break
    days += 1
print(days)