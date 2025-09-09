# 연산자 개수만 가지고 DFS 백트래킹 - O(4^N)
from math import inf
N = int(input())
nums = list(map(int, input().split()))
add, sub, mul, div = map(int, input().split())

min_answer = inf
max_answer = -inf

def dfs(idx, cur, a, s, m, d):
  global min_answer, max_answer
  if idx == N:
    if cur < min_answer: min_answer = cur
    if cur > max_answer: max_answer = cur
    return
  
  nxt = nums[idx]

  if a:
    dfs(idx+1, cur + nxt, a-1, s, m, d)
  if s:
    dfs(idx+1, cur - nxt, a, s-1, m, d)
  if m:
    dfs(idx+1, cur * nxt, a, s, m-1, d)
  if d:
    if cur < 0:
      dfs(idx+1, -((-cur) // nxt), a, s, m, d-1)
    else:
      dfs(idx+1, cur // nxt, a, s, m, d-1)

dfs(1, nums[0], add, sub, mul, div)
print(max_answer)
print(min_answer)