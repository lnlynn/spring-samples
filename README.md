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
```

则表明安装并配置成功。

因为网络问题导致Gradle下载依赖很慢，需要配置国内镜像，在{GRADLE_HOME}/init.d/目录下新建`init.gradle`文件，内容如下：

```json
allprojects {
    repositories {
        mavenLocal()
        maven { name "Alibaba" ; url "https://maven.aliyun.com/repository/public" }
        mavenCentral()
    }

    buildscript { 
        repositories { 
            maven { name "Alibaba" ; url 'https://maven.aliyun.com/repository/public' }
            maven { name "M2" ; url 'https://plugins.gradle.org/m2/' }
        }
    }
}
```

也可以针对单个项目进行配置，在`build.gradle`中添加：

```json
buildscript {
    repositories {
        maven{ url 'http://maven.aliyun.com/nexus/content/groups/public/' }
        maven{ url 'http://maven.aliyun.com/nexus/content/repositories/jcenter'}
    }
}
allprojects {
    repositories {
        mavenCentral()
        maven { url 'http://maven.aliyun.com/nexus/content/groups/public/' }
    }
}
```

### Gradle Wrapper

如果不想单独安装Gradle，可以试试gradle wrapper。这是一个脚本工具，可以自动安装Gradle，省去了许多繁琐的操作。IDEA默认就会使用gradle wrapper来创建项目，无需额外安装gradle。

gradle wrapper可以自定义下载的gradle的版本，团队协作中，简单设置即可统一团队的构建工具版本。在gradle-wrapper.properties文件中即可实现相关配置。

使用了gradle wrapper的工程目录结构如下：

```java
├── build.gradle
├── gradle    
│   └── wrapper
│       ├── gradle-wrapper.jar
│       └── gradle-wrapper.properties
├── gradlew
├── gradlew.bat
├── settings.gradle
└── src
    ├── main
    │   ├── java  
    │   │   └── demo
    │   │       └── Application.java
    │   └── resources
    └── test      
        ├── java
        │   └── demo
        │       └── ApplicationTest.java
        └── resources
```

### 依赖管理

gradle的依赖管理很简单，只需要一行：

```groovy
dependencies {
    implementation 'com.google.guava:guava:26.0-jre' 
    testImplementation 'junit:junit:4.12' 
}
```

gradle的作用域有以下几种：

> `compileOnly` — for dependencies that are necessary to compile your production code but shouldn’t be part of the runtime classpath
>
> `implementation` (supersedes `compile`) — used for compilation and runtime
>
> `runtimeOnly` (supersedes `runtime`) — only used at runtime, not for compilation
>
> `testCompileOnly` — same as `compileOnly` except it’s for the tests
>
> `testImplementation` — test equivalent of `implementation`
>
> `testRuntimeOnly` — test equivalent of `runtimeOnly`

- implementation，默认的scope。implementation的作用域会让依赖在编译和运行时均包含在内，但是不会暴露在类库使用者的编译时。举例，如果我们的类库包含了gson，那么其他人使用我们的类库时，编译时不会出现gson的依赖。
- api，和implementation类似，都是编译和运行时都可见的依赖。但是api允许我们将自己类库的依赖暴露给我们类库的使用者。
- compileOnly和runtimeOnly，这两种顾名思义，一种只在编译时可见，一种只在运行时可见。而runtimeOnly和Maven的provided比较接近。
- testImplementation，这种依赖在测试编译时和运行时可见，类似于Maven的test作用域。
- testCompileOnly和testRuntimeOnly，这两种类似于compileOnly和runtimeOnly，但是作用于测试编译时和运行时。

通过简短精悍的依赖配置和多种多样的作用与选择，Gradle可以为我们提供比Maven更加优秀的依赖管理功能。