def largest_number(arr):
    arr = list(map(str, arr))
    sorted_arr = sorted(arr, key=lambda x: x * 10, reverse=True)
    result = ''.join(sorted_arr)
    return '0' if result[0] == '0' else result


t = int(input())
for _ in range(t):
    arr = list(map(int, input().split()))
    print(largest_number(arr))
