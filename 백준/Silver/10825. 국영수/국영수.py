n = int(input())
scores = [list(input().split()) for _ in range(n)]
# 이름 국어 영어 수학
scores.sort(key=lambda x : (-int(x[1]), int(x[2]), -int(x[3]), x[0]))
for score in scores:
    print(score[0])