def solution(data, ext, val_ext, sort_by):
    answer = []
    
    def get_year(data):
        return data // 10000
    
    def get_month(data):
        return (data % 10000) // 100
    
    def get_date(data):
        return (data % 100)
    
    def check(data, index):
        if data[index] < val_ext:
            return True
        return False
    
    def check_date(data, val_year, val_month, val_date):
        cur_year = get_year(data)
        cur_month = get_month(data)
        cur_date = get_date(data)
        if cur_year <= val_year:
            if cur_month < val_month:
                return True
            elif cur_month == val_month:
                if cur_date < val_date:
                    return True
        return False
    
    if ext == 'code':
        for d in data:
            if check(d, 0):
                answer.append(d)
        
    elif ext == 'date':
        val_year = get_year(val_ext)
        val_month = get_month(val_ext)
        val_date = get_date(val_ext)
        
        for d in data:
            if check_date(d[1], val_year, val_month, val_date):
                answer.append(d)
        
    elif ext == 'maximum':
        for d in data:
            if check(d, 2):
                answer.append(d)
        
    elif ext == 'remain':
        for d in data:
            if check(d, 3):
                answer.append(d)
            
    key_index = 0
    if sort_by == 'code':
        key_index = 0
    elif sort_by == 'date':
        key_index = 1
    elif sort_by == 'maximum':
        key_index = 2
    elif sort_by == 'remain':
        key_index = 3
        
    answer.sort(key = lambda x: x[key_index])
        
    return answer