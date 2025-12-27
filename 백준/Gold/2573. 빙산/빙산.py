from collections import deque
n, m = map(int, input().split())
board = [list(map(int, input().split())) for _ in range(n)]

dy = (-1, 1, 0, 0)
dx = (0, 0, -1, 1)

ice = [(i, j) for i in range(n) for j in range(m) if board[i][j] > 0]

def connected_count(start_y, start_x):
    q = deque([(start_y, start_x)])
    visited = [[False] * m for _ in range(n)]
    visited[start_y][start_x] = True
    cnt = 1

    while q:
        y, x = q.popleft()
        for d in range(4):
            ny, nx = y + dy[d], x + dx[d]
            if 0 <= ny < n and 0 <= nx < m:
                if not visited[ny][nx] and board[ny][nx] > 0:
                    visited[ny][nx] = True
                    q.append((ny, nx))
                    cnt += 1
    return cnt

year = 0

while ice:
    sy, sx = ice[0]
    if connected_count(sy, sx) < len(ice):
        print(year)
        break

    melt = []
    for y, x in ice:
        sea = 0
        for d in range(4):
            ny, nx = y + dy[d], x + dx[d]
            if 0 <= ny < n and 0 <= nx < m and board[ny][nx] == 0:
                sea += 1
        melt.append(sea)

    new_ice = []
    for (y, x), sea in zip(ice, melt):
        nh = board[y][x] - sea
        if nh < 0:
            nh = 0
        board[y][x] = nh
        if nh > 0:
            new_ice.append((y, x))

    ice = new_ice
    year += 1
else:
    print(0)