# IrisApi.IrisCollect

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**accessToken** | **String** | 许可token，后续操作接口需带上它，才能调用成功 | 
**algName** | **String** | 虹膜算法名称 | [optional] 
**algVersion** | **String** | 虹膜算法版本号 | [optional] 
**deviceId** | **String** | 采集设备编号，高5字节填充为0，低11字节为厂商制定的采集设备生产序列号 | 
**featureBase64** | **String** | 虹膜特征模板,base64编码 | 
**featureLen** | **Integer** | 虹膜特征模板长度，字节单位 | 
**imgDataBase64** | **String** | 图片数据,base64编码 | 
**imgLen** | **Integer** | 虹膜图像数据长度，字节为单位 | 
**sign** | **String** | 接口请求签名 | [optional] 
**staffId** | **String** | 员工编号 | [optional] 
**staffName** | **String** | 员工姓名 | [optional] 
**tranCode** | **String** | 交易代码 | [optional] 
**tranSeqId** | **String** | 请求流水号 | [optional] 
**trantime** | **String** | 交易时间，格式:yyyymmddHHMMSS | [optional] 
**version** | **String** | 接口版本  | [optional] 


