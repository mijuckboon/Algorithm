stdin = open(0)
input_str = lambda: stdin.readline().rstrip()

row, col, small = map(int,input_str().split())
board = [input_str() for i in range(row)]

board1 = [[0]*col for _ in range(row)]
board2 = [[0]*col for _ in range(row)]

for i in range(row):
    for j in range(col):
        if (i + j) % 2 == 0:
            if board[i][j] != 'W':
                board1[i][j] = 1
            if board[i][j] != 'B':
                board2[i][j] = 1
        else:
            if board[i][j] != 'B':
                board1[i][j] = 1
            if board[i][j] != 'W':
                board2[i][j] = 1

def get_cumul_sum(array):
    cumul_sum = [[0]*(col+1) for _ in range(row+1)]
    for i in range(1,row+1):
        for j in range(1,col+1):
            cumul_sum[i][j] = cumul_sum[i][j-1] + cumul_sum[i-1][j] - cumul_sum[i-1][j-1] + array[i-1][j-1]
    return cumul_sum

cumul1 = get_cumul_sum(board1)
cumul2 = get_cumul_sum(board2)

def get_partial_sum(array,x1,y1,x2,y2):
    return array[x2+1][y2+1]-array[x1][y2+1]-array[x2+1][y1]+array[x1][y1]

cnt = row*col
for i in range(row-small+1):
    for j in range(col-small+1):
        cnt1 = get_partial_sum(cumul1,i,j,i+small-1,j+small-1)
        cnt2 = get_partial_sum(cumul2,i,j,i+small-1,j+small-1)
        cnt = min([cnt1,cnt2,cnt])

print(cnt)