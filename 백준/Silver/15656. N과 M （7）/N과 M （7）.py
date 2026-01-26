n,m = map(int, input().split())
numbers = list(map(int, input().split()))
numbers.sort()

def dfs(depth, result):
    if depth == m:
        print(*result)
        return
    for number in numbers:
        result.append(number)
        dfs(depth+1, result)
        result.pop()

dfs(0,[])