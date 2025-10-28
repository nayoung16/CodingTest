n = int(input())
revenue = []
for _ in range(n):
    rev = list(map(int, input().split()))
    revenue.append(rev)

max_rev = -1000

ps = [[0] * (n+1) for _ in range(n+1)]
for y in range(1, n+1):
    for x in range(1, n+1):
        ps[y][x] = (
            revenue[y-1][x-1]
            + ps[y-1][x]
            + ps[y][x-1]
            - ps[y-1][x-1]
        )

def cal_sum(y, x, k):
    y2 = y + k - 1
    x2 = x + k - 1
    return (
        ps[y2+1][x2+1]
        - ps[y][x2+1]
        - ps[y2+1][x]
        + ps[y][x]
    )

for k in range(1,n+1):
    for i in range(0,n-k+1):
        for j in range(0,n-k+1):
            cur_sum = cal_sum(i,j,k)
            if cur_sum > max_rev:
                max_rev = cur_sum
print(max_rev)