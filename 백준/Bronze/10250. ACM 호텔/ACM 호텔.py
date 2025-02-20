stdin = open(0)
input_alter = lambda: stdin.readline().rstrip()

rep = int(input_alter())

def room(height,width,order):
    floor = (order - 1) % height + 1
    room_no = (order - 1) // height + 1
    if room_no < 10:
        room_no = "0" + str(room_no)
    return str(floor) + str(room_no)

for i in range(rep):
    nums = map(int, input_alter().split())
    print(room(*nums))