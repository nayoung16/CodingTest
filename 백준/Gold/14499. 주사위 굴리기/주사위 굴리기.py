import sys

N, M, x, y, K = map(int, sys.stdin.readline().split())
board = [list(map(int, sys.stdin.readline().split())) for _ in range(N)]

# (x, y)는 (행, 열)
r, c = x, y

# 명령들 (여러 줄일 수도 있어 robust 하게 읽기)
orders = []
while len(orders) < K:
    orders += list(map(int, sys.stdin.readline().split()))
orders = orders[:K]

# 이동: 1 동, 2 서, 3 북, 4 남
dr = [0, 0, -1, 1]   # 행 변화
dc = [1, -1, 0, 0]   # 열 변화

# dice = [top, bottom, north, south, west, east]
dice = [0, 0, 0, 0, 0, 0]

def roll(move):
    top, bottom, north, south, west, east = dice
    if move == 1:   # 동
        dice[0], dice[1], dice[4], dice[5] = west, east, bottom, top
    elif move == 2: # 서
        dice[0], dice[1], dice[4], dice[5] = east, west, top, bottom
    elif move == 3: # 북
        dice[0], dice[1], dice[2], dice[3] = south, north, top, bottom
    elif move == 4: # 남
        dice[0], dice[1], dice[2], dice[3] = north, south, bottom, top

for mv in orders:
    nr = r + dr[mv - 1]
    nc = c + dc[mv - 1]

    if not (0 <= nr < N and 0 <= nc < M):
        continue

    roll(mv)
    r, c = nr, nc

    # 바닥면은 dice[1]
    if board[r][c] == 0:
        board[r][c] = dice[1]
    else:
        dice[1] = board[r][c]
        board[r][c] = 0

    # 윗면 출력
    print(dice[0])