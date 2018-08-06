# -*- coding=utf-8 -*-
"""
 Description：
 Date：2018/8/6 11:13
 Version: 1.0
 Author: WuXi
"""


def print_one(n):
    number = 1
    i = 0
    while (i < n):
        number *= 10
        i += 1
    for j in range(1, number):
        print j


if __name__ == "__main__":
    print_one(3)
