# 코너를 최소로 이용하여 건설하기
# BFS cost 비교 방식 (3차원)
from collections import deque
def solution(board):
    n = len(board)
    INF = float('inf')
    cost = [[[INF] * 4 for _ in range(n)] for _ in range(n)]
    
    dy = [-1,1,0,0]
    dx = [0,0,-1,1]
    
    queue = deque() # y, x, 방향, 비용
    queue.append((0,0,-1,0)) # -1 : 시작
    
    while queue:
        y, x, prv_dir, prv_cost = queue.popleft()
        
        for k in range(4):
            ny, nx = y + dy[k], x + dx[k]
            if 0 <= ny < n and 0 <= nx < n and board[ny][nx] == 0:
                new_cost = prv_cost
                if prv_dir == k or prv_dir == -1:
                    new_cost += 100 # 직선 도로
                else:
                    new_cost += 600 # 코너
                
                if new_cost < cost[ny][nx][k]:
                    cost[ny][nx][k] = new_cost
                    queue.append((ny,nx,k,new_cost))
    
    return min(cost[n-1][n-1]) 