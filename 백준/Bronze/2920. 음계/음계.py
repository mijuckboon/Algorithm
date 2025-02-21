to_det = input()

def det(song):
    match song:
        case '1 2 3 4 5 6 7 8':
            return 'ascending'
        case '8 7 6 5 4 3 2 1':
            return 'descending'
        case _:
            return 'mixed'

print(det(to_det))