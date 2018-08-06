# -*- coding=utf-8 -*-
"""
 Description：
 Date：2018/8/6 10:02
 Version: 1.0
 Author: WuXi
    *  实现函数double Power(double base, int exponent)，求base的exponent次方。
     * 不得使用库函数，同时不需要考虑大数问题。
     * @param base 指次
     * @param exponent 幂
     * @return base的exponent次方
 
"""


def double_power(base, exponent):
    if exponent == 0:
        return 1
    if exponent == 1:
        return base

    result = double_power(base, exponent >> 1)
    result *= result
    if exponent % 2:
        result *= base
    return result


def power(base, exponent):
    if base == 0 and exponent == 0:
        raise Exception("input error.")
    if exponent == 0:
        return 1
    exp = exponent
    if exponent < 0:
        exp = -exp
    result = double_power(base, exp)
    if exponent < 0:
        result = 1 / result
    return result


if __name__ == "__main__":
    print power(2, 10)
    print power(2, 11)
