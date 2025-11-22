l = int(input())
numbers = list(map(int, input().split()))
n = int(input())
left, right = 0,l
numbers.sort()

if n in numbers:
    print(0)
elif n > numbers[-1]:
    print(0)
else:
    if n < numbers[0]:
        left, right = 0, numbers[0]
    else:
        for i in range(len(numbers)):
            if numbers[i] > n:
                left = numbers[i-1]
                right = numbers[i]
                break

    all_diff = right-left-1
    left_diff = n-left-1
    right_diff = right-1-n
    answer = all_diff*(all_diff-1)//2-(left_diff*(left_diff-1)//2 + right_diff*(right_diff-1)//2)
    print(answer)