result = []

pairs = {
    ')': '(',
    ']': '['
}
openers = set(pairs.values())
closers = set(pairs.keys())
while True:
    str = input()
    if str == '.':
        break

    stack = []
    ok = True
    for ch in str:
        if ch in openers:
            stack.append(ch)
        elif ch in closers:
            if not stack or stack[-1] != pairs[ch]:
                ok = False
                break
            stack.pop()

    if stack:
        ok = False

    result.append('yes' if ok else 'no')

print('\n'.join(result))