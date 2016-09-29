classmates = ['Michael', 'Bob', 'Tracy']

print(classmates)

print('classmate length:',len(classmates))

print(classmates[0])
print(classmates[1])
print(classmates[2])

#索引超出了范围
#print(classmates[3])

# -1做索引 直接获取最后一个元素
print(classmates[-1])

#以此类推，可以获取倒数第2个、倒数第3个
print(classmates[-2])
print(classmates[-3])

#list是一个可变的有序表，所以，可以往list中追加元素到末尾：
classmates.append('Adam')
print(classmates)


#也可以把元素插入到指定的位置，比如索引号为0的位置：
classmates.insert(0, 'Yihleego')
print(classmates)

#要删除list末尾的元素，用pop()方法：
classmates.pop()
print(classmates)

#要删除指定位置的元素，用pop(i)方法，其中i是索引位置：
classmates.pop(1)
print(classmates)

#要把某个元素替换成别的元素，可以直接赋值给对应的索引位置：

classmates[1] = 'Sarah'
print(classmates)


#list里面的元素的数据类型也可以不同，比如：
L = ['Apple', 123, True]
print(L)

#list元素也可以是另一个list，比如：
s = ['python', 'java', ['asp', 'php'], 'scheme']
print(len(s))
print(s[2][1])
#p = ['asp', 'php']
#s = ['python', 'java', p, 'scheme']


#另一种有序列表叫元组：tuple。tuple和list非常类似，但是tuple一旦初始化就不能修改，比如同样是列出同学的名
classmatesTuple = ('Michael', 'Bob', 'Tracy')


#只有1个元素的tuple定义时必须加一个逗号,，来消除歧义：
t = (1,)



#请用索引取出下面list的指定元素：
L = [
    ['Apple', 'Google', 'Microsoft'],
    ['Java', 'Python', 'Ruby', 'PHP'],
    ['Adam', 'Bart', 'Lisa']
]

print(L[0][0])
print(L[1][1])
print(L[2][-1])

input()