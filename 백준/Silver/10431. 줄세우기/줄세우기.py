p = int(input())
for _ in range(p):
    students = list(map(int, input().split()))
    t_num = students[0]
    students = students[1:]
    answer = 0
    for i in range(0,20):
        cur_student = students[i]
        for j in range(0,i):
            if students[j] > cur_student:
                # 물러난 걸음 수 : i-j
                answer += (i-j)
                students.pop(i)
                students.insert(j, cur_student)
                break
    print(f"{t_num} {answer}")