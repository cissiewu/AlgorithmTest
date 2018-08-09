# -*- coding=utf-8 -*-
"""
 Description：
 Date：2018/8/7 13:50
 Version: 1.0
 Author: WuXi
"""
"""
    *输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
    *使得所有奇数位于数组的前半部分，所有偶数位予数组的后半部分。
    * @param arr输入的数组
    * 思路：维护两个指针，第一个指针初始化时指向数组的第一个数字，它只向后移动：第二个指针初始化时指向数组的最后一个数字，
    * 它只向前移动。在两个指针相遇之前，第一个指针总是位于第二个指针的前面。如果第一个指针指向的数字是偶数，并且第二个指针指向的数字是奇数，我们就交换这两个数字。
"""


def reorder_odd_even(arr):
    if arr == None or len(arr) < 2:
        return
    start = 0
    end = len(arr) - 1
    while start < end:
        while arr[start] % 2 != 0:
            start += 1
        while arr[end] % 2 == 0:
            end -= 1
        tmp = arr[start]
        arr[start] = arr[end]
        arr[end] = tmp
    return arr


def print_arr(arr):
    for i in arr:
        print str(i) + " "


if __name__ == "__main__":
    arr = [1, 2, 3, 4, 5, 7, 8, 9]

    print_arr(reorder_odd_even(arr))