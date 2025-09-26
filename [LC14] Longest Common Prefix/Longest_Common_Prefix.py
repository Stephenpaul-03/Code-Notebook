def longest_common_prefix(arr):
    arr.sort()
    first = arr[0]
    last = arr[-1]
    min_len = min(len(first), len(last))
    i = 0
    while i < min_len and first[i] == last[i]:
        i += 1
    return "-1" if i == 0 else first[:i]

arr = input("Enter words separated by spaces:\n").split()
print(longest_common_prefix(arr))
