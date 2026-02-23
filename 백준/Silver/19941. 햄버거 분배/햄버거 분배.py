n,k = map(int, input().split())
str = list(input().strip())
answer = 0
for i in range(len(str)):
    if str[i] == 'P':
        start = max(0,i-k)
        end = min(n-1,i+k)
        for j in range(start,end+1):
            if str[j] == 'H':
                str[j] = 'X'
                answer += 1
                break
print(answer)