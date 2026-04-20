n = int(input())
heights = list(map(int, input().split()))
result = [0 for _ in range(n)]
stack = []
for i in range(n):
    while stack and stack[-1][0] < heights[i]:
        stack.pop()

    if stack:
        result[i] = stack[-1][1] + 1

    stack.append((heights[i],i))
print(*result)