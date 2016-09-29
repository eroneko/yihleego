import urllib.request
import urllib.error
import re

values = {}
values['username'] = "15057616120"
values['password'] = "yihleego1996"

data = urllib.parse.urlencode(values)
url = 'http://www.zhihu.com/question/20899988'


user_agent = 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/53.0.2785.116 Safari/537.36'  
headers = { 'User-Agent' : user_agent , 'Referer':'http://www.zhihu.com/articles'}  

geturl = url + "?"+data

request = urllib.request.Request(geturl,headers=headers)
response = urllib.request.urlopen(request)
print(response.read().decode('gb2312','ignore').encode('utf-8'))