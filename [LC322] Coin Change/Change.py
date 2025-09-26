def count(coins, n, sum_):
    if sum_ == 0:
        return 1
    if sum_ < 0:
        return 0
    if n <= 0:
        return 0

    return count(coins, n - 1, sum_) + count(coins, n, sum_ - coins[n - 1])

def main():
    t = int(input())
    for _ in range(t):
        arr = list(map(int, input().split()))
        sum_ = int(input())
        n = len(arr)
        print(count(arr, n, sum_))

if __name__ == "__main__":
    main()
