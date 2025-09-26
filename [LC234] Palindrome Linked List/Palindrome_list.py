class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


class PalindromeList:
    def is_palindrome(self, head):
        values = []
        current = head
        while current:
            values.append(current.val)
            current = current.next

        left, right = 0, len(values) - 1
        while left < right and values[left] == values[right]:
            left += 1
            right -= 1
        return left >= right

    def construct_linked_list(self, values):
        if not values:
            return None
        head = ListNode(values[0])
        current = head
        for value in values[1:]:
            current.next = ListNode(value)
            current = current.next
        return head


t = int(input().strip())
for _ in range(t):
    values = list(map(int, input().strip().split()))
    solution = PalindromeList()
    head = solution.construct_linked_list(values)
    result = solution.is_palindrome(head)
    print("Palindrome" if result else "Not Palindrome")
