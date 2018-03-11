# IrisApi.IrisDeviceLogin

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**accessToken** | **String** | 许可token，后续操作接口需带上它，才能调用成功 | 
**data** | **Object** | 数据对象 | [optional] 
**deviceId** | **String** | 采集设备编号，高5字节填充为0，低11字节为厂商制定的采集设备生产序列号 | 
**errorTip** | **String** | 错误提示 | [optional] 
**resTranSeqId** | **String** | 返回流水号 | [optional] 
**respCode** | **String** | 响应码 | [optional] 
**respMsg** | **String** | 响应描述 | [optional] 
**sign** | **String** | 接口请求签名 | [optional] 
**tranCode** | **String** | 交易代码 | [optional] 
**tranSeqId** | **String** | 请求流水号 | [optional] 
**trantime** | **String** | 交易时间，格式:yyyymmddHHMMSS | [optional] 
**version** | **String** | 接口版本  | [optional] 


