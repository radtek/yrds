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
        description: "虹膜算法版本�?"
      deviceId:
        type: "string"
        example: "0000012345678901"
        description: "采集设备编号，高5字节填充�?0，低11字节为厂商制定的采集设备生产序列�?"
      featureBase64:
        type: "string"
        description: "虹膜特征模板,base64编码"
      featureLen:
        type: "integer"
        format: "int32"
        example: 512
        description: "虹膜特征模板长度，字节单�?"
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
        description: "请求流水�?"
      trantime:
        type: "string"
        example: "20180306165501"
        description: "交易时间，格�?:yyyymmddHHMMSS"
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
        description: "像素位深�?"
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
        description: "采集设备编号，高5字节填充�?0，低11字节为厂商制定的采集设备生产序列�?"
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
        description: "采集设备传感器类型标�?"
      spetrum:
        type: "integer"
        format: "int32"
        example: 0
        description: "光谱"
      vendorId:
        type: "string"
        example: "000000112233445566778899"
        description: "采集设备供方标识。高6字节填充�?0，低18字节为厂商社会信用代�?"
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
        description: "采集设备编号，高5字节填充�?0，低11字节为厂商制定的采集设备生产序列�?"
      sign:
        type: "string"
        description: "接口请求签名"
      tranCode:
        type: "string"
        description: "交易代码"
      tranSeqId:
        type: "string"
        description: "请求流水�?"
      trantime:
        type: "string"
        example: "20180306165501"
        description: "交易时间，格�?:yyyymmddHHMMSS"
      version:
        type: "string"
        description: "接口版本 "
    description: "虹膜设备状�?�维持心跳请�?"
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
        description: "采集设备编号，高5字节填充�?0，低11字节为厂商制定的采集设备生产序列�?"
      errorTip:
        type: "string"
        example: "交易成功"
        description: "错误提示"
      resTranSeqId:
        type: "string"
        description: "返回流水�?"
      respCode:
        type: "string"
        example: "S0000000"
        description: "响应�?"
      respMsg:
        type: "string"
        example: "成功"
        description: "响应描述"
      version:
        type: "string"
        description: "返回接口版本 "
    description: "虹膜设备状�?�维持心跳响�?"
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
        description: "请求流水�?"
      trantime:
        type: "string"
        example: "20180306165501"
        description: "交易时间，格�?:yyyymmddHHMMSS"
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
        description: "返回流水�?"
      respCode:
        type: "string"
        example: "S0000000"
        description: "响应�?"
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
        description: "采集设备编号，高5字节填充�?0，低11字节为厂商制定的采集设备生产序列�?"
      errorTip:
        type: "string"
        example: "交易成功"
        description: "错误提示"
      resTranSeqId:
        type: "string"
        description: "返回流水�?"
      respCode:
        type: "string"
        example: "S0000000"
        description: "响应�?"
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
        description: "请求流水�?"
      trantime:
        type: "string"
        example: "20180306165501"
        description: "交易时间，格�?:yyyymmddHHMMSS"
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
        description: "像素位深�?"
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
        description: "采集设备编号，高5字节填充�?0，低11字节为厂商制定的采集设备生产序列�?"
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
        description: "采集设备传感器类型标�?"
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
        description: "请求流水�?"
      trantime:
        type: "string"
        example: "20180306165501"
        description: "交易时间，格�?:yyyymmddHHMMSS"
      vendorId:
        type: "string"
        example: "000000112233445566778899"
        description: "采集设备供方标识。高6字节填充�?0，低18字节为厂商社会信用代�?"
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
        description: "返回流水�?"
      respCode:
        type: "string"
        example: "S0000000"
        description: "响应�?"
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
        description: "虹膜算法版本�?"
      deviceId:
        type: "string"
        example: "0000012345678901"
        description: "采集设备编号，高5字节填充�?0，低11字节为厂商制定的采集设备生产序列�?"
      featureBase64:
        type: "string"
        description: "虹膜特征模板,base64编码"
      featureLen:
        type: "integer"
        format: "int32"
        example: 512
        description: "虹膜特征模板长度，字节单�?"
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
        description: "请求流水�?"
      trantime:
        type: "string"
        example: "20180306165501"
        description: "交易时间，格�?:yyyymmddHHMMSS"
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
        description: "返回流水�?"
      respCode:
        type: "string"
        example: "S0000000"
        description: "响应�?"
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

�?	本项目是yrds iris业务前置子系统�?�其主要功能是数据接收和协议转换，也就说接收从客户端发�?�过来的数据，并将收到的数据转换位业务处理子系统�?�?的请求Bean�?

�?	计划支持的网络�?�讯协议主要有两种方式：HTTP和socket长连接方式�??

�?	业务数据内容格式采用json格式打包�?

## 2. 接口定义

### 2.1 HTTP JSON接口

