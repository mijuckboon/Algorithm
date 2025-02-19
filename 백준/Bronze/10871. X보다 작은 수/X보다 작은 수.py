input_alter = open(0).readline

omit, compare = map(int,input_alter().rstrip().split())
nums = map(int,input_alter().rstrip().split())

results = filter(lambda x: x < compare, nums)
print(*results)