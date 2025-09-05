from itertools import combinations
from collections import deque

N,M = map(int, input().split())
board = [list(map(int, input().split())) for _ in range(N)]
empties = []
viruses = []
answer = N*M
for i in range(N):
  for j in range(M):
    if board[i][j] == 2:
      viruses.append((i,j))
    elif board[i][j] == 0:
      empties.append((i,j))

# 상 하 좌 우
dy = [-1,1,0,0]
dx = [0,0,-1,1]
base_empty = len(empties)

best = 0

combi_list = list(combinations(empties,3))
for combi in combi_list:
  cur_board = [row[:] for row in board]
  for (wy, wx) in combi:
      cur_board[wy][wx] = 1

  visited = [[0 for _ in range(M)] for _ in range(N)]
  q = deque(viruses)
  safe = base_empty - 3

  while q:
    vy, vx = q.popleft()
    if visited[vy][vx]:
      continue
    visited[vy][vx] = 1
    for i in range(4):
        ny = vy + dy[i]
        nx = vx + dx[i]
        if 0<=ny and ny<N and 0<=nx and nx<M and visited[ny][nx] == 0:
          if cur_board[ny][nx] == 0:
            cur_board[ny][nx] = 2
            q.append((ny,nx))
            safe -= 1
  if safe > best:
    best = safe

print(best)