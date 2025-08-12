def solution(numbers):
    numbers.sort()
    # return numbers[-1] * numbers[-2]
    return numbers.pop() * numbers.pop()