# IrisApi.IrisDeviceHeartbeat

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**accessToken** | **String** | 许可token，后续操作接口需带上它，才能调用成功 | 
**deviceId** | **String** | 采集设备编号，高5字节填充为0，低11字节为厂商制定的采集设备生产序列号 | 
**sign** | **String** | 接口请求签名 | [optional] 
**tranCode** | **String** | 交易代码 | [optional] 
**tranSeqId** | **String** | 请求流水号 | [optional] 
**trantime** | **String** | 交易时间，格式:yyyymmddHHMMSS | [optional] 
**version** | **String** | 接口版本  | [optional] 


