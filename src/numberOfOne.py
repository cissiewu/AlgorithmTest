# -*- coding=utf-8 -*-
"""
 Description：
 Date：2018/8/3 19:23
 Version: 1.0
 Author: WuXi
"""


class Solution:
    def NumberOf1(self, n):
        mask = 1
        count = 0
        for i in range(32):
            if n & mask:
                count += 1
            mask <<= 1
        return count
