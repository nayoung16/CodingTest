n,m = map(int, input().split())
numbers = list(map(int, input().split()))
numbers.sort()

def dfs(depth, result):
    if depth == m:
        print(*result)
        return
    for number in numbers:
        if result == [] or number >= result[-1]:
            result.append(number)
            dfs(depth+1, result)
            result.pop()

dfs(0,[])