#-*-coding:utf-8-*- 

def is_odd(n):
	return n%2==1

array=[1,2,3,4,5,6,7,8,9]
list1=list(filter(is_odd,array))
print(list1)


def not_empty(s):
	return s and s.strip()
array2=['1','2',None,'',' ','6',None,'None']
list2=list(filter(not_empty,array2))
print(list2)


def _odd_iter():
    n = 1
    while True:
        n = n + 2
        yield n
def _not_divisible(n):
    return lambda x: x % n > 0

def primes():
    yield 2
    it = _odd_iter() # 初始序列
    while True:
        n = next(it) # 返回序列的第一个数
        yield n
        it = filter(_not_divisible(n), it) # 构造新序列


primesList=[]
for n in primes():
    if n < 1000:
        primesList.append(n)
    else:
        break
print(primesList)




def is_palindrome(n):
	return n == int(str(n)[::-1])



output = filter(is_palindrome, range(1, 1000))
print(list(output))



input()