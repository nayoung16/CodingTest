n,k = map(int, input().split())
height = list(map(int, input().split()))
diff = [height[i] - height[i-1] for i in range(1,len(height))]
diff.sort()
answer = sum(diff[:n-k])
print(answer)