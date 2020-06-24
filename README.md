# DataBase2020

Homework for database course of THSS. Developer: 
武笑石（Xiaoshi Wu）， 黎思宇，陈语凝

[TOC]

## 前言
DataBase2020（数据库原理课程大作业）是基于ThssDB开发的一款简易的现代关系型数据库应用，由Java实现，能够支持较多常用的sql语句，可用于开发、测试、部署数据库应用；本文档将从环境配置、运行指导、主要功能的用法介绍等角度引导用户上手使用DataBase2020。

## 1.运行与使用指南

### 环境配置
DataBase2020兼容Java8或更新的版本，需要的支持及可用版本范围为：
* Java 8及以上
* Maven 3.6.1及以上
* RPC thrift 0.13.0及以上

### 运行方法

因配置文件已一并上交，故可直接build后运行。
DataBase2020的主类
* 服务端：```cn.edu.thssdb.server.ThssDB```
* 客户端：```cn.edu.thssdb.client.Client```

若maven配置仍有问题，则请在在根目录中执行```mvn clean package```后rebuild整个项目。
注意：在您查看代码时，thrift文件一旦被修改，也需要重新在根目录执行```mvn clean package```后rebuild项目。

### 客户端功能指令语句
以下语句可以在客户端接收指令语句时随时执行，且不与后端进行通信：

* 获取帮助：```help;```
* 显示当前时间：```show time;```
* 退出应用：```quit;```


### 执行单元测试
DataBase2020的测试类较多，未进行打包处理，请在IDEA等工具中配置运行。
## 2.支持的SQL语言

### 基础语句

#### CREATE_DATABASE
```create database .*;```
创建一个数据库，后缀为名称；

#### DROP_DATABASE 
```drop database .*;```
删除名为指定名称的数据库；

#### USE_DATABASE
```use .*;```;
将当前浏览与处理的数据库改为指定名称的数据库；

#### CREATE_TABLE
```create table .*;```
在当前数据库中新建一个指定名称的表，应指定其每一列的列名、类型、是否为主键、是否可为空；
注意：支持的类型有：int、long、float、double、string；

#### DROP_TABLE
```drop table .*;```
删除名为指定名称的表；

#### INSERT
```insert into .* values(.*);```
向指定名称的表插入数据，需要注意参数的数目、名称对应正确；

#### DELETE
```delete from .* where .*;```
根据后面子句的条件/全部删除指定名称的表的数据（where子句支持and/or连接）；

#### UPDATE
```update .* set .*;```
向指定名称的表更新数据；

#### SELECT
```select .*;```
根据给定条件在指定名称的表中查找数据并以表头与数据的形式发送到客户端；理论上支持无限多表的join操作；

### 事务与恢复相关语句

#### START_TRANSACTION
```begin transaction```
开启一个新的事务；

#### COMMIT
```commit```
提交该事务；

#### ROLLBACK
```rollback```
回滚该事务。

## 3.进阶操作

可通过修改utils.Global.java的常量进行功能的调整，如页式存储每页的存储量等。

