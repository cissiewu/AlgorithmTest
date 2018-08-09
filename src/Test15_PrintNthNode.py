# -*- coding=utf-8 -*-
"""
 Description：
 Date：2018/8/7 14:16
 Version: 1.0
 Author: WuXi
"""
class ListNode:
    def __init__(self, data):
        self.value = data
        self.next = None


class Solution:
    def print_kth_node(self, head, k):
        if self.head == None or k < 1:
            return
        pointer = self.head
        for i in range(1, k - 1):
            pointer = pointer.next
        while pointer.next != None:
            head = head.next
            pointer = pointer.next
        return head


if __name__ == "__main__":
    list = [1, 2, 3, 4, 5, 6]
    Solution.print_kth_node(list, 3)
    print r

