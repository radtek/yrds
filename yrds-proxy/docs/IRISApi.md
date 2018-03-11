# IrisApi.IRISApi

All URIs are relative to *https://localhost:8085/yrds-proxy*

Method | HTTP request | Description
------------- | ------------- | -------------
[**irisCollect**](IRISApi.md#irisCollect) | **POST** /api/irisCollect | IRIS采集接口
[**irisMatch**](IRISApi.md#irisMatch) | **POST** /api/irisMatch | IRIS比对接口


<a name="irisCollect"></a>
# **irisCollect**
> IrisRegistRsp irisCollect(req)

IRIS采集接口

IRIS采集接口

### Example
```javascript
var IrisApi = require('iris_api');

var apiInstance = new IrisApi.IRISApi();

var req = new IrisApi.IrisCollect(); // IrisCollect | req


var callback = function(error, data, response) {
  if (error) {
    console.error(error);
  } else {
    console.log('API called successfully. Returned data: ' + data);
  }
};
apiInstance.irisCollect(req, callback);
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **req** | [**IrisCollect**](IrisCollect.md)| req | 

### Return type

[**IrisRegistRsp**](IrisRegistRsp.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json, multipart/form-data
 - **Accept**: application/json

<a name="irisMatch"></a>
# **irisMatch**
> IrisRegistRsp irisMatch(req)

IRIS比对接口

IRIS比对接口

### Example
```javascript
var IrisApi = require('iris_api');

var apiInstance = new IrisApi.IRISApi();

var req = new IrisApi.IrisMatch(); // IrisMatch | req


var callback = function(error, data, response) {
  if (error) {
    console.error(error);
  } else {
    console.log('API called successfully. Returned data: ' + data);
  }
};
apiInstance.irisMatch(req, callback);
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **req** | [**IrisMatch**](IrisMatch.md)| req | 

### Return type

[**IrisRegistRsp**](IrisRegistRsp.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json, multipart/form-data
 - **Accept**: application/json

