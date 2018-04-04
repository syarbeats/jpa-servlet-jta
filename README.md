"# jpa-servlet-jta" 

This project is a example how to use JPA using Datasource JTA in servlet.

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

### Prerequisites

1. Mysql or other RDBMS Server
2. Apache Tomcat

Step
```
1. Create datasource at Context.xml in Folder [ApacheTomcat]/Conf
   Copy the following datasource definition below to context.xml
   <Resource
      name="jdbc/zeus"
      auth="Container"
      type="javax.sql.DataSource"
      maxActive="100"
      maxIdle="30"
      maxWait="10000"
      driverClassName="com.mysql.jdbc.Driver"
      url="jdbc:mysql://localhost:3306/jpa_three"
      username="root"
      password=""
    />
2. Run Apache Tomcat
3. git clone https://github.com/syarbeats/jpa-servlet-jta.git
4. Import to Eclipse Project
5. Clean & Build
6. Deploy to Apache Tomcat
```


```
URL:
http://localhost:8080/jpa-cmp-servlet/jpa_cmp
```



## Authors

* **SyarifHidayat** - *Initial work* (https://github.com/syarbeats)


