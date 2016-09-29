#-*-coding:utf-8-*- 
import urllib.request  
import socket  
import re  
import sys  
import os  







def start():   #程序运行入口
    weburl = "http://huaban.com/search/?q=%E6%96%B0%E5%9E%A3%E7%BB%93%E8%A1%A3"
    webheader = {
        'Connection': 'Keep-Alive',
        'Accept': 'text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8',
        'Accept-Encoding': 'gzip, deflate, sdch',
        'Accept-Language': 'zh-CN,zh;q=0.8,en;q=0.6',
        'User-Agent': 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/53.0.2785.116 Safari/537.36',
        'Host': 'huaban.com',
        'DNT': '1'
        }


    request = urllib.request.Request(url=weburl)
    response = urllib.request.urlopen(request)
    content=response.read().decode('utf-8')
    #content=response.read().decode('gbk', 'ignore').encode('utf-8')
    #response.read()
    #
    pattern = re.compile('<div data-id.*?<a href="(.*?)".*?<img src="(.*?)"',re.S)

    items = re.findall(pattern,content)
    for item in items:
        print (item[1])


start()





