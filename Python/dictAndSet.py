names=['Michael','Bob','Tracy']
scores=[95,75,85]

d={'Michael':95,'Bob':75,'Tracy':85}
print(d['Michael'])

d['Adam']=67
print(d['Adam'])




d['Jack']=80
print(d['Jack'])
d['Jack'] = 1
print(d['Jack'])

d.pop('Jack')

print(d)



s=set([1,2,3])
print(s)

s.add(4)
print(s)

s.add(4)
print(s)

s.remove(3)
print(s)


s1=set([1,2,3])
s2=set([2,3,4])
print(s1&s2)
print(s1|s2)




a=['c','b','a']
a.sort()
print(a)

a='abc'

print(a.replace('a','A'))


input()