# 写一个函数，输入n，求菲波那切数列的第n项。


def fibonacci(num):
    if num == 0:
        return 0
    elif num == 1 or num == 2:
        return 1
    pre = 1
    preOne = 1
    current = 2
    for i in range(3, num):
        current = pre + preOne
        preOne = pre
        pre = current
    return current
