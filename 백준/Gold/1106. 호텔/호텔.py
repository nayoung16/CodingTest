c,n = map(int, input().split())
cities = [tuple(map(int, input().split()))for _ in range(n)]

max_p = max(p for _,p in cities)
limit = c + max_p

INF = 10**12
dp = [INF] * (limit + 1)
dp[0] = 0

for cost, people in cities:
    for x in range(people, limit+1):
        if dp[x-people] + cost < dp[x]:
            dp[x] = dp[x - people] + cost
print(min(dp[c:]))