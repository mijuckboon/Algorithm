num = int(input())
rep = 2*num - 1

def star(nat):
    if nat <= num:
        return ' '*(num-nat) + '*'*(2*nat-1)
    return star(2*num-nat)

for i in range(1,rep+1):
    print(star(i))