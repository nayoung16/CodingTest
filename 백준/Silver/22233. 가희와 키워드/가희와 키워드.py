import sys
input = sys.stdin.readline
n,m = map(int, input().split())

keywords = set()
for i in range(n):
    word = input().rstrip()
    keywords.add(word)

for i in range(m):
    line = input().strip()
    words = line.split(',')
    for word in words:
        keywords.discard(word)
    print(len(keywords))
