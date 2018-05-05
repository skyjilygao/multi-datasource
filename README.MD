##SpringBoot 2.0.1 多数据源配置

springboot2.0以后多数据源配置与之前的有所改变，默认使用hikari，而不是tomcat了。

配置url时，只有一个数据源时可以写成url，程序会自动转换。但是多数据源时需要写成jdbc-url，否则报错出现jdbcurl is required 字样。

需要注意以下几点：
1.  url必须写成jdbc-url
2.  主datasoure，sqlsessionfactory 必须加上@primary，否则提示无法配置，找到多个datasource或sessionfactory。非主数据源绝对不能用@primary
3.  @MapperScan配置：主数据源后面可以不加sqlSessionFactoryRef参数，但是非主数据源必须加sqlSessionFactoryRef参数，否则提示bind statement错误，就是mapper中方法没有对应的mybatis sql映射

