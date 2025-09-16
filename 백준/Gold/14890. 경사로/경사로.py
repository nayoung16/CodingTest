import sys

def can_pass(line, L):
    n = len(line)
    used = [False] * n  # 경사로 사용 여부

    for i in range(n - 1):
        if line[i] == line[i + 1]:
            continue

        diff = line[i + 1] - line[i]
        if abs(diff) != 1:
            return False

        if diff == 1:  # 오르막: 뒤로 L칸(line[i] 높이) 확인
            for j in range(i, i - L, -1):
                if j < 0 or used[j] or line[j] != line[i]:
                    return False
            for j in range(i, i - L, -1):
                used[j] = True
        else:  # diff == -1, 내리막: 앞으로 L칸(line[i+1] 높이) 확인
            for j in range(i + 1, i + 1 + L):
                if j >= n or used[j] or line[j] != line[i + 1]:
                    return False
            for j in range(i + 1, i + 1 + L):
                used[j] = True

    return True

def main():
    input = sys.stdin.readline
    N, L = map(int, input().split())
    board = [list(map(int, input().split())) for _ in range(N)]

    ans = 0
    # 행 검사
    for r in range(N):
        if can_pass(board[r], L):
            ans += 1
    # 열 검사
    for c in range(N):
        col = [board[r][c] for r in range(N)]
        if can_pass(col, L):
            ans += 1

    print(ans)

if __name__ == "__main__":
    main()