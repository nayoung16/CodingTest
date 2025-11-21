def dfs(start, path):
    if len(path) == 6:
        print(*path)
        return
    for i in range(start, k):
        path.append(nums[i])
        dfs(i+1, path)
        path.pop()

while True:
    arr = list(map(int, input().split()))
    k = arr[0]
    if k == 0:
        break
    nums = arr[1:]
    
    dfs(0,[])
    print()