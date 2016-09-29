#-*-coding:utf-8-*- #编码声明，不要忘记！
import urllib.request
import urllib.error
import re

user_agent = 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/53.0.2785.116 Safari/537.36'  
headers={'User-Agent' : user_agent }

sUrl = "http://user.qzone.qq.com/1106968896?ADUIN=491934639&ADSESSION=1475026720&ADTAG=CLIENT.QQ.5461_FriendInfo_PersonalInfo.0&ADPUBNO=26553&ptlang=2052"

request = urllib.request.Request(sUrl,headers=headers)
response = urllib.request.urlopen(request)

sPage = response.read()
unicodePage = sPage.decode("utf-8")
print(unicodePage)

