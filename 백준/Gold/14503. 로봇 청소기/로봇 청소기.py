N, M = map(int, input().split())
r, c, d = map(int, input().split())
graph = [list(map(int, input().split())) for _ in range(N)]

# 방향: 0=북, 1=동, 2=남, 3=서
dr = [-1, 0, 1, 0]
dc = [0, 1, 0, -1]

# 청소된 칸은 2로 표시(원래 0=빈칸, 1=벽)
result = 0
while True:
    # 1) 현재 칸 청소
    if graph[r][c] == 0:
        graph[r][c] = 2
        result += 1

    cleaned_found = False
    # 2) 왼쪽부터 4방향 확인
    for _ in range(4):
        d = (d + 3) % 4  # 왼쪽 회전 (한 줄 로직)
        nr, nc = r + dr[d], c + dc[d]
        if 0 <= nr < N and 0 <= nc < M and graph[nr][nc] == 0:
            # 왼쪽 방향에 청소할 칸이 있으면 전진
            r, c = nr, nc
            cleaned_found = True
            break

    if cleaned_found:
        continue

    # 3) 네 방향 모두 청소 불가 → 뒤로 한 칸
    br, bc = r - dr[d], c - dc[d]  # 현재 방향 기준 뒤칸
    if not (0 <= br < N and 0 <= bc < M) or graph[br][bc] == 1:
        # 뒤가 벽이면 종료
        break
    else:
        # 뒤로 후진(방향은 유지)
        r, c = br, bc

print(result)