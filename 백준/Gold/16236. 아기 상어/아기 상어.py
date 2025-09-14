from collections import deque

n = int(input())
graph = []
x, y = 0, 0  # 아기 상어 초기 위치

for i in range(n):
    row = list(map(int, input().split()))
    graph.append(row)
    if 9 in row:
        x = i
        y = row.index(9)
        row[y] = 0  # ✅ 초기 상어 위치를 비워줘야 한다!

shark_size = 2
time = 0
eat_count = 0

# 이동 방향: 상하좌우
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

# BFS - 전체 거리 테이블
def bfs(start_x, start_y):
    visited = [[-1] * n for _ in range(n)]
    queue = deque()
    queue.append((start_x, start_y))
    visited[start_x][start_y] = 0

    while queue:
        x, y = queue.popleft()

        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            if 0 <= nx < n and 0 <= ny < n:
                if visited[nx][ny] == -1 and graph[nx][ny] <= shark_size:
                    visited[nx][ny] = visited[x][y] + 1
                    queue.append((nx, ny))
    return visited

# 먹을 수 있는 물고기 찾기
def find_fish(visited):
    fishes = []

    for i in range(n):
        for j in range(n):
            if 1 <= graph[i][j] < shark_size and visited[i][j] != -1:
                fishes.append((visited[i][j], i, j))  # 거리, x, y

    return sorted(fishes)

while True:
    visited = bfs(x, y)
    fish_list = find_fish(visited)

    if not fish_list:  # 먹을 수 있는 물고기가 없으면 종료
        print(time)
        break

    # 가장 가까운 물고기 선택
    dist, nx, ny = fish_list[0]

    # 상어 이동 + 시간 추가
    time += dist
    x, y = nx, ny

    # 물고기 먹기
    graph[x][y] = 0
    eat_count += 1

    # 먹은 물고기 수와 크기가 같으면 크기 증가
    if eat_count == shark_size:
        shark_size += 1
        eat_count = 0