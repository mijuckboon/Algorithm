stdin = open(0)
input_alter = lambda: stdin.readline().rstrip()

num = int(input_alter())

balloons = list(range(1,num+1))
papers = list(map(int,input_alter().split()))

pos = 0
while len(papers) > 1:
    print(balloons.pop(pos), end = ' ')
    paper = papers[pos]
    papers.pop(pos)
    if paper > 0:
        pos = (pos+paper-1)%len(balloons)
    if paper < 0:
        pos = (pos+paper)%len(balloons)
print(balloons[0])