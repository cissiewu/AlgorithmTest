# -*-coding=utf-8-*-
"""
用两个栈来实现一个队列。
方法：第一个栈临时保存插入的数据，当调用弹出函数的时候，如果stack2不为空，则直接弹出；
为空则把stack1中的数据全部弹出放到stack2.
"""
class Solution:
    def __int__(self):
        self.stack1=[]
        self.stack2=[]

    def push(self,node):
        self.stack1.append(node)

    def pop(self):
        if self.stack2:
            return self.stack2.pop()
        else:
            while self.stack1:
                self.stack2.append(self.stack1.pop())
            return self.stack2.pop()