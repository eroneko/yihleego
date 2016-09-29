#-*-coding:utf-8-*- 
array=[36,5,-20,9,-130]
print(sorted(array))#对list进行排序
print(sorted(array, key=abs))#按绝对值大小排序



nameList=['Bob','about','Zoo','Credit']
print(sorted(nameList))#对字符串排序，是按照ASCII的大小比较

print(sorted(nameList, key=str.lower))#给sorted传入key函数，即可实现忽略大小写的排序：

print(sorted(nameList, key=str.lower, reverse=True))#要进行反向排序，不必改动key函数，可以传入第三个参数reverse=True：

L = [('Bob', 75), ('Adam', 92), ('Bart', 66), ('Lisa', 88)]

def by_name(t):
	return t[0].lower()
	pass

L2=sorted(L,key=by_name)
print(L2)


def by_score(t):
	return t[1]
	pass

L3=sorted(L,key=by_score,reverse=True)
print(L3)

input()