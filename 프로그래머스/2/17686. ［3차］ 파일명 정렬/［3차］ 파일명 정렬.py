def solution(files):
    answer = []
    files_list = []
    for file in files:
        head = ''
        number = ''
        tail = ''
        i = 0

        while i < len(file) and not file[i].isdigit():
            head += file[i]
            i += 1
        
        while i < len(file) and file[i].isdigit():
            number += file[i]
            i += 1

        tail = file[i:]
        number = int(number)
        files_list.append([head, number, tail, file])
        
    files_list.sort(key=lambda x : (x[0].lower(), x[1]))
    for file in files_list:
        answer.append(file[3])
                
    return answer