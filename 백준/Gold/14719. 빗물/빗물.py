h,w = map(int, input().split())
heights = list(map(int, input().split()))

left = 0
right = w-1
left_max = heights[left]
right_max = heights[right]
result = 0

while left < right:
    if left_max <= right_max:
        left += 1
        left_max = max(left_max, heights[left])
        result += left_max - heights[left]
    else:
        right -= 1
        right_max = max(right_max, heights[right])
        result += right_max - heights[right]

print(result)