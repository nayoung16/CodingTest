# 시간초과 - 중복 순열(permutations) 때문에 경우의 수가 팍 튀어서 TLE 발생

from itertools import permutations

N = int(input())
nums = list(map(int, input().split()))
op = list(map(int, input().split()))
operations = []
for i in range(4):
  for _ in range(op[i]):
    operations.append(i)

min_answer = 1e9
max_answer = -1e9

perm = permutations(operations, len(operations))
for p in perm:
  answer = nums[0]
  for i in range(len(p)):
    if p[i] == 0:
      answer += nums[i+1]
    elif p[i] == 1:
      answer -= nums[i+1]
    elif p[i] == 2:
      answer *= nums[i+1]
    elif p[i] == 3:
      if abs(answer) >= abs(nums[i+1]):
        answer //= nums[i+1]
      else:
        answer = 0
  if answer < min_answer:
    min_answer = answer
  if answer > max_answer:
    max_answer = answer

print(max_answer)
print(min_answer)
