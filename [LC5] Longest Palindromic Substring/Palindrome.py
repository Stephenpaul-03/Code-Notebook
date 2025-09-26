def palindrome(s):
    if len(s) <= 1:
        return s

    def center_expand(left, right):
        while left >= 0 and right < len(s) and s[left] == s[right]:
            left -= 1
            right += 1
        return s[left + 1:right]

    longest_palindrome = ""
    for i in range(len(s)):
        odd_pal = center_expand(i, i)
        if len(odd_pal) > len(longest_palindrome):
            longest_palindrome = odd_pal

        even_pal = center_expand(i, i + 1)
        if len(even_pal) > len(longest_palindrome):
            longest_palindrome = even_pal

    return longest_palindrome

t = int(input("Enter the number of test cases: "))
for _ in range(t):
    input_str = input("Enter a string: ")
    print(palindrome(input_str))
