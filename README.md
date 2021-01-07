# SpringMVC学习记录

*参考视频*

[【狂神说Java】SpringMVC最新教程IDEA版通俗易懂](https://www.bilibili.com/video/BV1aE41167Tu)

## 资源

[SpringMVC官方文档](https://docs.spring.io/spring-framework/docs/current/reference/html/web.html)

以及B站视频下方**评论区**

[Maven仓库官网](https://mvnrepository.com/)

[BootStrap v3.4.1 国内CDN](https://www.bootcdn.cn/twitter-bootstrap/3.4.1/)

[BootStrap3中文文档](https://v3.bootcss.com/css/)

[jQuery v3.5.1 国内CDN](https://www.bootcdn.cn/jquery/3.5.1/)

## 项目环境

- Java : 1.8 (要求)
- IDEA : 2020.3 Ultimate (建议)
- Maven : Bundled (3.6.3)
- Spring组件 : 5.x.x (建议)
- BootStrap : 3.4.x
- jQuery : 3.5.x
- Tomcat : 9.0.x

## 注意事项

Tomcat版本与对应的`servlet-api`和`jsp-api`参考[Apache Tomcat Versions](http://tomcat.apache.org/whichversion.html)

这两项依赖的scope都建议设置为`provided`，因为Tomcat自身会提供对应的jar包

这个系列视频个人觉得质量不如前两者（MyBatis3和Spring5），有非常多的不必要错误，但是有用的内容质量还是很不错

系列视频的`P17-P23`实现了SSM整合的项目，个人建议先把后面的Ajax与拦截器都学了再去整合

本项目与狂神的模块数量有所不同，我保留下了个人认为价值较高的模块

此项目要求对前端有**一点点**了解，包括HTML、CSS、JavaScript

**重要**

默认`main`分支不包含SSM整合项目

SSM整合项目位于分支[ssm](https://github.com/ouyangjunfei/SpringMVCStudy/tree/ssm)