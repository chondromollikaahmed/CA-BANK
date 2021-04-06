# CA Bank
---
#### _A Banking Management System (Java Core Project)_
---
[![CA|Author](https://i.ibb.co/k1QJ7Dx/ca-only.png)](https://web.facebook.com/chondromollika.ahmed.9)

---

CA Bank is a  is a Java core (Swing ) Based Project Application Which is user friendly , can be used in the bank as well as for client use . It is done as a Software Project Of CSE Department , Ahsanullah University Of Science And Technology (Aust), Course No-  CSE 2100. 

Used Libraries-

- Java Swing 
- MySQL Database
- Java Socket 

## Features
---
- Three Types Of Users 
- Client Can Easily Add Or Edit Their Information
- Can Change Their Picture
- Used Friendly Interface
- User can Add Money From Both Card And Check
- Officers Can Check The Transaction And Transaction Details Of Users 
- OTP verification For Each And Every New Account 
- User Can Easily Recover Password By Verifying Their Email
- Real Time Chat Interface (Currenty Only On Localhost)
- etc.

---
> The goal Of CA Bank To make is Usable
> for every user .One Application Diffrent User,
>Different interfaces.




-----



## Installation

CA Bank requires [JDK](https://docs.oracle.com/javase/8/docs/technotes/guides/install/install_overview.html) 1.8+ to run.

Install The Java Properly Add The path To The Runtime environment. You Can Use Netbeans Or Ecciplse Or Any Other Java IDE . Can also be run from console.

```sh
setx path "%path%;c:\directoryPath"
```

You can Directly Run The Jar file from the dist folder Of this project.

```sh
java -jar "Destination Folder/CA Bank/dist/CA Bank.jar"
```

## Used Library



| Library | Jar |
| ------ | ------ |
| commons-lang 3 | [.jar](https://commons.apache.org/proper/commons-lang/download_lang.cgi) |
| Apache POI |[Documentation](https://poi.apache.org/download.html)  |
| Java Mail API | [javax.mail.jar](https://mvnrepository.com/artifact/javax.mail/mail/1.4.7) |
| JTatoo|  avaiable in the lib folder|
| CA Client | avaiable in the lib folder |
| CA Server | avaiable in the lib folder|

## Important Notes:
---
MySQL Is Used As The Database .First Import The Database To phpmyadmin . You can directly use the given ca_bank.sql file without importing. 
Change The line 27 of DatabaseConnect.java as following-
```java
con=DriverManager.getConnection("jdbc:mysql://Destination/CA BANK/ca_bank.sql")
```

If you can upload this ca_bank.sql to the server and want to use it just change the code as following

```java
con=DriverManager.getConnection("jdbc:mysql://serverlink",username,password)
```

To Use The Chat Feature First Login As Manager .
```CA
username="ahmed"
password="chondromollika"
```
Start The Chat Server (will be run as localhost)
You can check if the server has strated or not by running the following in cmd-
```shell
netstat -a | grep 5000
```

Then Find Out The Ip Of Your Local Area Connection .
```shell
ipconfig
ipconfig |grep LAN
ipconfig | grep Wi-Fi
```
or you can use-
```
127.0.0.1
```
Change The Code Of 

| Class | Line |
| ----- | -----|
|Manager.java|1756|
|Officer.java|2500|
|Client.java|  2271   |

Like Following-
```java
Method.connect(profile_pic,"CA_Admin","YourIP/127.0.0.1");
```
```java
Method.connect(profile_pic,OfficerVar.getOfficer_no(),"YourIP/127.0.0.1");
```

```
  Method.connect(profile_pic,ClientVar.getUsername(),"YourIP/127.0.0.1");
  ```
## License
---

[LICENSE.md]()

**Can Be Used As Project Of University Level**

> @author : Chondromollika Ahmed
>Department Of CSE
>Ahsanullah University Of Science And Technoloy
>chondromollikaahmed@gmail.com ,
>@2021 All Right Reserved.

[//]: # (©Chondromollika Ahmed)
