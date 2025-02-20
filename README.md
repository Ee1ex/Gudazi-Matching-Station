# 咕搭子 - 伙伴匹配系统后端

别名：咕搭子

## 第一部分：

1.掌握做项目的流程

### 设计

拓展功能：

标签拓展： 工作/学习 哪个大学  学习专业  兴趣爱好  游戏/段位 

上传头像

功能：ban掉IP

小程序上线

线上聊天:私聊+群聊  好友感觉没必要，留lxfs即可，可改成帖子留言

### 前端

**初始化**

Vue+Vite脚手架+组件库vant【贴纸站】

可以通过配置和下载很快建起一个页面

全量引入：本地方便点，上线的时候再选择引入

**Vue+脚手架是什么？**

layout：基础复用/通用布局

template

script

style

const

**router**？：路由模式

alert

slot插槽

高亮active最后去哪了？

### 后端

#### **库表设计**

大项目开发中减少关联查询，主要影响查询性能，入100个用户标签查询

tinyint   0,1

datetime

bigint?

SQL书+**tag表索引unique操作**

#### **初始化**

导用户中心后端的包

删idea包

重新导入maven项目

pomXML里全局搜索backend改成自己项目名 ctrl+shift+F / R

改一下SQL书和README项目描述

#### 开发后端接口

**根据标签搜索用户**

like模糊查询  and / or

SQL查询（拼接语句） / 内存查询

开发两种查询+测试【直接在用户中心里测】

右键tag=mybatisX插件  根据数据库表生成SQL代码 java 模型 xml 代码

加注解让他知道是逻辑删除

