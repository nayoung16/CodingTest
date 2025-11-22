import heapq
n = int(input())
heap = []
for _ in range(n):
    row = map(int, input().split())
    for x in row:
        if len(heap) < n:
            heapq.heappush(heap,x)
        else:
            if x > heap[0]:
                heapq.heapreplace(heap,x)
print(heap[0])