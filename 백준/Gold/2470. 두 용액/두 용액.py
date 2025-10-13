n = int(input())
liquid = list(map(int, input().split()))
liquid.sort()
start, end = 0, n-1
best_start, best_end = 0,0
best_sum = float('inf')
while start < end:
    cur_sum = liquid[start] + liquid[end]
    if abs(cur_sum) < abs(best_sum):
        best_sum = cur_sum
        best_start, best_end = start, end
        if best_sum == 0:
            break
    if cur_sum > 0:
        end -= 1
    else:
        start += 1
print(liquid[best_start], liquid[best_end])