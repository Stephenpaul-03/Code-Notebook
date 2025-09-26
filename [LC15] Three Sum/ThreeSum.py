def three_sum(arr, s):
    arr.sort()
    n = len(arr)
    for i in range(n - 2):
        left, right = i + 1, n - 1
        while left < right:
            total = arr[i] + arr[left] + arr[right]
            if total == s:
                print(arr[i], arr[left], arr[right])
                return True
            elif total < s:
                left += 1
            else:
                right -= 1
    return False


t = int(input("Enter Test Case Count: "))
for _ in range(t):
    arr = list(map(int, input("Enter array elements: ").split()))
    s = int(input("Enter the target sum: "))
    if not three_sum(arr, s):
        print("false")


