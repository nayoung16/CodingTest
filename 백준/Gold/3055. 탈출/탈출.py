from collections import deque

r, c = map(int, input().split())
graph = [list(input().strip()) for _ in range(r)]

# 큐 두 개: 물, 고슴도치
water_q = deque()
hog_q = deque()

# 방문 체크 (고슴도치용)
visited = [[False] * c for _ in range(r)]

for i in range(r):
    for j in range(c):
        if graph[i][j] == 'S':
            hog_q.append((i, j, 0))  # (y, x, time)
            visited[i][j] = True
        elif graph[i][j] == '*':
            water_q.append((i, j))

dy = [-1, 1, 0, 0]
dx = [0, 0, -1, 1]

while hog_q:
    # 1) 먼저 현재 시간대의 물을 전부 퍼뜨림
    for _ in range(len(water_q)):
        y, x = water_q.popleft()
        for k in range(4):
            ny = y + dy[k]
            nx = x + dx[k]
            if 0 <= ny < r and 0 <= nx < c:
                # 빈 칸으로만 번진다. (D와 X는 안 덮음)
                if graph[ny][nx] == '.':
                    graph[ny][nx] = '*'
                    water_q.append((ny, nx))

    # 2) 그 다음 현재 시간대의 고슴도치를 전부 이동
    for _ in range(len(hog_q)):
        y, x, t = hog_q.popleft()

        # 비버 굴 도착
        if graph[y][x] == 'D':
            print(t)
            exit(0)

        for k in range(4):
            ny = y + dy[k]
            nx = x + dx[k]
            if 0 <= ny < r and 0 <= nx < c:
                # 갈 수 있는 곳: 빈 칸 '.' 또는 비버 굴 'D'
                if not visited[ny][nx] and (graph[ny][nx] == '.' or graph[ny][nx] == 'D'):
                    visited[ny][nx] = True
                    hog_q.append((ny, nx, t + 1))

# 여기까지 왔다는 건 도착 못했다는 뜻
print("KAKTUS")