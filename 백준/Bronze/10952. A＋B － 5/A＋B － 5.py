input_alter = open(0).readline

def sum_list(targ_str):
    list_targ = targ_str.split()
    return map(int,list_targ)

while True:
    sum_targ = sum_list(input_alter().rstrip())
    sum_targ = list(sum_targ)
    if sum_targ == [0, 0]: break
    compute_sum = sum(sum_targ)
    print(compute_sum)