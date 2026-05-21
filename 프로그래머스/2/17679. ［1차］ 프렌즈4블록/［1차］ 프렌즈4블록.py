def solution(m, n, board):
    answer = 0
    board = [list(row) for row in board]
    
    while True:
        answer_points = set()
        for i in range(m-1):
            for j in range(n-1):
                if board[i][j] != '-' and board[i][j] == board[i][j+1] == board[i+1][j] == board[i+1][j+1]:
                    answer_points.add((i,j))
                    answer_points.add((i,j+1))
                    answer_points.add((i+1,j))
                    answer_points.add((i+1,j+1))
        
        if len(answer_points) == 0:
            break
            
        for i, j in answer_points:
            board[i][j] = '-'
        answer += len(answer_points)
            
        for j in range(n):
            # 해당 열에서 빈 칸이 아닌 블록만 위에서 아래로 모으기
            stack = [board[i][j] for i in range(m) if board[i][j] != '-']
            
            for k in range(m-1,-1,-1):
                if stack:
                    board[k][j] = stack.pop()
                else:
                    board[k][j] = '-'              
        
    return answer