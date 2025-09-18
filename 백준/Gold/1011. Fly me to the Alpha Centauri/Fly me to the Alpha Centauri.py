from math import sqrt

T = int(input())
for _ in range(T):
    x,y = map(int, input().split())
    d = y-x
    n = int(sqrt(d))
    if d == n*n:
        print(2*n-1)
    elif n*n < d <= n*n + n:
        print(2*n)
    elif n*n + n < d <= (n+1)*(n+1):
        print(2*n+1)
