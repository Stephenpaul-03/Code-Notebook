def recursive_binary(arr, low, high, key):
    if low > high:
        return -1
    mid = low + (high - low) // 2

    if arr[mid] == key:
        return mid

    if arr[low] <= arr[mid]:
        if arr[low] <= key < arr[mid]:
            return recursive_binary(arr, low, mid - 1, key)
        else:
            return recursive_binary(arr, mid + 1, high, key)
    else:
        if arr[mid] < key <= arr[high]:
            return recursive_binary(arr, mid + 1, high, key)
        else:
            return recursive_binary(arr, low, mid - 1, key)


t = int(input("Enter Test Case Count: "))
for _ in range(t):
    input_arr = list(map(int, input("Enter Array Elements (space-separated): ").split()))
    key = int(input("Enter Key: "))
    result = recursive_binary(input_arr, 0, len(input_arr) - 1, key)
    print(result)
