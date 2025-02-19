input_alter = open(0).readline

def sum_list(targ_str):
    list_targ = targ_str.split()
    return map(int,list_targ)

while True:
    str_to_convert = input_alter().rstrip()
    if not str_to_convert: break
    sum_targ = sum_list(str_to_convert)
    sum_targ = list(sum_targ)
    compute_sum = sum(sum_targ)
    print(compute_sum)