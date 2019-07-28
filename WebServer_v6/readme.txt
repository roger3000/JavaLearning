v2:
将客户端发送过来的请求封装到一个HttpRequest对象中
而不在ClientHandler中直接处理

v3:
在项目中添加webapps, 并在里面添加一个子目录 
myweb
然后在其中存放我们定义的页面index.html
在ClientHandler中添加响应代码,将myweb中的index.html页面发送回客户端
客户端测试路径 localhost:8086/index.html

v4:
将clienthandler中直接响应客户端的内容 修改成为专门定义表示
HTTP响应的类:HttpResponse.
重构代码

v5:
完成httprequest中对消息头的解析
1.	在httprequest中使用map创建一个属性header
	用于保存所有客户端发送过来的消息头
2.	添加方法parseHeaders, 用于解析所有的消息头

v6
完成注册功能

通过该功能,理解客户端使用get请求如何传递数据到服务端.服务端如何解析这些数据

GET请求是地址栏请求,格式:
protocol://host:port/requestStr?queryStr

而参数的格式为
name=value