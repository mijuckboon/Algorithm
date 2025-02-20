stdin = open(0)
input_alter = lambda : stdin.readline().rstrip()

conv_to_ints = lambda iterable: map(int, iterable)

num = input_alter()
nums = conv_to_ints(input_alter().split())
nums = list(nums)

minimum, maximum = min(nums), max(nums)
print(minimum, maximum)