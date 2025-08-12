def solution(my_string):
    filtered_list = [int(char) for char in my_string if char in '0123456789']
    return sorted(filtered_list)