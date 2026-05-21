def solution(today, terms, privacies):
    answer = list()
    term_dict = dict()
    for term in terms:
        a,b = term.split(' ')
        term_dict[a] = int(b)
        
    today_year, today_month, today_date = map(int, today.split('.'))
    today_days = today_year * 12 * 28 + today_month * 28 + today_date
    
    for i, privacy in enumerate(privacies):
        privacy_date, privacy_type = privacy.split(' ')
        p_year, p_month, p_date = map(int, privacy_date.split('.'))
        p_days = p_year * 12 * 28 + (p_month+term_dict[privacy_type]) * 28 + p_date
            
        if today_days >= p_days:
            answer.append(i+1)
    return answer