import math
abs(100)
abs(-100)
abs(11.2)

max(1,2)

int('123')
int(12.34)
float('12.34')
str(1.34)
bool(1)
bool('')

a=abs
a(-1)

print(hex(17))


def my_abs(x):
    if not isinstance(x, (int, float)):
        raise TypeError('bad operand type')
    if x >= 0:
        return x
    else:
        return -x


print(my_abs(-10))

print('\n'.join([''.join([('PYTHON!'[(x-y)%7]if((x*0.05)**2+(y*0.1)**2-1)**3-(x*0.05)**2*(y*0.1)**3<=0 else' ')for x in range(-30,30)])for y in range(15,-15,-1)]))


def move(x, y, step, angle=0):
    nx = x + step * math.cos(angle)
    ny = y - step * math.sin(angle)
    return nx, ny

x, y = move(100, 100, 60, math.pi / 6)
print(x, y)



r = move(100, 100, 60, math.pi / 6)
print(r)
#返回值是一个tuple




def power(x):
    return x * x
print(power(5))



def power(x, n):
    s = 1
    while n > 0:
        n = n - 1
        s = s * x
    return s

print(power(2,10))


def power(x, n=2):
    s = 1
    while n > 0:
        n = n - 1
        s = s * x
    return s
print(power(5))
print(power(5,2))



def enroll(name, gender):
    print('name:', name)
    print('gender:', gender)
enroll('Sarah', 'F')


def enroll(name, gender, age=6, city='Beijing'):
    print('name:', name)
    print('gender:', gender)
    print('age:', age)
    print('city:', city)
enroll('Sarah', 'F')


def add_end(L=[]):
    L.append('END')
    return L

def add_end(L=None):
    if L is None:
        L = []
    L.append('END')
    return L



#递归
def fact(n):
    if n==1:
        return 1
    return n * fact(n - 1)


def move(n, a, b, c):
    if n == 1:
        print('move', a, '-->', c)
        return
    move(n-1, a, c, b)
    print('move', a, '-->', c)
    move(n-1, b, a, c)

move(4, 'A', 'B', 'C')

input()