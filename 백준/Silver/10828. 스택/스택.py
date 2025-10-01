N = int(input())
s = []
result = []

for _ in range(N):
    order = input().split()

    if order[0] == 'push':
        s.append(int(order[1]))
    elif order[0] == 'pop':
        result.append(str(s.pop()) if s else "-1")
    elif order[0] == 'size':
        result.append(str(len(s)))
    elif order[0] == 'empty':
        result.append("0" if s else "1")
    elif order[0] == 'top':
        result.append(str(s[-1]) if s else "-1")

print("\n".join(result))