```html
<h1>IRIS API接口</h1>
    <div class="app-desc">IRIS后台接入API</div>
    <div class="app-desc">More information: <a href="https://helloreverb.com">https://helloreverb.com</a></div>
    <div class="app-desc">Contact Info: <a href="hello@helloreverb.com">hello@helloreverb.com</a></div>
    <div class="app-desc">Version: 1.0.0</div>
    <div class="app-desc">BasePath:/yrds-proxy</div>
    <div class="license-info">The Apache License, Version 2.0</div>
    <div class="license-url">http://www.apache.org/licenses/LICENSE-2.0.html</div>
  <h2>Access</h2>

  <h2><a name="__Methods">Methods</a></h2>
  [ Jump to <a href="#__Models">Models</a> ]

  <h2>Table of Contents </h2>
  <div class="method-summary"></div>
  <ol>
  <li><a href="#irisCollect"><code><span class="http-method">post</span> /api/irisCollect</code></a></li>
  <li><a href="#irisMatch"><code><span class="http-method">post</span> /api/irisMatch</code></a></li>
  <li><a href="#irisDevHeartbeat"><code><span class="http-method">post</span> /api/irisDevHeartbeat</code></a></li>
  <li><a href="#irisDevImportBatch"><code><span class="http-method">post</span> /api/irisDevImportBatch</code></a></li>
  <li><a href="#irisDevLogin"><code><span class="http-method">post</span> /api/irisDevLogin</code></a></li>
  <li><a href="#irisDevRegist"><code><span class="http-method">post</span> /api/irisDevRegist</code></a></li>
  </ol>

  <div class="method"><a name="irisCollect"/>
    <div class="method-path">
    <a class="up" href="#__Methods">Up</a>
    <pre class="post"><code class="huge"><span class="http-method">post</span> /api/irisCollect</code></pre></div>
    <div class="method-summary">IRIS采集接口 (<span class="nickname">irisCollect</span>)</div>
    <div class="method-notes">IRIS采集接口</div>


    <h3 class="field-label">Consumes</h3>
    This API call consumes the following media types via the <span class="heaader">Content-Type</span> request header:
    <ul>
      <li><code>application/json</code></li>
      <li><code>multipart/form-data</code></li>
    </ul>

    <h3 class="field-label">Request body</h3>
    <div class="field-items">
      <div class="param">req (required)</div>

      <div class="param-desc"><span class="param-type">Body Parameter</span> &mdash; req </div>
    </div>  <!-- field-items -->




    <h3 class="field-label">Return type</h3>
    <div class="return-type">
      <a href="#IrisRegistRsp">IrisRegistRsp</a>
      
    </div>

    <!--Todo: process Response Object and its headers, schema, examples -->

    <h3 class="field-label">Example data</h3>
    <div class="example-data-content-type">Content-Type: application/json</div>
    <pre class="example"><code>{

  "data" : "{}",

  "errorTip" : "交易成功",

  "staffName" : "张三",

  "respMsg" : "成功",

  "version" : "aeiou",

  "resTranSeqId" : "aeiou",

  "respCode" : "S0000000",

  "staffId" : "0001"

}</code></pre>

    <h3 class="field-label">Produces</h3>
    This API call produces the following media types according to the <span class="header">Accept</span> request header;
    the media type will be conveyed by the <span class="heaader">Content-Type</span> response header.
    <ul>
      <li><code>application/json</code></li>
    </ul>

    <h3 class="field-label">Responses</h3>
    <h4 class="field-label">200</h4>
    OK
        <a href="#IrisRegistRsp">IrisRegistRsp</a>
  </div> <!-- method -->
  <hr/>
  <div class="method"><a name="irisMatch"/>
    <div class="method-path">
    <a class="up" href="#__Methods">Up</a>
    <pre class="post"><code class="huge"><span class="http-method">post</span> /api/irisMatch</code></pre></div>
    <div class="method-summary">IRIS比对接口 (<span class="nickname">irisMatch</span>)</div>
    <div class="method-notes">IRIS比对接口</div>


    <h3 class="field-label">Consumes</h3>
    This API call consumes the following media types via the <span class="heaader">Content-Type</span> request header:
    <ul>
      <li><code>application/json</code></li>
      <li><code>multipart/form-data</code></li>
    </ul>

    <h3 class="field-label">Request body</h3>
    <div class="field-items">
      <div class="param">req (required)</div>

      <div class="param-desc"><span class="param-type">Body Parameter</span> &mdash; req </div>
    </div>  <!-- field-items -->




    <h3 class="field-label">Return type</h3>
    <div class="return-type">
      <a href="#IrisRegistRsp">IrisRegistRsp</a>
      
    </div>

    <!--Todo: process Response Object and its headers, schema, examples -->

    <h3 class="field-label">Example data</h3>
    <div class="example-data-content-type">Content-Type: application/json</div>
    <pre class="example"><code>{

  "data" : "{}",

  "errorTip" : "交易成功",

  "staffName" : "张三",

  "respMsg" : "成功",

  "version" : "aeiou",

  "resTranSeqId" : "aeiou",

  "respCode" : "S0000000",

  "staffId" : "0001"

}</code></pre>

    <h3 class="field-label">Produces</h3>
    This API call produces the following media types according to the <span class="header">Accept</span> request header;
    the media type will be conveyed by the <span class="heaader">Content-Type</span> response header.
    <ul>
      <li><code>application/json</code></li>
    </ul>

    <h3 class="field-label">Responses</h3>
    <h4 class="field-label">200</h4>
    OK
        <a href="#IrisRegistRsp">IrisRegistRsp</a>
  </div> <!-- method -->
  <hr/>
  <div class="method"><a name="irisDevHeartbeat"/>
    <div class="method-path">
    <a class="up" href="#__Methods">Up</a>
    <pre class="post"><code class="huge"><span class="http-method">post</span> /api/irisDevHeartbeat</code></pre></div>
    <div class="method-summary">IRIS设备心跳接口 (<span class="nickname">irisDevHeartbeat</span>)</div>
    <div class="method-notes">IRIS设备心跳接口</div>


    <h3 class="field-label">Consumes</h3>
    This API call consumes the following media types via the <span class="heaader">Content-Type</span> request header:
    <ul>
      <li><code>application/json</code></li>
      <li><code>multipart/form-data</code></li>
    </ul>

    <h3 class="field-label">Request body</h3>
    <div class="field-items">
      <div class="param">req (required)</div>

      <div class="param-desc"><span class="param-type">Body Parameter</span> &mdash; req </div>
    </div>  <!-- field-items -->




    <h3 class="field-label">Return type</h3>
    <div class="return-type">
      <a href="#IrisDeviceHeartbeatRsp">IrisDeviceHeartbeatRsp</a>
      
    </div>

    <!--Todo: process Response Object and its headers, schema, examples -->

    <h3 class="field-label">Example data</h3>
    <div class="example-data-content-type">Content-Type: application/json</div>
    <pre class="example"><code>{

  "data" : "{}",

  "errorTip" : "交易成功",

  "respMsg" : "成功",

  "accessToken" : "00000000000000000000000000000000",

  "deviceId" : "0000012345678901",

  "version" : "aeiou",

  "resTranSeqId" : "aeiou",

  "respCode" : "S0000000"

}</code></pre>

    <h3 class="field-label">Produces</h3>
    This API call produces the following media types according to the <span class="header">Accept</span> request header;
    the media type will be conveyed by the <span class="heaader">Content-Type</span> response header.
    <ul>
      <li><code>application/json</code></li>
    </ul>

    <h3 class="field-label">Responses</h3>
    <h4 class="field-label">200</h4>
    OK
        <a href="#IrisDeviceHeartbeatRsp">IrisDeviceHeartbeatRsp</a>
  </div> <!-- method -->
  <hr/>
  <div class="method"><a name="irisDevImportBatch"/>
    <div class="method-path">
    <a class="up" href="#__Methods">Up</a>
    <pre class="post"><code class="huge"><span class="http-method">post</span> /api/irisDevImportBatch</code></pre></div>
    <div class="method-summary">IRIS设备信息批量导入接口 (<span class="nickname">irisDevImportBatch</span>)</div>
    <div class="method-notes">IRIS设备信息批量导入接口</div>


    <h3 class="field-label">Consumes</h3>
    This API call consumes the following media types via the <span class="heaader">Content-Type</span> request header:
    <ul>
      <li><code>application/json</code></li>
      <li><code>multipart/form-data</code></li>
    </ul>

    <h3 class="field-label">Request body</h3>
    <div class="field-items">
      <div class="param">req (required)</div>

      <div class="param-desc"><span class="param-type">Body Parameter</span> &mdash; req </div>
    </div>  <!-- field-items -->




    <h3 class="field-label">Return type</h3>
    <div class="return-type">
      <a href="#IrisDeviceImportRsp">IrisDeviceImportRsp</a>
      
    </div>

    <!--Todo: process Response Object and its headers, schema, examples -->

    <h3 class="field-label">Example data</h3>
    <div class="example-data-content-type">Content-Type: application/json</div>
    <pre class="example"><code>{

  "data" : "{}",

  "errorTip" : "交易成功",

  "respMsg" : "成功",

  "version" : "aeiou",

  "resTranSeqId" : "aeiou",

  "respCode" : "S0000000"

}</code></pre>

    <h3 class="field-label">Produces</h3>
    This API call produces the following media types according to the <span class="header">Accept</span> request header;
    the media type will be conveyed by the <span class="heaader">Content-Type</span> response header.
    <ul>
      <li><code>application/json</code></li>
    </ul>

    <h3 class="field-label">Responses</h3>
    <h4 class="field-label">200</h4>
    OK
        <a href="#IrisDeviceImportRsp">IrisDeviceImportRsp</a>
  </div> <!-- method -->
  <hr/>
  <div class="method"><a name="irisDevLogin"/>
    <div class="method-path">
    <a class="up" href="#__Methods">Up</a>
    <pre class="post"><code class="huge"><span class="http-method">post</span> /api/irisDevLogin</code></pre></div>
    <div class="method-summary">IRIS设备登录接口 (<span class="nickname">irisDevLogin</span>)</div>
    <div class="method-notes">IRIS设备登录接口</div>


    <h3 class="field-label">Consumes</h3>
    This API call consumes the following media types via the <span class="heaader">Content-Type</span> request header:
    <ul>
      <li><code>application/json</code></li>
      <li><code>multipart/form-data</code></li>
    </ul>

    <h3 class="field-label">Request body</h3>
    <div class="field-items">
      <div class="param">req (required)</div>

      <div class="param-desc"><span class="param-type">Body Parameter</span> &mdash; req </div>
    </div>  <!-- field-items -->




    <h3 class="field-label">Return type</h3>
    <div class="return-type">
      <a href="#IrisDeviceLogin">IrisDeviceLogin</a>
      
    </div>

    <!--Todo: process Response Object and its headers, schema, examples -->

    <h3 class="field-label">Example data</h3>
    <div class="example-data-content-type">Content-Type: application/json</div>
    <pre class="example"><code>{

  "trantime" : "20180306165501",

  "data" : "{}",

  "tranSeqId" : "aeiou",

  "errorTip" : "交易成功",

  "sign" : "aeiou",

  "respMsg" : "成功",

  "tranCode" : "aeiou",

  "accessToken" : "00000000000000000000000000000000",

  "deviceId" : "0000012345678901",

  "version" : "aeiou",

  "resTranSeqId" : "aeiou",

  "respCode" : "S0000000"

}</code></pre>

    <h3 class="field-label">Produces</h3>
    This API call produces the following media types according to the <span class="header">Accept</span> request header;
    the media type will be conveyed by the <span class="heaader">Content-Type</span> response header.
    <ul>
      <li><code>application/json</code></li>
    </ul>

    <h3 class="field-label">Responses</h3>
    <h4 class="field-label">200</h4>
    OK
        <a href="#IrisDeviceLogin">IrisDeviceLogin</a>
  </div> <!-- method -->
  <hr/>
  <div class="method"><a name="irisDevRegist"/>
    <div class="method-path">
    <a class="up" href="#__Methods">Up</a>
    <pre class="post"><code class="huge"><span class="http-method">post</span> /api/irisDevRegist</code></pre></div>
    <div class="method-summary">IRIS设备注册接口 (<span class="nickname">irisDevRegist</span>)</div>
    <div class="method-notes">IRIS设备注册接口</div>


    <h3 class="field-label">Consumes</h3>
    This API call consumes the following media types via the <span class="heaader">Content-Type</span> request header:
    <ul>
      <li><code>application/json</code></li>
      <li><code>multipart/form-data</code></li>
    </ul>

    <h3 class="field-label">Request body</h3>
    <div class="field-items">
      <div class="param">req (required)</div>

      <div class="param-desc"><span class="param-type">Body Parameter</span> &mdash; req </div>
    </div>  <!-- field-items -->




    <h3 class="field-label">Return type</h3>
    <div class="return-type">
      <a href="#IrisDeviceRegRsp">IrisDeviceRegRsp</a>
      
    </div>

    <!--Todo: process Response Object and its headers, schema, examples -->

    <h3 class="field-label">Example data</h3>
    <div class="example-data-content-type">Content-Type: application/json</div>
    <pre class="example"><code>{

  "data" : "{}",

  "errorTip" : "交易成功",

  "respMsg" : "成功",

  "version" : "aeiou",

  "resTranSeqId" : "aeiou",

  "respCode" : "S0000000"

}</code></pre>

    <h3 class="field-label">Produces</h3>
    This API call produces the following media types according to the <span class="header">Accept</span> request header;
    the media type will be conveyed by the <span class="heaader">Content-Type</span> response header.
    <ul>
      <li><code>application/json</code></li>
    </ul>

    <h3 class="field-label">Responses</h3>
    <h4 class="field-label">200</h4>
    OK
        <a href="#IrisDeviceRegRsp">IrisDeviceRegRsp</a>
  </div> <!-- method -->
  <hr/>

  <div class="up"><a href="#__Models">Up</a></div>
  <h2><a name="__Models">Models</a></h2>
  [ Jump to <a href="#__Methods">Methods</a> ]

  <h2>Table of Contents</h2>
  <ol>
    <li><a href="#IrisCollect"><code>IrisCollect</code></a></li>
    <li><a href="#IrisDeviceBO"><code>IrisDeviceBO</code></a></li>
    <li><a href="#IrisDeviceHeartbeat"><code>IrisDeviceHeartbeat</code></a></li>
    <li><a href="#IrisDeviceHeartbeatRsp"><code>IrisDeviceHeartbeatRsp</code></a></li>
    <li><a href="#IrisDeviceImport"><code>IrisDeviceImport</code></a></li>
    <li><a href="#IrisDeviceImportRsp"><code>IrisDeviceImportRsp</code></a></li>
    <li><a href="#IrisDeviceLogin"><code>IrisDeviceLogin</code></a></li>
    <li><a href="#IrisDeviceRegReq"><code>IrisDeviceRegReq</code></a></li>
    <li><a href="#IrisDeviceRegRsp"><code>IrisDeviceRegRsp</code></a></li>
    <li><a href="#IrisMatch"><code>IrisMatch</code></a></li>
    <li><a href="#IrisRegistRsp"><code>IrisRegistRsp</code></a></li>
  </ol>

  <div class="model">
    <h3 class="field-label"><a name="IrisCollect">IrisCollect</a> <a class="up" href="#__Models">Up</a></h3>
    <div class="field-items">
      <div class="param">accessToken </div><div class="param-desc"><span class="param-type"><a href="#string">String</a></span> 许可token，后续操作接口需带上它，才能调用成功 </div>
<div class="param">algName (optional)</div><div class="param-desc"><span class="param-type"><a href="#string">String</a></span> 虹膜算法名称 </div>
<div class="param">algVersion (optional)</div><div class="param-desc"><span class="param-type"><a href="#string">String</a></span> 虹膜算法版本�? </div>
<div class="param">deviceId </div><div class="param-desc"><span class="param-type"><a href="#string">String</a></span> 采集设备编号，高5字节填充�?0，低11字节为厂商制定的采集设备生产序列�? </div>
<div class="param">featureBase64 </div><div class="param-desc"><span class="param-type"><a href="#string">String</a></span> 虹膜特征模板,base64编码 </div>
<div class="param">featureLen </div><div class="param-desc"><span class="param-type"><a href="#integer">Integer</a></span> 虹膜特征模板长度，字节单�? format: int32</div>
<div class="param">imgDataBase64 </div><div class="param-desc"><span class="param-type"><a href="#string">String</a></span> 图片数据,base64编码 </div>
<div class="param">imgLen </div><div class="param-desc"><span class="param-type"><a href="#integer">Integer</a></span> 虹膜图像数据长度，字节为单位 format: int32</div>
<div class="param">sign (optional)</div><div class="param-desc"><span class="param-type"><a href="#string">String</a></span> 接口请求签名 </div>
<div class="param">staffId (optional)</div><div class="param-desc"><span class="param-type"><a href="#string">String</a></span> 员工编号 </div>
<div class="param">staffName (optional)</div><div class="param-desc"><span class="param-type"><a href="#string">String</a></span> 员工姓名 </div>
<div class="param">tranCode (optional)</div><div class="param-desc"><span class="param-type"><a href="#string">String</a></span> 交易代码 </div>
<div class="param">tranSeqId (optional)</div><div class="param-desc"><span class="param-type"><a href="#string">String</a></span> 请求流水�? </div>
<div class="param">trantime (optional)</div><div class="param-desc"><span class="param-type"><a href="#string">String</a></span> 交易时间，格�?:yyyymmddHHMMSS </div>
<div class="param">version (optional)</div><div class="param-desc"><span class="param-type"><a href="#string">String</a></span> 接口版本  </div>
    </div>  <!-- field-items -->
  </div>
  <div class="model">
    <h3 class="field-label"><a name="IrisDeviceBO">IrisDeviceBO</a> <a class="up" href="#__Models">Up</a></h3>
    <div class="field-items">
      <div class="param">descriptor </div><div class="param-desc"><span class="param-type"><a href="#string">String</a></span> 虹膜采集设备描述 </div>
<div class="param">devImgDepth (optional)</div><div class="param-desc"><span class="param-type"><a href="#integer">Integer</a></span> 像素位深�? format: int32</div>
<div class="param">devImgFormat (optional)</div><div class="param-desc"><span class="param-type"><a href="#string">String</a></span> 设备返回图像格式 </div>
<div class="param">devImgHeight (optional)</div><div class="param-desc"><span class="param-type"><a href="#integer">Integer</a></span> 设备采集图像高度 format: int32</div>
<div class="param">devImgWidth (optional)</div><div class="param-desc"><span class="param-type"><a href="#integer">Integer</a></span> 设备采集图像宽度 format: int32</div>
<div class="param">deviceFlag (optional)</div><div class="param-desc"><span class="param-type"><a href="#integer">Integer</a></span> 采集设备注册标识 format: int32</div>
<div class="param">deviceId </div><div class="param-desc"><span class="param-type"><a href="#string">String</a></span> 采集设备编号，高5字节填充�?0，低11字节为厂商制定的采集设备生产序列�? </div>
<div class="param">firmwareVersion (optional)</div><div class="param-desc"><span class="param-type"><a href="#string">String</a></span> 设备固件版本 </div>
<div class="param">productType </div><div class="param-desc"><span class="param-type"><a href="#string">String</a></span> 虹膜采集设备型号 </div>
<div class="param">registerFlag (optional)</div><div class="param-desc"><span class="param-type"><a href="#integer">Integer</a></span> 采集设备注册标识 format: int32</div>
<div class="param">sensorType (optional)</div><div class="param-desc"><span class="param-type"><a href="#integer">Integer</a></span> 采集设备传感器类型标�? format: int32</div>
<div class="param">spetrum (optional)</div><div class="param-desc"><span class="param-type"><a href="#integer">Integer</a></span> 光谱 format: int32</div>
<div class="param">vendorId (optional)</div><div class="param-desc"><span class="param-type"><a href="#string">String</a></span> 采集设备供方标识。高6字节填充�?0，低18字节为厂商社会信用代�? </div>
    </div>  <!-- field-items -->
  </div>
  <div class="model">
    <h3 class="field-label"><a name="IrisDeviceHeartbeat">IrisDeviceHeartbeat</a> <a class="up" href="#__Models">Up</a></h3>
    <div class="field-items">
      <div class="param">accessToken </div><div class="param-desc"><span class="param-type"><a href="#string">String</a></span> 许可token，后续操作接口需带上它，才能调用成功 </div>
<div class="param">deviceId </div><div class="param-desc"><span class="param-type"><a href="#string">String</a></span> 采集设备编号，高5字节填充�?0，低11字节为厂商制定的采集设备生产序列�? </div>
<div class="param">sign (optional)</div><div class="param-desc"><span class="param-type"><a href="#string">String</a></span> 接口请求签名 </div>
<div class="param">tranCode (optional)</div><div class="param-desc"><span class="param-type"><a href="#string">String</a></span> 交易代码 </div>
<div class="param">tranSeqId (optional)</div><div class="param-desc"><span class="param-type"><a href="#string">String</a></span> 请求流水�? </div>
<div class="param">trantime (optional)</div><div class="param-desc"><span class="param-type"><a href="#string">String</a></span> 交易时间，格�?:yyyymmddHHMMSS </div>
<div class="param">version (optional)</div><div class="param-desc"><span class="param-type"><a href="#string">String</a></span> 接口版本  </div>
    </div>  <!-- field-items -->
  </div>
  <div class="model">
    <h3 class="field-label"><a name="IrisDeviceHeartbeatRsp">IrisDeviceHeartbeatRsp</a> <a class="up" href="#__Models">Up</a></h3>
    <div class="field-items">
      <div class="param">accessToken </div><div class="param-desc"><span class="param-type"><a href="#string">String</a></span> 许可token，后续操作接口需带上它，才能调用成功 </div>
<div class="param">data (optional)</div><div class="param-desc"><span class="param-type"><a href="#object">Object</a></span> 数据对象 </div>
<div class="param">deviceId </div><div class="param-desc"><span class="param-type"><a href="#string">String</a></span> 采集设备编号，高5字节填充�?0，低11字节为厂商制定的采集设备生产序列�? </div>
<div class="param">errorTip (optional)</div><div class="param-desc"><span class="param-type"><a href="#string">String</a></span> 错误提示 </div>
<div class="param">resTranSeqId (optional)</div><div class="param-desc"><span class="param-type"><a href="#string">String</a></span> 返回流水�? </div>
<div class="param">respCode (optional)</div><div class="param-desc"><span class="param-type"><a href="#string">String</a></span> 响应�? </div>
<div class="param">respMsg (optional)</div><div class="param-desc"><span class="param-type"><a href="#string">String</a></span> 响应描述 </div>
<div class="param">version (optional)</div><div class="param-desc"><span class="param-type"><a href="#string">String</a></span> 返回接口版本  </div>
    </div>  <!-- field-items -->
  </div>
  <div class="model">
    <h3 class="field-label"><a name="IrisDeviceImport">IrisDeviceImport</a> <a class="up" href="#__Models">Up</a></h3>
    <div class="field-items">
      <div class="param">devices </div><div class="param-desc"><span class="param-type"><a href="#IrisDeviceBO">array[IrisDeviceBO]</a></span> 采集设备信息列表 </div>
<div class="param">sign (optional)</div><div class="param-desc"><span class="param-type"><a href="#string">String</a></span> 接口请求签名 </div>
<div class="param">tranCode (optional)</div><div class="param-desc"><span class="param-type"><a href="#string">String</a></span> 交易代码 </div>
<div class="param">tranSeqId (optional)</div><div class="param-desc"><span class="param-type"><a href="#string">String</a></span> 请求流水�? </div>
<div class="param">trantime (optional)</div><div class="param-desc"><span class="param-type"><a href="#string">String</a></span> 交易时间，格�?:yyyymmddHHMMSS </div>
<div class="param">version (optional)</div><div class="param-desc"><span class="param-type"><a href="#string">String</a></span> 接口版本  </div>
    </div>  <!-- field-items -->
  </div>
  <div class="model">
    <h3 class="field-label"><a name="IrisDeviceImportRsp">IrisDeviceImportRsp</a> <a class="up" href="#__Models">Up</a></h3>
    <div class="field-items">
      <div class="param">data (optional)</div><div class="param-desc"><span class="param-type"><a href="#object">Object</a></span> 数据对象 </div>
<div class="param">errorTip (optional)</div><div class="param-desc"><span class="param-type"><a href="#string">String</a></span> 错误提示 </div>
<div class="param">resTranSeqId (optional)</div><div class="param-desc"><span class="param-type"><a href="#string">String</a></span> 返回流水�? </div>
<div class="param">respCode (optional)</div><div class="param-desc"><span class="param-type"><a href="#string">String</a></span> 响应�? </div>
<div class="param">respMsg (optional)</div><div class="param-desc"><span class="param-type"><a href="#string">String</a></span> 响应描述 </div>
<div class="param">version (optional)</div><div class="param-desc"><span class="param-type"><a href="#string">String</a></span> 返回接口版本  </div>
    </div>  <!-- field-items -->
  </div>
  <div class="model">
    <h3 class="field-label"><a name="IrisDeviceLogin">IrisDeviceLogin</a> <a class="up" href="#__Models">Up</a></h3>
    <div class="field-items">
      <div class="param">accessToken </div><div class="param-desc"><span class="param-type"><a href="#string">String</a></span> 许可token，后续操作接口需带上它，才能调用成功 </div>
<div class="param">data (optional)</div><div class="param-desc"><span class="param-type"><a href="#object">Object</a></span> 数据对象 </div>
<div class="param">deviceId </div><div class="param-desc"><span class="param-type"><a href="#string">String</a></span> 采集设备编号，高5字节填充�?0，低11字节为厂商制定的采集设备生产序列�? </div>
<div class="param">errorTip (optional)</div><div class="param-desc"><span class="param-type"><a href="#string">String</a></span> 错误提示 </div>
<div class="param">resTranSeqId (optional)</div><div class="param-desc"><span class="param-type"><a href="#string">String</a></span> 返回流水�? </div>
<div class="param">respCode (optional)</div><div class="param-desc"><span class="param-type"><a href="#string">String</a></span> 响应�? </div>
<div class="param">respMsg (optional)</div><div class="param-desc"><span class="param-type"><a href="#string">String</a></span> 响应描述 </div>
<div class="param">sign (optional)</div><div class="param-desc"><span class="param-type"><a href="#string">String</a></span> 接口请求签名 </div>
<div class="param">tranCode (optional)</div><div class="param-desc"><span class="param-type"><a href="#string">String</a></span> 交易代码 </div>
<div class="param">tranSeqId (optional)</div><div class="param-desc"><span class="param-type"><a href="#string">String</a></span> 请求流水�? </div>
<div class="param">trantime (optional)</div><div class="param-desc"><span class="param-type"><a href="#string">String</a></span> 交易时间，格�?:yyyymmddHHMMSS </div>
<div class="param">version (optional)</div><div class="param-desc"><span class="param-type"><a href="#string">String</a></span> 接口版本  </div>
    </div>  <!-- field-items -->
  </div>
  <div class="model">
    <h3 class="field-label"><a name="IrisDeviceRegReq">IrisDeviceRegReq</a> <a class="up" href="#__Models">Up</a></h3>
    <div class="field-items">
      <div class="param">descriptor </div><div class="param-desc"><span class="param-type"><a href="#string">String</a></span> 虹膜采集设备描述 </div>
<div class="param">devImgDepth (optional)</div><div class="param-desc"><span class="param-type"><a href="#integer">Integer</a></span> 像素位深�? format: int32</div>
<div class="param">devImgFormat (optional)</div><div class="param-desc"><span class="param-type"><a href="#string">String</a></span> 设备返回图像格式 </div>
<div class="param">devImgHeight (optional)</div><div class="param-desc"><span class="param-type"><a href="#integer">Integer</a></span> 设备采集图像高度 format: int32</div>
<div class="param">devImgWidth (optional)</div><div class="param-desc"><span class="param-type"><a href="#integer">Integer</a></span> 设备采集图像宽度 format: int32</div>
<div class="param">deviceFlag (optional)</div><div class="param-desc"><span class="param-type"><a href="#integer">Integer</a></span> 采集设备注册标识 format: int32</div>
<div class="param">deviceId </div><div class="param-desc"><span class="param-type"><a href="#string">String</a></span> 采集设备编号，高5字节填充�?0，低11字节为厂商制定的采集设备生产序列�? </div>
<div class="param">firmwareVersion (optional)</div><div class="param-desc"><span class="param-type"><a href="#string">String</a></span> 设备固件版本 </div>
<div class="param">productType </div><div class="param-desc"><span class="param-type"><a href="#string">String</a></span> 虹膜采集设备型号 </div>
<div class="param">registerFlag (optional)</div><div class="param-desc"><span class="param-type"><a href="#integer">Integer</a></span> 采集设备注册标识 format: int32</div>
<div class="param">sensorType (optional)</div><div class="param-desc"><span class="param-type"><a href="#integer">Integer</a></span> 采集设备传感器类型标�? format: int32</div>
<div class="param">sign (optional)</div><div class="param-desc"><span class="param-type"><a href="#string">String</a></span> 接口请求签名 </div>
<div class="param">spetrum (optional)</div><div class="param-desc"><span class="param-type"><a href="#integer">Integer</a></span> 光谱 format: int32</div>
<div class="param">tranCode (optional)</div><div class="param-desc"><span class="param-type"><a href="#string">String</a></span> 交易代码 </div>
<div class="param">tranSeqId (optional)</div><div class="param-desc"><span class="param-type"><a href="#string">String</a></span> 请求流水�? </div>
<div class="param">trantime (optional)</div><div class="param-desc"><span class="param-type"><a href="#string">String</a></span> 交易时间，格�?:yyyymmddHHMMSS </div>
<div class="param">vendorId (optional)</div><div class="param-desc"><span class="param-type"><a href="#string">String</a></span> 采集设备供方标识。高6字节填充�?0，低18字节为厂商社会信用代�? </div>
<div class="param">version (optional)</div><div class="param-desc"><span class="param-type"><a href="#string">String</a></span> 接口版本  </div>
    </div>  <!-- field-items -->
  </div>
  <div class="model">
    <h3 class="field-label"><a name="IrisDeviceRegRsp">IrisDeviceRegRsp</a> <a class="up" href="#__Models">Up</a></h3>
    <div class="field-items">
      <div class="param">data (optional)</div><div class="param-desc"><span class="param-type"><a href="#object">Object</a></span> 数据对象 </div>
<div class="param">errorTip (optional)</div><div class="param-desc"><span class="param-type"><a href="#string">String</a></span> 错误提示 </div>
<div class="param">resTranSeqId (optional)</div><div class="param-desc"><span class="param-type"><a href="#string">String</a></span> 返回流水�? </div>
<div class="param">respCode (optional)</div><div class="param-desc"><span class="param-type"><a href="#string">String</a></span> 响应�? </div>
<div class="param">respMsg (optional)</div><div class="param-desc"><span class="param-type"><a href="#string">String</a></span> 响应描述 </div>
<div class="param">version (optional)</div><div class="param-desc"><span class="param-type"><a href="#string">String</a></span> 返回接口版本  </div>
    </div>  <!-- field-items -->
  </div>
  <div class="model">
    <h3 class="field-label"><a name="IrisMatch">IrisMatch</a> <a class="up" href="#__Models">Up</a></h3>
    <div class="field-items">
      <div class="param">accessToken </div><div class="param-desc"><span class="param-type"><a href="#string">String</a></span> 许可token，后续操作接口需带上它，才能调用成功 </div>
<div class="param">algName (optional)</div><div class="param-desc"><span class="param-type"><a href="#string">String</a></span> 虹膜算法名称 </div>
<div class="param">algVersion (optional)</div><div class="param-desc"><span class="param-type"><a href="#string">String</a></span> 虹膜算法版本�? </div>
<div class="param">deviceId </div><div class="param-desc"><span class="param-type"><a href="#string">String</a></span> 采集设备编号，高5字节填充�?0，低11字节为厂商制定的采集设备生产序列�? </div>
<div class="param">featureBase64 </div><div class="param-desc"><span class="param-type"><a href="#string">String</a></span> 虹膜特征模板,base64编码 </div>
<div class="param">featureLen </div><div class="param-desc"><span class="param-type"><a href="#integer">Integer</a></span> 虹膜特征模板长度，字节单�? format: int32</div>
<div class="param">imgDataBase64 </div><div class="param-desc"><span class="param-type"><a href="#string">String</a></span> 图片数据,base64编码 </div>
<div class="param">imgLen </div><div class="param-desc"><span class="param-type"><a href="#integer">Integer</a></span> 虹膜图像数据长度，字节为单位 format: int32</div>
<div class="param">sign (optional)</div><div class="param-desc"><span class="param-type"><a href="#string">String</a></span> 接口请求签名 </div>
<div class="param">tranCode (optional)</div><div class="param-desc"><span class="param-type"><a href="#string">String</a></span> 交易代码 </div>
<div class="param">tranSeqId (optional)</div><div class="param-desc"><span class="param-type"><a href="#string">String</a></span> 请求流水�? </div>
<div class="param">trantime (optional)</div><div class="param-desc"><span class="param-type"><a href="#string">String</a></span> 交易时间，格�?:yyyymmddHHMMSS </div>
<div class="param">version (optional)</div><div class="param-desc"><span class="param-type"><a href="#string">String</a></span> 接口版本  </div>
    </div>  <!-- field-items -->
  </div>
  <div class="model">
    <h3 class="field-label"><a name="IrisRegistRsp">IrisRegistRsp</a> <a class="up" href="#__Models">Up</a></h3>
    <div class="field-items">
      <div class="param">data (optional)</div><div class="param-desc"><span class="param-type"><a href="#object">Object</a></span> 数据对象 </div>
<div class="param">errorTip (optional)</div><div class="param-desc"><span class="param-type"><a href="#string">String</a></span> 错误提示 </div>
<div class="param">resTranSeqId (optional)</div><div class="param-desc"><span class="param-type"><a href="#string">String</a></span> 返回流水�? </div>
<div class="param">respCode (optional)</div><div class="param-desc"><span class="param-type"><a href="#string">String</a></span> 响应�? </div>
<div class="param">respMsg (optional)</div><div class="param-desc"><span class="param-type"><a href="#string">String</a></span> 响应描述 </div>
<div class="param">staffId (optional)</div><div class="param-desc"><span class="param-type"><a href="#string">String</a></span> 员工编号 </div>
<div class="param">staffName (optional)</div><div class="param-desc"><span class="param-type"><a href="#string">String</a></span> 员工姓名 </div>
<div class="param">version (optional)</div><div class="param-desc"><span class="param-type"><a href="#string">String</a></span> 返回接口版本  </div>
    </div>  <!-- field-items -->
  </div>
```



### 2.2 Socket接口

待添�?