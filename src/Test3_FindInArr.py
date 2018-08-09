# -*- coding=utf-8 -*-
"""
 Description：
 Date：2018/7/25 13:20
 Version: 1.0
 Author: WuXi
"""

def find(matrix, number):

    if matrix == None or len(matrix) < 1 or len(matrix[1]) < 1:
        print "%s not right" % matrix
        return False
    rows = len(matrix)
    cols = len(matrix[1])
    row = 0
    col = len(matrix[1]) - 1
    while (row >= 0 and row < rows and col <= cols and col >= 0):
        if matrix[row][col] == number:
            print "%s" % matrix
            print "%d found" % number
            return True
        elif matrix[row][col] > number:
            col -= 1
        else:
            row += 1

    print "%d not found" % number
    return False


if __name__ == "__main__":
    matrix = [
        [1, 2, 3, 4],
        [2, 3, 4, 5],
        [3, 4, 5, 6]
    ]
    find(matrix, 3)
    find(matrix, 7)
    find(None,6)