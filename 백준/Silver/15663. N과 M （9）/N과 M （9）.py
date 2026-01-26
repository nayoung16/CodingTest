n,m = map(int, input().split())
numbers = list(map(int, input().split()))
numbers.sort()
visited = [False] * n
result = []

def dfs(depth):
    if depth == m:
        print(*result)
        return
    prev = None
    for i in range(n):
        if visited[i]:
            continue
        if prev == numbers[i]:
            continue
        visited[i] = True
        result.append(numbers[i])
        prev = numbers[i]

        dfs(depth + 1)
        
        result.pop()
        visited[i] = False

dfs(0)