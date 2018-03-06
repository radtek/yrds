# yrds-facade模块

## 1. 概述

​	本模块用于定义公共的常量和枚举类，以及yrds-service模块对外提供的服务定义接口和DTO。

## 2. 接口定义

- ### IrisDeviceService—虹膜设备管理服务

  1. 函数regist：虹膜设备注册
  2. 函数login：虹膜设备登录
  3. 函数heartbeat：虹膜设备状态维持心跳
  4. 函数importBatch：批量导入虹膜设备信息


- ### IrisService—虹膜的采集和匹配服务

  1. 函数collect：虹膜采集
  2. 函数match：虹膜的匹配

## 3. 接口Bean定义

1. IrisDeviceReg：虹膜设备登记请求bean
2. IrisDeviceRegRsp：虹膜设备登记响应bean
3. IrisDeviceLogin：虹膜设备登录请求bean
4. IrisDeviceLoginRsp：虹膜设备登录响应bean
5. IrisDeviceHeartbeat：虹膜设备状态维持心跳请求bean
6. IrisDeviceHeartbeatRsp：虹膜设备状态维持心跳响应bean
7. IrisDeviceImport：虹膜设备批量导入请求bean
8. IrisDeviceImportRsp：虹膜设备批量导入响应bean
9. IrisDeviceBO：虹膜设备信息对象
10. IrisCollect：虹膜采集请求bean
11. IrisCollectRsp：虹膜采集响应bean
12. IrisMatch：虹膜比对请求bean
13. IrisMatchRsp：虹膜比对响应bean

## 4. 依赖jar包

    <dependency>
    	<groupId>com.kivi</groupId>
       	<artifactId>framework-common</artifactId>
       	<version>1.0.0</version>
    </dependency>