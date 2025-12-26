from collections import deque

board = [list(input().rstrip()) for _ in range(12)]
answer = 0
dy = [-1,1,0,0]
dx = [0,0,-1,1]

def dfs(y, x, color, visited, group):
    visited[y][x] = True
    group.append((y,x))

    for d in range(4):
        ny = y + dy[d]
        nx = x + dx[d]

        if 0 <= ny < 12 and 0 <= nx < 6:
            if not visited[ny][nx] and board[ny][nx] == color:
                dfs(ny, nx, color, visited, group)

def gravity():
    for x in range(6):
        q = deque()

        for y in range(11,-1,-1):
            if board[y][x] != '.':
                q.append(board[y][x])
        for y in range(11,-1,-1):
            if q:
                board[y][x] = q.popleft()
            else:
                board[y][x] = '.'

while True:
    visited = [[False for _ in range(6)] for _ in range(12)]
    exploded = False
    for i in range(12):
        for j in range(6):
            if board[i][j] != '.' and not visited[i][j]:
                group = []
                dfs(i, j, board[i][j], visited, group)

                if len(group) >= 4:
                    for g in group:
                        exploded = True
                        for y, x in group:
                            board[y][x] = '.'
    if not exploded:
        break

    gravity()
    answer += 1

print(answer)