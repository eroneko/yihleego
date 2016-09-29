#-*-coding:utf-8-*- 
import urllib.request  
import socket  
import re  
import sys  
import os  
import tool
import time

#抓取MM
class Spider:
 
    #页面初始化
    def __init__(self):
        self.siteURL = "http://huaban.com/search/?q=%E6%96%B0%E5%9E%A3%E7%BB%93%E8%A1%A3"
        self.tool = tool.Tool()
 
    #获取索引页面的内容
    def getPage(self,pageIndex):
        url = self.siteURL + "&page=" + str(pageIndex)
        print('getPage:',url)
        request = urllib.request.Request(url)
        response =urllib.request.urlopen(request)
        return response.read().decode('utf-8')

    #获取索引界面所有MM的信息，list格式
    def getContents(self,pageIndex):
        print('getContents:',pageIndex)
        page = self.getPage(pageIndex)
        pattern = re.compile('<div data-id.*?<a href="/(.*?)/".*?<img src="//(.*?)"',re.S)
        items = re.findall(pattern,page)
        contents = []
        for item in items:
            contents.append([item[0],item[1]])
            print(item[0],item[1])
        return contents


    #获取MM个人详情页面
    def getDetailPage(self,infoURL):
        response = urllib.request.urlopen(infoURL)
        return response.read().decode('utf-8')
 
    #获取个人文字简介
    def getBrief(self,page):
        pattern = re.compile('<div class="mm-aixiu-content".*?>(.*?)<!--',re.S)
        result = re.search(pattern,page)
        return self.tool.replace(result.group(1))
 
    #获取页面所有图片
    def getAllImg(self,page):
        pattern = re.compile('<div class="mm-aixiu-content".*?>(.*?)<!--',re.S)
        #个人信息页面所有代码
        content = re.search(pattern,page)
        #从代码中提取图片
        patternImg = re.compile('<img.*?src="(.*?)"',re.S)
        images = re.findall(patternImg,content.group(1))
        return images
 
 
    #保存多张写真图片
    def saveImgs(self,images,name):
        number = 1
        print ("发现",name,"共有",len(images),"张照片")
        for imageURL in images:
            splitPath = imageURL.split('.')
            fTail = splitPath.pop()
            if len(fTail) > 3:
                fTail = "jpg"
            fileName = name + "/" + str(number) + "." + fTail
            self.saveImg(imageURL,fileName)
            number += 1
 
    # 保存头像
    def saveIcon(self,iconURL,name):
        splitPath = iconURL.split('.')
        fTail = splitPath.pop()
        fileName = name + "/icon." + fTail
        self.saveImg(iconURL,fileName)
 
    #保存个人简介
    def saveBrief(self,content,name):
        fileName = name + "/" + name + ".txt"
        f = open(fileName,"w+")
        print("正在偷偷保存她的个人信息为",fileName)
        f.write(content.encode('utf-8'))
 
 
    #传入图片地址，文件名，保存单张图片
    def saveImg(self,imageURL,fileName):
        u = urllib.request.urlopen('http://'+imageURL)
        data = u.read()       

        f = open('D://gakki//'+fileName+str(time.time())+'.jpg', 'wb')
        f.write(data)
        print ("正在保存:",fileName)
        f.close()
 
    #创建新目录
    def mkdir(self,path):
        path = path.strip()
        # 判断路径是否存在
        # 存在     True
        # 不存在   False
        isExists=os.path.exists(path)
        # 判断结果
        if not isExists:
            # 如果不存在则创建目录
            print ("偷偷新建了名字叫做",path,'的文件夹')
            # 创建目录操作函数
            os.makedirs(path)
            return True
        else:
            # 如果目录存在则不创建，并提示目录已存在
            print ("名为",path,'的文件夹已经创建成功')
            return False
 
    #将一页淘宝MM的信息保存起来
    def savePageInfo(self,pageIndex):
        #获取第一页淘宝MM列表
        print('savePageInfo:',pageIndex)
        contents = self.getContents(pageIndex)
        for item in contents:
        
            #item[0]个人详情URL,item[1]头像URL,item[2]姓名,item[3]年龄,item[4]居住地           
            #print ("img src:",item[1])
            #个人详情页面的URL
            #detailURL = item[1]
            #得到个人详情页面代码
            #detailPage = self.getDetailPage(detailURL)
            #获取个人简介
            #brief = self.getBrief(detailPage)
            #获取所有图片列表
            #images = self.getAllImg(detailPage)
            #self.mkdir(item[2])
            #保存个人简介
            #self.saveBrief(brief,item[2])
            #保存头像
            #self.saveIcon(item[1],item[2])
            #保存图片
            print(item[0],'img savig!',item[1])
            self.saveImg(item[1],item[0])
            #urllib.request.urlretrieve(item[1], destFile(item[1]+'.jpg'))
 
    #传入起止页码，获取MM图片
    def savePagesInfo(self,start,end):
        for i in range(start,end+1):
            print ("spidering:",i,"th  page")
            self.savePageInfo(i)
 
 
#传入起止页码即可，在此传入了2,10,表示抓取第2到10页的MM
spider = Spider()
spider.savePagesInfo(1,100)