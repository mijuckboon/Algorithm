def solution(emergency):
    rank = []
    
    for patient in emergency:
        cnt = len(set(filter(lambda x: x >= patient, emergency)))
        rank.append(cnt)
        
    return rank