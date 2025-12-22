N = int(input().strip())
M = int(input().strip())

broken = set()
if M > 0:
    broken = set(input().split())

ans = abs(N - 100)

def can_type(x: int) -> bool:
    for ch in str(x):
        if ch in broken:
            return False
    return True

for x in range(1_000_001):
    if can_type(x):
        presses = len(str(x)) + abs(N - x)
        if presses < ans:
            ans = presses

print(ans)