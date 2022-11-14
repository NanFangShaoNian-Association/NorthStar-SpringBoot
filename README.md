# NorthStar-SpringBoot
这是北极星宠的后端仓库

# 北极星宠基础后端环境
## 快速启动指南
### 环境配置
1. 更改application.yml中的环境为prod
2. 将application-prod.yml中的数据库账号密码配置进去
3. 配置Redis地址，默认本地无密码
3. 导入sql/pet_platform.sql文件
4. 启动项目

### swagger-ui
http://localhost:10001/swagger-ui/index.html

### 其他说明
1. 基础接口都已经写得差不多了，但其中有些细节可能需要在开发中做临时变更，考虑到这一点，因此需要后端开发者学会如何使用Swagger写api文档，以及学会使用Apifox导入swagger文档。
2. token拦截暂时不做的很完善，就搭个基础框架，请求头中的token值为token
3. 不需要token验证的接口方法，需要在该方法上加上NoNeedLogin注解，如登陆方法，注册方法等。