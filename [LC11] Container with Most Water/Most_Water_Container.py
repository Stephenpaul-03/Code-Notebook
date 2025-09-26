def max_area(arr):
    left, right = 0, len(arr) - 1
    max_area = 0

    while left < right:
        width = right - left
        height = min(arr[left], arr[right])
        area = width * height
        max_area = max(max_area, area)

        if arr[left] < arr[right]:
            left += 1
        else:
            right -= 1

    return max_area

def main():
    t = int(input("Enter Test Case Count: "))
    for _ in range(t):
        arr = list(map(int, input("Enter Array Elements (space-separated): ").split()))
        print(max_area(arr))

if __name__ == "__main__":
    main()
