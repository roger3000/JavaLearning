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