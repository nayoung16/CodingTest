target = input().strip()

idx = 0
num = 1

while True:
    for c in str(num):
        if idx < len(target) and c == target[idx]:
            idx += 1
        if idx == len(target):
            print(num)
            exit()
    num += 1