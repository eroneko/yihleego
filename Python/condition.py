age = 20
if age >= 18:
    print('your age is', age)
    print('adult')


#注意不要少写了冒号:。
age=3
print('ur age is:',age)
if age>=18:	
	print('adult')
else:
    print('teenager')


if age>=18:
	print('adult')
elif age>=6:
	print('teenager')
else:
	print('kid')



#只要x是非零数值、非空字符串、非空list等，就判断为True，否则为False。
x=1
if x:
	print('True')


birth = input('birth: ')
birth = int(birth)
if birth < 2000:
    print('00前')
else:
    print('00后')


height=1.75
weight=80.5
BMI=weight/height/height
if BMI<18.5:
	print('过轻')
elif BMI<25:
	print('正常')
elif BMI<28:
	print('过重')
elif BMI<32:
	print('肥胖')
else:
	print('严重肥胖')


input()