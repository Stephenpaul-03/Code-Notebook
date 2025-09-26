def lcs(s1, s2, m, n):
    if m == 0 or n == 0:
        return 0

    if s1[m - 1] == s2[n - 1]:
        return 1 + lcs(s1, s2, m - 1, n - 1)
    else:
        return max(lcs(s1, s2, m, n - 1), lcs(s1, s2, m - 1, n))

def main():
    s1 = input("Enter first string: ")
    s2 = input("Enter second string: ")

    m = len(s1)
    n = len(s2)

    print("Length of LCS:", lcs(s1, s2, m, n))

if __name__ == "__main__":
    main()
