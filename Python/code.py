print(ord('A'),ord('中'),chr(66),chr(25991))

x=b'abc'
print(x)

print('ABC encode ascii:\t','ABC'.encode('ascii'))
print('中文 utf-8:\t','中文'.encode('utf-8'))

print('b\'ABC\' decode ascii:\t',b'ABC'.decode('ascii'))
print('b\'\\xe4\\xb8\\xad\\xe6\\x96\\x87\' decode utf-8:\t',b'\xe4\xb8\xad\xe6\x96\x87'.decode('utf-8'))



print('hello,%s'%('world'))
print('你好 %s，你的余额%d'%('Yihleego',450))


print('%2d-%03d'%(3,1))
print('%.2f'%(3.1415936))

#如果你不太确定应该用什么，%s永远起作用，它会把任何数据类型转换为字符串
print('Age: %s. Gender: %s' % (25, True))

#有些时候，字符串里面的%是一个普通字符怎么办？这个时候就需要转义，用%%来表示一个%
print('growth rate: %d %%' % 7)

s1=72
s2=85
res=(s2-s1)/s1*100
print('李明成绩提高了：%02.1f %%'%(res))

input()