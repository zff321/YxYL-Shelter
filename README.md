# YxYL-Shelter

#### 技术选型

1. web层
   - servlet：前端控制器
   - html：视图展示
   - BeanUtils：数据封装
   - Jackson：json数据序列化工具

2. service层

3. Dao层
   1. JDBCTemplate：mysqlJDBC连接器工具
   2. Mysql：数据库
   3. Druid：数据库连接池

#### 数据库设计

##### 用户表：

| 序号 | 名称       | 别名       | 类型    | 长度（长度） |
| ---- | ---------- | ---------- | ------- | ------------ |
| 1    | u_id       | 用户ID     | int     | 4            |
| 2    | u_username | 用户名     | VARCHAR | 20           |
| 3    | u_password | 用户密码   | VARCHAR | 20           |
| 4    | u_gender   | 用户性别   | VARCHAR | 5            |
| 5    | u_address  | 用户地址   | VARCAHR | 20           |
| 6    | u_birth    | 用户生日   | DATE    | ?            |
| 7    | u_tele     | 用户手机号 | VARVHAR | 10           |
| 8    | u_email    | 用户邮箱   | VARCHAR | 20           |
|      |            |            |         |              |

##### 管理员表：

| 序号 | 名称       | 别名       | 类型    | 长度（字符） |
| ---- | ---------- | ---------- | ------- | ------------ |
| 1    | r_id       | 管理员ID   | int     | 4            |
| 2    | r_username | 管理员名称 | VARCAHR | 20           |
| 3    | r_password | 管理员密码 | VARCAHR | 20           |

