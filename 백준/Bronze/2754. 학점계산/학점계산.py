target = input()

def score(grade):
    match grade:
        case 'A+': return 4.3
        case 'A0' : return 4.0
        case 'A-' : return 3.7
        case 'B+': return 3.3
        case 'B0': return 3.0
        case 'B-': return 2.7
        case 'C+': return 2.3
        case 'C0': return 2.0
        case 'C-': return 1.7
        case 'D+': return 1.3
        case 'D0': return 1.0
        case 'D-': return 0.7
        case 'F': return 0.0

print(score(target))