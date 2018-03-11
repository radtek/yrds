# yrds-proxy项目

## 1. 概述

本项目是yrds iris业务前置子系统，其主要功能是数据接收和协议转换，也就说接收从客户端发过来的数据，并将收到的数据转换位业务处理子系统的请求Bean。

计划支持的网络讯协议主要有两种方式：HTTP和socket长连接方式。

​        业务数据内容格式采用json格式打包

​	业务数据内容格式采用json格式打包。
## 2. 接口定义

### 2.1 HTTP JSON接口

接口服务地址： *https://ip:8085/yrds-proxy*

| 名称                     | 接口                                                         | HTTP 请求                        |      |
| ------------------------ | ------------------------------------------------------------ | -------------------------------- | ---- |
| IRIS采集接口             | [**irisCollect**](docs/IRISApi.md#irisCollect)               | **POST** /api/irisCollect        |      |
| IRIS比对接口             | [**irisMatch**](docs/IRISApi.md#irisMatch)                   | **POST** /api/irisMatch          |      |
| IRIS设备心跳接口         | [**irisDevHeartbeat**](docs/IRISDevApi.md#irisDevHeartbeat)  | **POST** /api/irisDevHeartbeat   |      |
| IRIS设备信息批量导入接口 | [**irisDevImportBatch**](docs/IRISDevApi.md#irisDevImportBatch) | **POST** /api/irisDevImportBatch |      |
| IRIS设备登录接口         | [**irisDevLogin**](docs/IRISDevApi.md#irisDevLogin)          | **POST** /api/irisDevLogin       |      |
| IRIS设备注册接口         | [**irisDevRegist**](docs/IRISDevApi.md#irisDevRegist)        | **POST** /api/irisDevRegist      |      |

### 2.2 Socket接口

待添加