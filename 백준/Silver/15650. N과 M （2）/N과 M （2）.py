n,m = map(int, input().split())
result = []
visited = [False for _ in range(n+1)]

def dfs(depth):
    if depth == m:
        print(*result)
        return

    for i in range(1,n+1):
        if visited[i]:
            continue
        if len(result) > 0 and i > result[-1] or result == []:
            visited[i] = True
            result.append(i)

            dfs(depth+1)
            result.pop()
            visited[i] = False

dfs(0)