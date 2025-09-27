N, M, R = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(N)]
ops = list(map(int, input().split()))

def op1(a):  # 상하 반전
    return a[::-1]

def op2(a):  # 좌우 반전
    return [row[::-1] for row in a]

def op3(a):  # 시계 90도
    n, m = len(a), len(a[0])
    res = [[0]*n for _ in range(m)]
    for i in range(m):
        for j in range(n):
            res[i][j] = a[n-1-j][i]
    return res

def op4(a):  # 반시계 90도
    n, m = len(a), len(a[0])
    res = [[0]*n for _ in range(m)]
    for i in range(m):
        for j in range(n):
            res[i][j] = a[j][m-1-i]
    return res

def op5(a):  # 사분면 시계 방향 이동 (1→2→3→4→1)
    n, m = len(a), len(a[0])
    hn, hm = n//2, m//2
    res = [[0]*m for _ in range(n)]

    # 1 -> 2
    for i in range(hn):
        for j in range(hm):
            res[i][j+hm] = a[i][j]
    # 2 -> 3
    for i in range(hn):
        for j in range(hm, m):
            res[i+hn][j] = a[i][j]
    # 3 -> 4
    for i in range(hn, n):
        for j in range(hm, m):
            res[i][j-hm] = a[i][j]
    # 4 -> 1
    for i in range(hn, n):
        for j in range(hm):
            res[i-hn][j] = a[i][j]

    return res

def op6(a):  # 사분면 반시계 방향 이동 (1→4→3→2→1)
    n, m = len(a), len(a[0])
    hn, hm = n//2, m//2
    res = [[0]*m for _ in range(n)]

    # 1 -> 4
    for i in range(hn):
        for j in range(hm):
            res[i+hn][j] = a[i][j]
    # 4 -> 3
    for i in range(hn, n):
        for j in range(hm):
            res[i][j+hm] = a[i][j]
    # 3 -> 2
    for i in range(hn, n):
        for j in range(hm, m):
            res[i-hn][j] = a[i][j]
    # 2 -> 1
    for i in range(hn):
        for j in range(hm, m):
            res[i][j-hm] = a[i][j]

    return res

dispatch = {1: op1, 2: op2, 3: op3, 4: op4, 5: op5, 6: op6}

for op in ops:
    arr = dispatch[op](arr)

for row in arr:
    print(*row)