#——————————map——————————————
def f(x):
    return x*x

array1=[1,2,3,4,5,6,7,8,9]
map1=map(f,array1)
list1=list(map1)
print(list1)

map2=map(str,array1)
list2=list(map2)
print(list2)

#——————————reduce——————————————
from functools import reduce
def add(x,y):
    return x+y

array2=[1,2,3,4,5,6,7,8,9]


sum1=reduce(add,array2)
print(sum1)


def fn(x,y):
    return x * 10 + y

sum2=reduce(fn,array2)
print(sum2)

def char2num(s):
    return {'0': 0, '1': 1, '2': 2, '3': 3, '4': 4, '5': 5, '6': 6, '7': 7, '8': 8, '9': 9}[s]

map3=map(char2num,'46541321')
sum3=reduce(fn,map3)
print(sum3)


#整理成一个str2int的函数就是：
def str2int(s):    
    def fnX(x,y):
        return x * 10 + y
    def char2numX(s):
        return {'0': 0, '1': 1, '2': 2, '3': 3, '4': 4, '5': 5, '6': 6, '7': 7, '8': 8, '9': 9}[s]
    return reduce(fnX,map(char2numX,s))
print(str2int('5464613'))


#用lambda函数进一步简化成：
def str2intX(s):
    return reduce(lambda x, y: x * 10 + y, map(char2num, s))
print(str2intX('5464613'))


def normalize(name):
    return name[:1].upper()+name[1:].lower()

L1 = ['adam', 'LISA', 'barT']
L2 = list(map(normalize, L1))

print(L2)


def prod(L):
    def fnXX(x,y):
        return x*y
    return reduce(fnXX,L)

print('3 * 5 * 7 * 9 =', prod([3, 5, 7, 9]))


def str2float(s):    
    left, right = s.split('.')
    t = len(right)

    def fnXXX(x,y):        
        return 10*x+y
    def str2numXXX(s):
        return {'0': 0, '1': 1, '2': 2, '3': 3, '4': 4, '5': 5, '6': 6, '7': 7, '8': 8, '9': 9}[s]
    return reduce(fnXXX,map(str2numXXX,left))+reduce(fnXXX,map(str2numXXX,right)) / 10**t

        

print('str2float(\'123.456\') =', str2float('123.456'))



input()