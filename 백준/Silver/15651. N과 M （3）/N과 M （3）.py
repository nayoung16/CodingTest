n,m = map(int, input().split())
result = []
visited = [False for _ in range(n+1)]

def dfs(depth):
    if depth == m:
        print(*result)
        return

    for i in range(1,n+1):
        result.append(i)
        dfs(depth+1)
        result.pop()

dfs(0)