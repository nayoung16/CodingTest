from collections import deque

m,n,k = map(int, input().split())
board = [[0 for _ in range(n)] for _ in range(m)]
for _ in range(k):
    sx, sy, ex, ey = map(int, input().split())
    for i in range(sx,ex):
        for j in range(sy,ey):
            board[j][i] = 1

visited = [[False for _ in range(n)] for _ in range(m)]
dy = [-1,1,0,0]
dx = [0,0,-1,1]
def bfs(y,x):
    queue = deque()
    queue.append([y,x])
    visited[y][x] = True
    count = 1
    while queue:
        cy,cx = queue.popleft()
        for k in range(4):
            ny = cy + dy[k]
            nx = cx + dx[k]
            if 0<=ny<m and 0<=nx<n:
                if visited[ny][nx] == False and board[ny][nx] == 0:
                    queue.append((ny,nx))
                    visited[ny][nx] = True
                    count += 1
    return count


result = list()

for i in range(m):
    for j in range(n):
        if board[i][j] == 0 and visited[i][j] == False:
            c = bfs(i,j)
            result.append(c)

result.sort()
print(len(result))
print(*result)
