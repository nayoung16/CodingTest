n,m,b = map(int, input().split())
status = {}
ground = []
for _ in range(n):
    row = list(map(int, input().split()))
    for h in row:
        status[h] = status.get(h, 0) + 1

result_time = float('inf')
result_height = 0

for target in range(257):
    time = 0
    inv = b

    for h,cnt in status.items():
        if h > target:
            diff = h - target
            time += 2 * diff * cnt
            inv += diff * cnt
        elif h < target:
            diff = target - h
            time += diff * cnt
            inv -= diff * cnt

    if inv < 0:
        continue
        
    if time < result_time or (time == result_time and target > result_height):
        result_time = time
        result_height = target
print(result_time, result_height)