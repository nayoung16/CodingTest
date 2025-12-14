answer = 0
index = 0
for i in range(9):
    num = int(input())
    if num > answer:
        answer = num
        index = i
print(answer)
print(index+1)