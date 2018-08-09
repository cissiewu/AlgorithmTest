# -*-coding=utf-8-*-
"""
旋转数组的最小数字
* 把一个数组最开始的若干个元素搬到末尾，我们称之为数组的旋转。
* 输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。
* 如{3，4,5,1,2}是数组{1,2,3,4,5}的一个旋转，该数组的最小值是1
"""


def minNumber(rotateArray):
    p1 = 0
    p2 = len(rotateArray) - 1
    mid = p1
    while rotateArray[p1] >= rotateArray[p2]:
        if p2 - p1 == 1:
            mid = p2
            break
        if rotateArray[mid] >= rotateArray[p1]:
            p1 = mid
        elif rotateArray[mid] <= rotateArray[p2]:
            p2 = mid
    return rotateArray[mid]


print minNumber([5, 1, 2, 3, 4])
