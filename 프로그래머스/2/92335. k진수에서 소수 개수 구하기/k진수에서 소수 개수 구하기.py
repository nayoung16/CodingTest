def solution(n, k):
    cnt = 0
    num = ''
    while n > 0:
        num += str(n%k)
        n = n//k
    lst = num[::-1].split('0')
    lst = [int(i) for i in lst if (i!='')]

    for num in lst:
        if num == 1 : continue
        if num == 2 or num == 3 : cnt += 1; continue
        cnt += 1
        for j in range(2, int(num**0.5)+1):
            if num % j == 0 : cnt -= 1; break
    return cnt
