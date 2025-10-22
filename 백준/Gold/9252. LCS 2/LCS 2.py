str1 = list(input().rstrip())
str2 = list(input().rstrip())

DP = [[0 for j in range(len(str2)+1)] for i in range(len(str1)+1)]
path = []

for i in range(1, len(str1)+1):
    for j in range(1, len(str2)+1):
        if str1[i-1] == str2[j-1]:
            DP[i][j] = DP[i-1][j-1] + 1
        else:
            DP[i][j] = max(DP[i-1][j], DP[i][j-1])
print(DP[len(str1)][len(str2)])

def getText(r,c):
    if r==0 or c==0:
        return
    if str1[r-1] == str2[c-1]:
        path.append(str1[r-1])
        getText(r-1,c-1)
    else:
        if DP[r-1][c] > DP[r][c-1]:
            getText(r-1,c)
        else:
            getText(r,c-1)
getText(len(str1), len(str2))

for i in range(len(path)-1,-1,-1):
    print(path.pop(i), end='')