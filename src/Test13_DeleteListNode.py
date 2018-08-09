# -*- coding=utf-8 -*-
"""
 Description：
 Date：2018/8/6 16:05
 Version: 1.0
 Author: WuXi

给定单向链表的头指针和一个结点指针，定义一个函数在O(1)时间删除该结点。
    * 链表结点
"""


class ListNode:
    def __init__(self, x=None):
        self.value - x
        self.next = None

    def __del__(self):
        self.value = None
        self.next = None


class Solution:
    def delete_node(self, head, toBeDeleted):
        if not head or not toBeDeleted:
            return None
        if toBeDeleted.next != None:
            toBeDeleted.value = toBeDeleted.next.value
            toBeDeleted.next = toBeDeleted.next.next
            toBeDeleted.next.__del__()

        elif head == toBeDeleted:
            toBeDeleted.__del__()
            head.__del__()
        else:
            temp = head
            while temp != toBeDeleted:
                temp = temp.next
            head.next = None
            toBeDeleted.__del__()


