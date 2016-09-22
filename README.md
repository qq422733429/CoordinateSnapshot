# CoordinateSnapshot
Thoughtworks秋招内推作业题

### travis-ci
[![travis-ci](https://api.travis-ci.org/qq422733429/CoordinateSnapshot.svg)](https://travis-ci.org/qq422733429/CoordinateSnapshot-pos)

### BUILD

#### Generate IntelliJ IDEA project
`./gradlew cleanIdea idea`

Open the `thought-pos.ipr` using IntelliJ

#### Run clean and build tasks
`./gradlew clean build`

### Git提交规范：

comment here[提交作者] 

**Example:** `modifier readme.md[王鹏鉴]`

###项目结构
#####整个项目共分为三个接口和实现，分别是：
    * 输入接口： public HashMap<String,Snapshot> handleInputString(String input);
        * 逐行读取输入的字符串，并将其每一部分构成一个Snapshot,并将其放入以快照ID为key值的hashmap中，如果有格式错误或者数据错误，都会抛出对应的异常。
    * 输出接口： public String handleInputString(HashMap<String,Snapshot> dataMap,String foundId);
        * 从输入得到的hashmap中，查找foundId条Snapshot，并将其按照输出格式输出，如果有异常，会直接返回错误信息数组。
    * 对外提供服务的接口： public String getSnapShot(String historyData, String id);
        * 调用输入接口和输出接口，从用户传入的historyData中找到指定的ID，并以字符串返回。
###测试
#####测试分为单元测试和集成测试。
#####单元测试
    * 输入单元测试
        * 1、示例输入
        * 2、更多或更少条Snapshot测试
        * 3、时间格式错误测试，报异常：throw new IllegalArgumentException("Invalid format.");
        * 4、位置数据错误测试，报异常：throw new IllegalArgumentException("Conflict found at "+id);
        * 5、空输入测试
    * 输出单元测试（首先mock的一个正确输入的HashMap dateMap，然后从中测试各种输出情况）
        * 1、分别对第一条、第二条、第三条Snapshot进行测试
        * 2、错误或空dataMap测试
        * 3、错误id测试
#####集成测试
    * 1、正确示例测试
    * 2、格式错误示例测试
    * 3、数据错误示例测试