![img](https://c14izkkyo2r.feishu.cn/space/api/box/stream/download/asynccode/?code=OGUzYzM4MzE3N2MxMGUzODc4MzBmOTMzYzczNDFkMTVfaE42YmUwUmRpTFpFTnBJeTFOVWpIRDIxM216STdwNVVfVG9rZW46WE1tNmI5UTBmb3g4UDZ4QkRTc2M4TWw4bmpkXzE3MTM2MDY2MTI6MTcxMzYxMDIxMl9WNA)

2:09:00对文件包的删改操作

测试：

判断是否为空，是空的话抛个异常返回，否则的话创建查询QueryWrapper

拼接and查询：遍历taglist，每次循环的时候拼接like

直接查询 clt+enter拿到返回值 

脱敏？ 对于每个user的处理，getsafetyuser   

alt+enter 这里用到this::    接收的参数正好是每次遍历的对象

![img](https://c14izkkyo2r.feishu.cn/space/api/box/stream/download/asynccode/?code=ZjA4NjViYmM1MjdmMjM0NzdiZDFhYjBjMmUwODA3YmVfNW5mQjVCbGYzRzFRVDFJeElBNkU5cTk4VVBoaTZKZGdfVG9rZW46TnRzaWJONVhOb3JYejV4b2RIdWNTN1JablMwXzE3MTM2MDY2MTI6MTcxMzYxMDIxMl9WNA)

shift ctrl -  【减号】 把所有方法折叠

gson反序列化 找官网配置进xml再写

## 第二部分

### **2.Java 8 特性**

stream/parallelstream 流式处理

parallelstream如果查询太复杂，会把线程池占满影响效率

[java基础总结(七十)--Java8中的parallelStream的坑-CSDN博客](https://blog.csdn.net/lsx2017/article/details/105749984/)

optional 可选类 减少复杂度

### 前端整合路由 router

Vue-Router: https://router.vuejs.org/zh/guide/#html，直接看官方文档引入。

Vue-Router 其实就是帮助你根据不同的 ur 来展示不同的页面(组件)，不用自己写 if/else。

路由配置影响整个项日，所以建议单独用 config 目录、**单独的配置文件**去集中定义和管理。

有些组件库可能自带了和 Vue-Router 的整合，所以尽量先看组件文档、省去自己写的时间

<router-view/> 根据不同页面展示不同内容

to="/"   根页面

后续主要是根据页面需要的功能，参考其他软件和网页的外观来选择合适配件【vant3】，然后debug。

从54:00开始，略过前端

### 扩展小知识|网页内容抓取流程

## 第三部分 1:19:00

### 3.接口文档 Swagger + Knife4j

**什么是接口文档?**

谁用接口文档？

**为什么需要接口文档？**

如何做接口文档?

#### 使用Swagger  → Knife4j

导入配置和接口即可

[1.6 快速开始 | knife4j](https://doc.xiaominfo.com/v2/documentation/get_start.html)

### 4.网页内容抓取

```Bash
curl "https://api.zsxq.com/v2/hashtags/15522121841242/topics?count=20" ^
  -X "OPTIONS" ^
  -H "accept: */*" ^
  -H "accept-language: zh-CN,zh;q=0.9,en;q=0.8,en-GB;q=0.7,en-US;q=0.6" ^
  -H "access-control-request-headers: x-request-id,x-signature,x-timestamp,x-version" ^
  -H "access-control-request-method: GET" ^
  -H "cache-control: no-cache" ^
  -H "origin: https://wx.zsxq.com" ^
  -H "pragma: no-cache" ^
  -H "referer: https://wx.zsxq.com/" ^
  -H "sec-fetch-dest: empty" ^
  -H "sec-fetch-mode: cors" ^
  -H "sec-fetch-site: same-site" ^
  -H "user-agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/123.0.0.0 Safari/537.36 Edg/123.0.0.0" ^
  -H "x-forwarded-for: 4.2.2.2" &
  
curl "https://api.zsxq.com/v2/hashtags/15522121841242/topics?count=20" ^
  -H "accept: application/json, text/plain, */*" ^
  -H "accept-language: zh-CN,zh;q=0.9,en;q=0.8,en-GB;q=0.7,en-US;q=0.6" ^
  -H "cache-control: no-cache" ^
  -H ^"cookie: " ^
  -H "origin: https://wx.zsxq.com" ^
  -H "pragma: no-cache" ^
  -H "referer: https://wx.zsxq.com/" ^
  
  -H ^"sec-ch-ua: ^\^"Microsoft Edge^\^";v=^\^"123^\^", ^\^"Not:A-Brand^\^";v=^\^"8^\^", ^\^"Chromium^\^";v=^\^"123^\^"^" ^
  -H "sec-ch-ua-mobile: ?0" ^
  -H ^"sec-ch-ua-platform: ^\^"Windows^\^"^" ^
  -H "sec-fetch-dest: empty" ^
  -H "sec-fetch-mode: cors" ^
  -H "sec-fetch-site: same-site" ^
  -H "user-agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/123.0.0.0 Safari/537.36 Edg/123.0.0.0" ^
  -H "x-forwarded-for: 4.2.2.2" ^
  -H "x-request-id: 1ae679dde-3963-ac3c-d84b-94984de522c" ^
  -H "x-signature: baa3722d4f7d3ed2af32ab6afff4dca2bca8f3db" ^
  -H "x-timestamp: 1713514507" ^
  -H "x-version: 2.54.0" &
```

![img](https://c14izkkyo2r.feishu.cn/space/api/box/stream/download/asynccode/?code=OGE1ZWMwMzc4OTY2ZjliODI0MTE2YmYzY2VhZDJhZWNfUW1odE5MenJ2cURhbGt6R1JuemcyWkp4cExmM2NxMFZfVG9rZW46SllqTWIwNzQ3b05Jd2x4N2w5ZGNWdGZtbnZkXzE3MTM2MDY2MTI6MTcxMzYxMDIxMl9WNA)

过滤重复名字  filter

这一段代码具体不太懂 主要是在alt+enter那

## 第四部分

### 用户搜索页

**前端**

<meta name="referrer" content="no-referrer" />

防盗链，写于index.html

**后端**

**前后端联调**

Axios

@CrossOrigin 注解   有关跨域 后端跨域可以用于多个前端，不用反复写，后端也安全一些

### Session共享+**5.****分布式****登录**

安装redie

springboot redis依赖

yml改store-type: *redis*

## 第五部分

### 用户登录功能

**前端**

### **个人信息修改功能**

**前端**

**后端**

### 基础功能丨前后端联调

6.大数据量导入

7.并发编程

## 第六部分

## 第七部分

8.Redis 缓存及预热

## 第八部分

9.定时任务

## 第九部分

10.分布式锁

11.幕等性

## 第十部分

## 第十一部分

## 第十二部分

12.数据匹配算法

## 第十三上+下集

## 第十四集

13.免备案上线项目
