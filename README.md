# Gradle

Gradle是一个基于Apache Ant和Apache Maven概念的项目自动化构建工具。它使用一种基于Groovy的特定领域语言来声明项目设置，而不是传统的XML。Gradle就是工程的管理，帮我们做了依赖、打包、部署、发布、各种渠道的差异管理等工作。

Gradle的优势：

- 一款最新的，功能最强大的构建工具，用它逼格更高
- 使用程序代替传统的XML配置，项目构建更灵活
- 丰富的第三方插件，让你随心所欲使用
- Maven、Ant能做的，Gradle都能做，但是Gradle能做的，Maven、Ant不一定能做

### 安装与配置

Gradle官方网站：[https://gradle.org](https://gradle.org)

Gradle下载地址：[https://services.gradle.org/distributions/](https://services.gradle.org/distributions/)

下载完成后将其解压至一个位置，然后配置相关环境变量，配置过程与安装Maven大同小异。配置完成后，打开终端，输入`gradle -v`:

```groovy
------------------------------------------------------------
Gradle 6.3
------------------------------------------------------------

Build time:   2020-03-24 19:52:07 UTC
Revision:     bacd40b727b0130eeac8855ae3f9fd9a0b207c60

Kotlin:       1.3.70
Groovy:       2.5.10
Ant:          Apache Ant(TM) version 1.10.7 compiled on September 1 2019
JVM:          1.8.0_211 (Oracle Corporation 25.211-b12)
OS:           Mac OS X 10.15.6 x86_64
```

则表明安装并配置成功。

