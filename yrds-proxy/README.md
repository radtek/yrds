---
swagger: "2.0"
info:
  description: "IRIS后台接入API"
  version: "1.0.0"
  title: "IRIS API接口"
  termsOfService: "no terms-of-service-url"
  license:
    name: "The Apache License, Version 2.0"
    url: "http://www.apache.org/licenses/LICENSE-2.0.html"
host: "localhost:8085"
basePath: "/yrds-proxy"
tags:
- name: "IRIS"
  description: "IRIS采集和比对API接口"
- name: "IRIS.Dev"
  description: "IRIS设备管理API接口"
consumes:
- "application/json"
- "multipart/form-data"
paths:
  /api/irisCollect:
    post:
      tags:
      - "IRIS"
      summary: "IRIS采集接口"
      description: "IRIS采集接口"
      operationId: "irisCollect"
      consumes:
      - "application/json"
      - "multipart/form-data"
      produces:
      - "application/json"
      parameters:
      - in: "body"
        name: "req"
        description: "req"
        required: true
        schema:
          $ref: "#/definitions/IrisCollect"
      responses:
        200:
          description: "OK"
          schema:
            $ref: "#/definitions/IrisRegistRsp"
  /api/irisDevHeartbeat:
    post:
      tags:
      - "IRIS.Dev"
      summary: "IRIS设备心跳接口"
      description: "IRIS设备心跳接口"
      operationId: "irisDevHeartbeat"
      consumes:
      - "application/json"
      - "multipart/form-data"
      produces:
      - "application/json"
      parameters:
      - in: "body"
        name: "req"
        description: "req"
        required: true
        schema:
          $ref: "#/definitions/IrisDeviceHeartbeat"
      responses:
        200:
          description: "OK"
          schema:
            $ref: "#/definitions/IrisDeviceHeartbeatRsp"
  /api/irisDevImportBatch:
    post:
      tags:
      - "IRIS.Dev"
      summary: "IRIS设备信息批量导入接口"
      description: "IRIS设备信息批量导入接口"
      operationId: "irisDevImportBatch"
      consumes:
      - "application/json"
      - "multipart/form-data"
      produces:
      - "application/json"
      parameters:
      - in: "body"
        name: "req"
        description: "req"
        required: true
        schema:
          $ref: "#/definitions/IrisDeviceImport"
      responses:
        200:
          description: "OK"
          schema:
            $ref: "#/definitions/IrisDeviceImportRsp"
  /api/irisDevLogin:
    post:
      tags:
      - "IRIS.Dev"
      summary: "IRIS设备登录接口"
      description: "IRIS设备登录接口"
      operationId: "irisDevLogin"
      consumes:
      - "application/json"
      - "multipart/form-data"
      produces:
      - "application/json"
      parameters:
      - in: "body"
        name: "req"
        description: "req"
        required: true
        schema:
          $ref: "#/definitions/IrisDeviceLogin"
      responses:
        200:
          description: "OK"
          schema:
            $ref: "#/definitions/IrisDeviceLogin"
  /api/irisDevRegist:
    post:
      tags:
      - "IRIS.Dev"
      summary: "IRIS设备注册接口"
      description: "IRIS设备注册接口"
      operationId: "irisDevRegist"
      consumes:
      - "application/json"
      - "multipart/form-data"
      produces:
      - "application/json"
      parameters:
      - in: "body"
        name: "req"
        description: "req"
        required: true
        schema:
          $ref: "#/definitions/IrisDeviceRegReq"
      responses:
        200:
          description: "OK"
          schema:
            $ref: "#/definitions/IrisDeviceRegRsp"
  /api/irisMatch:
    post:
      tags:
      - "IRIS"
      summary: "IRIS比对接口"
      description: "IRIS比对接口"
      operationId: "irisMatch"
      consumes:
      - "application/json"
      - "multipart/form-data"
      produces:
      - "application/json"
      parameters:
      - in: "body"
        name: "req"
        description: "req"
        required: true
        schema:
          $ref: "#/definitions/IrisMatch"
      responses:
        200:
          description: "OK"
          schema:
            $ref: "#/definitions/IrisRegistRsp"
