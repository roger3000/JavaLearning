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

v8
添加登陆功能
在webapps/myweb下添加又给登陆页面login.html
在ClientHandler中添加用于处理登陆功能的业务逻辑

登陆流程
1 浏览器访问登陆页面
2 页面中输入登陆信息
3 ClientHandler更具request中的内容判断是否为请求登陆业务
若是,则开始登陆处理

v9 
代码重构:
将clientHandler功能进行拆分, 明确每个类的功能
ClientHandler 用于处理客户端请求, 然后响应客户端
但是不负责处理具体的业务, 相当于是一个分发请求控制角色
将具体的业务功能定义为一个功能类, 由ClientHandler统一调用
负责处理注册业务功能的类: RegServlet
负责处理登陆功能的类:LoginServlet