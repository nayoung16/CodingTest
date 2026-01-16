from itertools import combinations

n,k = map(int, input().split())
base = set("antic")
pick = k - 5

words_need = []
cand_set = set()

for _ in range(n):
    word = input().strip()
    core = word[4:-4]
    need = set(core) - base # 이 단어를 읽기 위해 추가로 배워야 하는 글자들
    words_need.append(need)
    cand_set |= need

cands = list(cand_set)

if pick < 0:
    print(0)
    exit()
if pick == 0:
    print(sum(1 for need in words_need if not need))
    exit()
if pick >= len(cands):
    print(n)
    exit()

ans = 0
for comb in combinations(cands, pick):
    learned = set(comb)
    cnt = 0
    for need in words_need:
        if need.issubset(learned):
            cnt += 1
    if cnt > ans:
        ans = cnt
print(ans)