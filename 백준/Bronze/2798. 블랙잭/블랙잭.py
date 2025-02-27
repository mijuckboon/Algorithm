num, threshold = map(int,input().split())
cards = list(map(int,input().split()))

possible_max = 0
for i in range(num - 2):
    for j in range(i+1, num - 1):
        for k in range(j+1, num):
            total = cards[i] + cards[j] + cards[k]
            if total <= threshold:
                possible_max = max(total, possible_max)

print(possible_max)