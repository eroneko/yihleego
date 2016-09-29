#encoding:UTF-8
import urllib
import urllib.request
 

 
request=urllib.request.Request('http://yihleego.com/')
try:  
    urllib.request.urlopen(request)  
  
except urllib.error.URLError as e:  
  
    print (e.code) 

input()