definitions:
  IrisCollect:
    type: "object"
    required:
    - "accessToken"
    - "deviceId"
    - "featureBase64"
    - "featureLen"
    - "imgDataBase64"
    - "imgLen"
    properties:
      accessToken:
        type: "string"
        example: "00000000000000000000000000000000"
        description: "许可token，后续操作接口需带上它，才能调用成功"
      algName:
        type: "string"
        example: "alg.1"
        description: "虹膜算法名称"
      algVersion:
        type: "string"
        example: "1.0.0"
        description: "虹膜算法版本号"
      deviceId:
        type: "string"
        example: "0000012345678901"
        description: "采集设备编号，高5字节填充为0，低11字节为厂商制定的采集设备生产序列号"
      featureBase64:
        type: "string"
        description: "虹膜特征模板,base64编码"
      featureLen:
        type: "integer"
        format: "int32"
        example: 512
        description: "虹膜特征模板长度，字节单位"
      imgDataBase64:
        type: "string"
        description: "图片数据,base64编码"
      imgLen:
        type: "integer"
        format: "int32"
        example: 2048
        description: "虹膜图像数据长度，字节为单位"
      sign:
        type: "string"
        description: "接口请求签名"
      staffId:
        type: "string"
        example: "0001"
        description: "员工编号"
      staffName:
        type: "string"
        example: "张三"
        description: "员工姓名"
      tranCode:
        type: "string"
        description: "交易代码"
      tranSeqId:
        type: "string"
        description: "请求流水号"
      trantime:
        type: "string"
        example: "20180306165501"
        description: "交易时间，格式:yyyymmddHHMMSS"
      version:
        type: "string"
        description: "接口版本 "
    description: "虹膜采集请求"
  IrisDeviceBO:
    type: "object"
    required:
    - "descriptor"
    - "deviceId"
    - "productType"
    properties:
      descriptor:
        type: "string"
        example: "xxx虹膜采集设备"
        description: "虹膜采集设备描述"
      devImgDepth:
        type: "integer"
        format: "int32"
        example: 24
        description: "像素位深度"
      devImgFormat:
        type: "string"
        example: "png"
        description: "设备返回图像格式"
      devImgHeight:
        type: "integer"
        format: "int32"
        example: 150
        description: "设备采集图像高度"
      devImgWidth:
        type: "integer"
        format: "int32"
        example: 200
        description: "设备采集图像宽度"
      deviceFlag:
        type: "integer"
        format: "int32"
        example: 1
        description: "采集设备注册标识"
      deviceId:
        type: "string"
        example: "0000012345678901"
        description: "采集设备编号，高5字节填充为0，低11字节为厂商制定的采集设备生产序列号"
      firmwareVersion:
        type: "string"
        example: "1.0.0"
        description: "设备固件版本"
      productType:
        type: "string"
        example: "IRIS-1-001"
        description: "虹膜采集设备型号"
      registerFlag:
        type: "integer"
        format: "int32"
        example: 1
        description: "采集设备注册标识"
      sensorType:
        type: "integer"
        format: "int32"
        example: 1
        description: "采集设备传感器类型标识"
      spetrum:
        type: "integer"
        format: "int32"
        example: 0
        description: "光谱"
      vendorId:
        type: "string"
        example: "000000112233445566778899"
        description: "采集设备供方标识。高6字节填充为0，低18字节为厂商社会信用代码"
  IrisDeviceHeartbeat:
    type: "object"
    required:
    - "accessToken"
    - "deviceId"
    properties:
      accessToken:
        type: "string"
        example: "00000000000000000000000000000000"
        description: "许可token，后续操作接口需带上它，才能调用成功"
      deviceId:
        type: "string"
        example: "0000012345678901"
        description: "采集设备编号，高5字节填充为0，低11字节为厂商制定的采集设备生产序列号"
      sign:
        type: "string"
        description: "接口请求签名"
      tranCode:
        type: "string"
        description: "交易代码"
      tranSeqId:
        type: "string"
        description: "请求流水号"
      trantime:
        type: "string"
        example: "20180306165501"
        description: "交易时间，格式:yyyymmddHHMMSS"
      version:
        type: "string"
        description: "接口版本 "
    description: "虹膜设备状态维持心跳请求"
  IrisDeviceHeartbeatRsp:
    type: "object"
    required:
    - "accessToken"
    - "deviceId"
    properties:
      accessToken:
        type: "string"
        example: "00000000000000000000000000000000"
        description: "许可token，后续操作接口需带上它，才能调用成功"
      data:
        type: "object"
        description: "数据对象"
        properties: {}
      deviceId:
        type: "string"
        example: "0000012345678901"
        description: "采集设备编号，高5字节填充为0，低11字节为厂商制定的采集设备生产序列号"
      errorTip:
        type: "string"
        example: "交易成功"
        description: "错误提示"
      resTranSeqId:
        type: "string"
        description: "返回流水号"
      respCode:
        type: "string"
        example: "S0000000"
        description: "响应码"
      respMsg:
        type: "string"
        example: "成功"
        description: "响应描述"
      version:
        type: "string"
        description: "返回接口版本 "
    description: "虹膜设备状态维持心跳响应"
  IrisDeviceImport:
    type: "object"
    required:
    - "devices"
    properties:
      devices:
        type: "array"
        description: "采集设备信息列表"
        items:
          $ref: "#/definitions/IrisDeviceBO"
      sign:
        type: "string"
        description: "接口请求签名"
      tranCode:
        type: "string"
        description: "交易代码"
      tranSeqId:
        type: "string"
        description: "请求流水号"
      trantime:
        type: "string"
        example: "20180306165501"
        description: "交易时间，格式:yyyymmddHHMMSS"
      version:
        type: "string"
        description: "接口版本 "
    description: "虹膜设备批量导入请求"
  IrisDeviceImportRsp:
    type: "object"
    properties:
      data:
        type: "object"
        description: "数据对象"
        properties: {}
      errorTip:
        type: "string"
        example: "交易成功"
        description: "错误提示"
      resTranSeqId:
        type: "string"
        description: "返回流水号"
      respCode:
        type: "string"
        example: "S0000000"
        description: "响应码"
      respMsg:
        type: "string"
        example: "成功"
        description: "响应描述"
      version:
        type: "string"
        description: "返回接口版本 "
    description: "虹膜设备批量导入响应"
  IrisDeviceLogin:
    type: "object"
    required:
    - "accessToken"
    - "deviceId"
    properties:
      accessToken:
        type: "string"
        example: "00000000000000000000000000000000"
        description: "许可token，后续操作接口需带上它，才能调用成功"
      data:
        type: "object"
        description: "数据对象"
        properties: {}
      deviceId:
        type: "string"
        example: "0000012345678901"
        description: "采集设备编号，高5字节填充为0，低11字节为厂商制定的采集设备生产序列号"
      errorTip:
        type: "string"
        example: "交易成功"
        description: "错误提示"
      resTranSeqId:
        type: "string"
        description: "返回流水号"
      respCode:
        type: "string"
        example: "S0000000"
        description: "响应码"
      respMsg:
        type: "string"
        example: "成功"
        description: "响应描述"
      sign:
        type: "string"
        description: "接口请求签名"
      tranCode:
        type: "string"
        description: "交易代码"
      tranSeqId:
        type: "string"
        description: "请求流水号"
      trantime:
        type: "string"
        example: "20180306165501"
        description: "交易时间，格式:yyyymmddHHMMSS"
      version:
        type: "string"
        description: "接口版本 "
    description: "虹膜设备登录请求"
  IrisDeviceRegReq:
    type: "object"
    required:
    - "descriptor"
    - "deviceId"
    - "productType"
    properties:
      descriptor:
        type: "string"
        example: "xxx虹膜采集设备"
        description: "虹膜采集设备描述"
      devImgDepth:
        type: "integer"
        format: "int32"
        example: 24
        description: "像素位深度"
      devImgFormat:
        type: "string"
        example: "png"
        description: "设备返回图像格式"
      devImgHeight:
        type: "integer"
        format: "int32"
        example: 150
        description: "设备采集图像高度"
      devImgWidth:
        type: "integer"
        format: "int32"
        example: 200
        description: "设备采集图像宽度"
      deviceFlag:
        type: "integer"
        format: "int32"
        example: 1
        description: "采集设备注册标识"
      deviceId:
        type: "string"
        example: "0000012345678901"
        description: "采集设备编号，高5字节填充为0，低11字节为厂商制定的采集设备生产序列号"
      firmwareVersion:
        type: "string"
        example: "1.0.0"
        description: "设备固件版本"
      productType:
        type: "string"
        example: "IRIS-1-001"
        description: "虹膜采集设备型号"
      registerFlag:
        type: "integer"
        format: "int32"
        example: 1
        description: "采集设备注册标识"
      sensorType:
        type: "integer"
        format: "int32"
        example: 1
        description: "采集设备传感器类型标识"
      sign:
        type: "string"
        description: "接口请求签名"
      spetrum:
        type: "integer"
        format: "int32"
        example: 0
        description: "光谱"
      tranCode:
        type: "string"
        description: "交易代码"
      tranSeqId:
        type: "string"
        description: "请求流水号"
      trantime:
        type: "string"
        example: "20180306165501"
        description: "交易时间，格式:yyyymmddHHMMSS"
      vendorId:
        type: "string"
        example: "000000112233445566778899"
        description: "采集设备供方标识。高6字节填充为0，低18字节为厂商社会信用代码"
      version:
        type: "string"
        description: "接口版本 "
    description: "虹膜设备登记请求Bean"
  IrisDeviceRegRsp:
    type: "object"
    properties:
      data:
        type: "object"
        description: "数据对象"
        properties: {}
      errorTip:
        type: "string"
        example: "交易成功"
        description: "错误提示"
      resTranSeqId:
        type: "string"
        description: "返回流水号"
      respCode:
        type: "string"
        example: "S0000000"
        description: "响应码"
      respMsg:
        type: "string"
        example: "成功"
        description: "响应描述"
      version:
        type: "string"
        description: "返回接口版本 "
    description: "虹膜设备登记响应Bean"
  IrisMatch:
    type: "object"
    required:
    - "accessToken"
    - "deviceId"
    - "featureBase64"
    - "featureLen"
    - "imgDataBase64"
    - "imgLen"
    properties:
      accessToken:
        type: "string"
        example: "00000000000000000000000000000000"
        description: "许可token，后续操作接口需带上它，才能调用成功"
      algName:
        type: "string"
        example: "alg.1"
        description: "虹膜算法名称"
      algVersion:
        type: "string"
        example: "1.0.0"
        description: "虹膜算法版本号"
      deviceId:
        type: "string"
        example: "0000012345678901"
        description: "采集设备编号，高5字节填充为0，低11字节为厂商制定的采集设备生产序列号"
      featureBase64:
        type: "string"
        description: "虹膜特征模板,base64编码"
      featureLen:
        type: "integer"
        format: "int32"
        example: 512
        description: "虹膜特征模板长度，字节单位"
      imgDataBase64:
        type: "string"
        description: "图片数据,base64编码"
      imgLen:
        type: "integer"
        format: "int32"
        example: 2048
        description: "虹膜图像数据长度，字节为单位"
      sign:
        type: "string"
        description: "接口请求签名"
      tranCode:
        type: "string"
        description: "交易代码"
      tranSeqId:
        type: "string"
        description: "请求流水号"
      trantime:
        type: "string"
        example: "20180306165501"
        description: "交易时间，格式:yyyymmddHHMMSS"
      version:
        type: "string"
        description: "接口版本 "
    description: "虹膜比对请求"
  IrisRegistRsp:
    type: "object"
    properties:
      data:
        type: "object"
        description: "数据对象"
        properties: {}
      errorTip:
        type: "string"
        example: "交易成功"
        description: "错误提示"
      resTranSeqId:
        type: "string"
        description: "返回流水号"
      respCode:
        type: "string"
        example: "S0000000"
        description: "响应码"
      respMsg:
        type: "string"
        example: "成功"
        description: "响应描述"
      staffId:
        type: "string"
        example: "0001"
        description: "员工编号"
      staffName:
        type: "string"
        example: "张三"
        description: "员工姓名"
      version:
        type: "string"
        description: "返回接口版本 "
    description: "虹膜登记响应"
---

# yrds-proxy项目

## 1. 概述

​	本项目是yrds iris业务前置子系统。其主要功能是数据接收和协议转换，也就说接收从客户端发送过来的数据，并将收到的数据转换位业务处理子系统所需的请求Bean。

​	计划支持的网络通讯协议主要有两种方式：HTTP和socket长连接方式。

​	业务数据内容格式采用json格式打包。

## 2. 接口定义

### 2.1 HTTP JSON接口



### 2.2 Socket接口

待添加