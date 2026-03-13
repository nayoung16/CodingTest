import heapq
import sys
input = sys.stdin.readline

n = int(input())
arr = []
answer = 0
for _ in range(n):
    x = int(input())
    if x > 0:
        heapq.heappush(arr,x)
    else:
        if not arr:
            print(0)
        else:
            print(heapq.heappop(arr))