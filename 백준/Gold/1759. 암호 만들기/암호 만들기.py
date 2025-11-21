l,c = map(int, input().split())
chars = list(input().split())
chars.sort()

def dfs(i, path, count_m, count_j):
    if len(path) == l and count_m >= 1 and count_j >= 2:
        print("".join(path))
        return
    if len(path) >= l:
        return
    for k in range(i,c):
        path.append(chars[k])
        if chars[k] in ['a','e','i','o','u']:
            dfs(k+1, path, count_m + 1, count_j)
        else:
            dfs(k + 1, path, count_m, count_j+1)
        path.pop()

dfs(0,[],0,0)