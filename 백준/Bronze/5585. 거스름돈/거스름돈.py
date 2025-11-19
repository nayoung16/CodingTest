n = int(input())
left = 1000 - n
count = 0
while left > 4:
    if left >= 500:
        count += left // 500
        left %= 500
    elif 100 <= left < 500:
        count += left // 100
        left %= 100
    elif 50 <= left < 100:
        count += left // 50
        left %= 50
    elif 10 <= left < 50:
        count += left // 10
        left %= 10
    elif 5 <= left < 10:
        count += left // 5
        left %= 5
count += left
print(count)