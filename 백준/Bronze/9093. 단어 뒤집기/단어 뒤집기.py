T = int(input())
for _ in range(T):
    str = list(input().split())
    new_str = []
    for word in str:
        new_str.append(word[::-1])
    print(*new_str)