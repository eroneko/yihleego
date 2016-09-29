#-*-coding:utf-8-*- 
import urllib.request
import urllib.error
import re



page = 1
url = 'http://www.qiushibaike.com/hot/page/' + str(page)
user_agent = 'Mozilla/4.0 (compatible; MSIE 5.5; Windows NT)'
headers = { 'User-Agent' : user_agent }

try:
    request = urllib.request.Request(url,headers=headers)
    response = urllib.request.urlopen(request)
    content = response.read().decode('utf-8')

    pattern = re.compile('<div class="author clearfix">.*?href.*?<img src.*?title=.*?<h2>(.*?)</h2>.*?<div class="content">(.*?)</div>.*?<i class="number">(.*?)</i>',re.S)
    items = re.findall(pattern, content)
    for item in items:
    	print(item[0],item[1],item[2])
   
    #pattern = re.compile('<div class="author clearfix">.*?href.*?<img src.*?title=.*?<h2>(.*?)</h2>.*?<div class="content">(.*?)</div>.*?<i class="number">(.*?)</i>',re.S)
    #items = re.findall(pattern,content)
    #for item in items:
        #haveImg = re.search("img",item[3])
        #if not haveImg:
            #print(item[0],item[1],item[2],item[4])


except urllib.error.URLError as e:
    if hasattr(e,"code"):
        print (e.code)
    if hasattr(e,"reason"):
        print (e.reason)



#request = urllib.request.Request(url)
#response = urllib.request.urlopen(request)
#print(response.read())
input()