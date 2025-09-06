N,M = map(int, input().split())
graph = [list(map(int, input().strip())) for _ in range(N)]
r = min(N,M)
flag = False

for n in range(r-1,-1,-1):
  for i in range(N-n):
    for j in range(M-n):
      if graph[i][j] == graph[i+n][j] == graph[i][j+n] == graph[i+n][j+n]:
          print((n+1)*(n+1))
          flag = True
          break
    if flag:
      break
  if flag:
    break

if not flag:
    print(1)