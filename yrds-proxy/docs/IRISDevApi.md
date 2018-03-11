# IrisApi.IRISDevApi

All URIs are relative to *https://localhost:8085/yrds-proxy*

Method | HTTP request | Description
------------- | ------------- | -------------
[**irisDevHeartbeat**](IRISDevApi.md#irisDevHeartbeat) | **POST** /api/irisDevHeartbeat | IRIS设备心跳接口
[**irisDevImportBatch**](IRISDevApi.md#irisDevImportBatch) | **POST** /api/irisDevImportBatch | IRIS设备信息批量导入接口
[**irisDevLogin**](IRISDevApi.md#irisDevLogin) | **POST** /api/irisDevLogin | IRIS设备登录接口
[**irisDevRegist**](IRISDevApi.md#irisDevRegist) | **POST** /api/irisDevRegist | IRIS设备注册接口


<a name="irisDevHeartbeat"></a>
# **irisDevHeartbeat**
> IrisDeviceHeartbeatRsp irisDevHeartbeat(req)

IRIS设备心跳接口

IRIS设备心跳接口

### Example
```javascript
var IrisApi = require('iris_api');

var apiInstance = new IrisApi.IRISDevApi();

var req = new IrisApi.IrisDeviceHeartbeat(); // IrisDeviceHeartbeat | req


var callback = function(error, data, response) {
  if (error) {
    console.error(error);
  } else {
    console.log('API called successfully. Returned data: ' + data);
  }
};
apiInstance.irisDevHeartbeat(req, callback);
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **req** | [**IrisDeviceHeartbeat**](IrisDeviceHeartbeat.md)| req | 

### Return type

[**IrisDeviceHeartbeatRsp**](IrisDeviceHeartbeatRsp.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json, multipart/form-data
 - **Accept**: application/json

<a name="irisDevImportBatch"></a>
# **irisDevImportBatch**
> IrisDeviceImportRsp irisDevImportBatch(req)

IRIS设备信息批量导入接口

IRIS设备信息批量导入接口

### Example
```javascript
var IrisApi = require('iris_api');

var apiInstance = new IrisApi.IRISDevApi();

var req = new IrisApi.IrisDeviceImport(); // IrisDeviceImport | req


var callback = function(error, data, response) {
  if (error) {
    console.error(error);
  } else {
    console.log('API called successfully. Returned data: ' + data);
  }
};
apiInstance.irisDevImportBatch(req, callback);
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **req** | [**IrisDeviceImport**](IrisDeviceImport.md)| req | 

### Return type

[**IrisDeviceImportRsp**](IrisDeviceImportRsp.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json, multipart/form-data
 - **Accept**: application/json

<a name="irisDevLogin"></a>
# **irisDevLogin**
> IrisDeviceLogin irisDevLogin(req)

IRIS设备登录接口

IRIS设备登录接口

### Example
```javascript
var IrisApi = require('iris_api');

var apiInstance = new IrisApi.IRISDevApi();

var req = new IrisApi.IrisDeviceLogin(); // IrisDeviceLogin | req


var callback = function(error, data, response) {
  if (error) {
    console.error(error);
  } else {
    console.log('API called successfully. Returned data: ' + data);
  }
};
apiInstance.irisDevLogin(req, callback);
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **req** | [**IrisDeviceLogin**](IrisDeviceLogin.md)| req | 

### Return type

[**IrisDeviceLogin**](IrisDeviceLogin.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json, multipart/form-data
 - **Accept**: application/json

<a name="irisDevRegist"></a>
# **irisDevRegist**
> IrisDeviceRegRsp irisDevRegist(req)

IRIS设备注册接口

IRIS设备注册接口

### Example
```javascript
var IrisApi = require('iris_api');

var apiInstance = new IrisApi.IRISDevApi();

var req = new IrisApi.IrisDeviceRegReq(); // IrisDeviceRegReq | req


var callback = function(error, data, response) {
  if (error) {
    console.error(error);
  } else {
    console.log('API called successfully. Returned data: ' + data);
  }
};
apiInstance.irisDevRegist(req, callback);
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **req** | [**IrisDeviceRegReq**](IrisDeviceRegReq.md)| req | 

### Return type

[**IrisDeviceRegRsp**](IrisDeviceRegRsp.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json, multipart/form-data
 - **Accept**: application/json

