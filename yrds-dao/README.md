# yrds-dao模块

## 1. 概述

​	本模块主要用于yrds虹膜后台服务相关的数据库表的相关操作，包含相关表的model类、mapper类和dao类。

## 2. 相关数据库表格

- iris_device：虹膜设备信息表。
- iris_feature：员工虹膜信息表。
- iris_feature_temp：未识别虹膜信息表。
- attendances：员工考勤记录表。
- ktf_login_log：虹膜设备登录记录表，KTF框架的基础表。
- ktf_operation_log：系统业务操作表，KTF框架的基础表。

## 3. 依赖jar包

​	本模块依赖kivi-framework的以下jar包

       	<dependency>
       		<groupId>com.kivi</groupId>
       		<artifactId>framework-db</artifactId>
       		<version>1.0.0</version>
       	</dependency>