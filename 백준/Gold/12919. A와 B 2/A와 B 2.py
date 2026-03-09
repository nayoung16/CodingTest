s = input()
t = input()

def dfs(t):
    if len(t) == len(s):
        return t == s

    result = False

    if t[-1] == 'A':
        result |= dfs(t[:-1])

    if t[0] == 'B':
        result |= dfs(t[1:][::-1])

    return result

print(1 if dfs(t) else 0)