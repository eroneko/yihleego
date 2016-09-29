#切片
L=['Michael','Sarah','Tracy','Bob','Jack']
#笨办法


r = []
n = 3
for i in range(n):
     r.append(L[i])

#切片（Slice）
L[0:3]
L[:3]
L[1:3]
L[-2:]
L[-2:-1]#倒数第一个元素的索引是-1



L = list(range(100))#创建一个0-99的数列：
L[:10]#前10个数
L[-10:]#后10个数
L[10:20]#前11-20个数
L[:10:2]#前10个数，每两个取一个
L[::5]#所有数，每5个取一个
L[:]#甚至什么都不写，只写[:]就可以原样复制一个list


#tuple也是一种list，唯一区别是tuple不可变。因此，tuple也可以用切片操作，只是操作的结果仍是tuple：
(0, 1, 2, 3, 4, 5)[:3]#(0, 1, 2)





'ABCDEFG'[:3]#'ABC'
'ABCDEFG'[::2]#'ACEG'





#迭代器

#dict迭代
d = {'a': 1, 'b': 2, 'c': 3}
for key in d:
    print(key)

#字符串迭代
for ch in 'ABC':
    print(ch)


from collections import Iterable
print(isinstance('abc', Iterable)) # str是否可迭代
print(isinstance([1,2,3], Iterable)) # list是否可迭代
print(isinstance(123, Iterable)) # 整数是否可迭代


#Python内置的enumerate函数可以把一个list变成索引-元素对
for i, value in enumerate(['A', 'B', 'C']):
    print(i, value)


for x, y in [(1, 1), (2, 4), (3, 9)]:
    print(x, y)



#列表生成式

#生成list [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]可以用list(range(1, 11))
print(list(range(1, 11)))

#生成[1x1, 2x2, 3x3, ..., 10x10]
L = []
for x in range(1, 11):
    L.append(x * x)
#但是循环太繁琐，而列表生成式则可以用一行语句代替循环生成上面的list
[x * x for x in range(1, 11)]
#筛选出仅偶数的平方
[x * x for x in range(1, 11) if x % 2 == 0]




input()



