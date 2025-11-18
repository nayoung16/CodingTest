n = int(input())
dp = [0] * (n+1)
parent = [0] * (n+1)

for i in range(2, n+1):
    dp[i] = dp[i-1] + 1
    parent[i] = i-1

    if i % 2 == 0 and dp[i] > dp[i//2] + 1:
        dp[i] = dp[i//2] + 1
        parent[i] = i//2

    if i % 3 == 0 and dp[i] > dp[i//3] + 1:
        dp[i] = dp[i//3] + 1
        parent[i] = i//3

print(dp[n])

path = []
while n != 0:
    path.append(n)
    if n == 0:
        break
    n = parent[n]
print(*path)

