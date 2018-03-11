package com.yrds.iris.persist.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "iris_device")
public class IrisDevice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 采集设备编号，高5字节填充为0，低11字节为厂商制定的采集设备生产序列号
     */
    @Column(name = "device_id")
    private String deviceId;

    /**
     * 虹膜采集设备描述字符串
     */
    private String descriptor;

    /**
     * 虹膜采集设备型号字符串
     */
    @Column(name = "product_type")
    private String productType;

    /**
     * 采集设备供方标识。高6字节填充为0，低18字节为厂商社会信用代码
     */
    @Column(name = "vendor_id")
    private String vendorId;

    /**
     * 采集设备传感器类型标识
     */
    @Column(name = "sensor_type")
    private Integer sensorType;

    /**
     * 采集设备注册标识
     */
    @Column(name = "register_flag")
    private Integer registerFlag;

    /**
     * 虹膜采集设备类型，0：单目，1：双目单摄像头，2：双目双摄像头，3~100：保留
     */
    @Column(name = "device_flag")
    private Integer deviceFlag;

    /**
     * 光谱
     */
    private Integer spetrum;

    /**
     * 设备返回图像格式
     */
    @Column(name = "dev_img_format")
    private String devImgFormat;

    /**
     * 像素位深度
     */
    @Column(name = "dev_img_depth")
    private Integer devImgDepth;

    /**
     * 设备采集图像宽度
     */
    @Column(name = "dev_img_width")
    private Integer devImgWidth;

    /**
     * 设备采集图像高度
     */
    @Column(name = "dev_img_height")
    private Integer devImgHeight;

    /**
     * 设备固件版本
     */
    @Column(name = "firmware_version")
    private String firmwareVersion;

    /**
     * 设备登录IP
     */
    @Column(name = "login_ip")
    private String loginIp;

    /**
     * 登录时间
     */
    @Column(name = "login_time")
    private Date loginTime;

    /**
     * 设备登出时间
     */
    @Column(name = "logout_time")
    private Date logoutTime;

    /**
     * 状态，0：未注册，1：已注册待审核，2：已注销，3：未登录，4：已登录
     */
    private Integer status;

    /**
     * 门禁位置代码
     */
    @Column(name = "gate_code")
    private String gateCode;

    /**
     * 门禁位置说明
     */
    @Column(name = "gate_remark")
    private String gateRemark;

    /**
     * 操作员
     */
    private String operator;

    /**
     * 记录创建时间
     */
    @Column(name = "gmt_create")
    private Date gmtCreate;

    /**
     * 记录修改时间
     */
    @Column(name = "gmt_update")
    private Date gmtUpdate;

    /**
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取采集设备编号，高5字节填充为0，低11字节为厂商制定的采集设备生产序列号
     *
     * @return device_id - 采集设备编号，高5字节填充为0，低11字节为厂商制定的采集设备生产序列号
     */
    public String getDeviceId() {
        return deviceId;
    }

    /**
     * 设置采集设备编号，高5字节填充为0，低11字节为厂商制定的采集设备生产序列号
     *
     * @param deviceId 采集设备编号，高5字节填充为0，低11字节为厂商制定的采集设备生产序列号
     */
    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    /**
     * 获取虹膜采集设备描述字符串
     *
     * @return descriptor - 虹膜采集设备描述字符串
     */
    public String getDescriptor() {
        return descriptor;
    }

    /**
     * 设置虹膜采集设备描述字符串
     *
     * @param descriptor 虹膜采集设备描述字符串
     */
    public void setDescriptor(String descriptor) {
        this.descriptor = descriptor;
    }

    /**
     * 获取虹膜采集设备型号字符串
     *
     * @return product_type - 虹膜采集设备型号字符串
     */
    public String getProductType() {
        return productType;
    }

    /**
     * 设置虹膜采集设备型号字符串
     *
     * @param productType 虹膜采集设备型号字符串
     */
    public void setProductType(String productType) {
        this.productType = productType;
    }

    /**
     * 获取采集设备供方标识。高6字节填充为0，低18字节为厂商社会信用代码
     *
     * @return vendor_id - 采集设备供方标识。高6字节填充为0，低18字节为厂商社会信用代码
     */
    public String getVendorId() {
        return vendorId;
    }

    /**
     * 设置采集设备供方标识。高6字节填充为0，低18字节为厂商社会信用代码
     *
     * @param vendorId 采集设备供方标识。高6字节填充为0，低18字节为厂商社会信用代码
     */
    public void setVendorId(String vendorId) {
        this.vendorId = vendorId;
    }

    /**
     * 获取采集设备传感器类型标识
     *
     * @return sensor_type - 采集设备传感器类型标识
     */
    public Integer getSensorType() {
        return sensorType;
    }

    /**
     * 设置采集设备传感器类型标识
     *
     * @param sensorType 采集设备传感器类型标识
     */
    public void setSensorType(Integer sensorType) {
        this.sensorType = sensorType;
    }

    /**
     * 获取采集设备注册标识
     *
     * @return register_flag - 采集设备注册标识
     */
    public Integer getRegisterFlag() {
        return registerFlag;
    }

    /**
     * 设置采集设备注册标识
     *
     * @param registerFlag 采集设备注册标识
     */
    public void setRegisterFlag(Integer registerFlag) {
        this.registerFlag = registerFlag;
    }

    /**
     * 获取虹膜采集设备类型，0：单目，1：双目单摄像头，2：双目双摄像头，3~100：保留
     *
     * @return device_flag - 虹膜采集设备类型，0：单目，1：双目单摄像头，2：双目双摄像头，3~100：保留
     */
    public Integer getDeviceFlag() {
        return deviceFlag;
    }

    /**
     * 设置虹膜采集设备类型，0：单目，1：双目单摄像头，2：双目双摄像头，3~100：保留
     *
     * @param deviceFlag 虹膜采集设备类型，0：单目，1：双目单摄像头，2：双目双摄像头，3~100：保留
     */
    public void setDeviceFlag(Integer deviceFlag) {
        this.deviceFlag = deviceFlag;
    }

    /**
     * 获取光谱
     *
     * @return spetrum - 光谱
     */
    public Integer getSpetrum() {
        return spetrum;
    }

    /**
     * 设置光谱
     *
     * @param spetrum 光谱
     */
    public void setSpetrum(Integer spetrum) {
        this.spetrum = spetrum;
    }

    /**
     * 获取设备返回图像格式
     *
     * @return dev_img_format - 设备返回图像格式
     */
    public String getDevImgFormat() {
        return devImgFormat;
    }

    /**
     * 设置设备返回图像格式
     *
     * @param devImgFormat 设备返回图像格式
     */
    public void setDevImgFormat(String devImgFormat) {
        this.devImgFormat = devImgFormat;
    }

    /**
     * 获取像素位深度
     *
     * @return dev_img_depth - 像素位深度
     */
    public Integer getDevImgDepth() {
        return devImgDepth;
    }

    /**
     * 设置像素位深度
     *
     * @param devImgDepth 像素位深度
     */
    public void setDevImgDepth(Integer devImgDepth) {
        this.devImgDepth = devImgDepth;
    }

    /**
     * 获取设备采集图像宽度
     *
     * @return dev_img_width - 设备采集图像宽度
     */
    public Integer getDevImgWidth() {
        return devImgWidth;
    }

    /**
     * 设置设备采集图像宽度
     *
     * @param devImgWidth 设备采集图像宽度
     */
    public void setDevImgWidth(Integer devImgWidth) {
        this.devImgWidth = devImgWidth;
    }

    /**
     * 获取设备采集图像高度
     *
     * @return dev_img_height - 设备采集图像高度
     */
    public Integer getDevImgHeight() {
        return devImgHeight;
    }

    /**
     * 设置设备采集图像高度
     *
     * @param devImgHeight 设备采集图像高度
     */
    public void setDevImgHeight(Integer devImgHeight) {
        this.devImgHeight = devImgHeight;
    }

    /**
     * 获取设备固件版本
     *
     * @return firmware_version - 设备固件版本
     */
    public String getFirmwareVersion() {
        return firmwareVersion;
    }

    /**
     * 设置设备固件版本
     *
     * @param firmwareVersion 设备固件版本
     */
    public void setFirmwareVersion(String firmwareVersion) {
        this.firmwareVersion = firmwareVersion;
    }

    /**
     * 获取设备登录IP
     *
     * @return login_ip - 设备登录IP
     */
    public String getLoginIp() {
        return loginIp;
    }

    /**
     * 设置设备登录IP
     *
     * @param loginIp 设备登录IP
     */
    public void setLoginIp(String loginIp) {
        this.loginIp = loginIp;
    }

    /**
     * 获取登录时间
     *
     * @return login_time - 登录时间
     */
    public Date getLoginTime() {
        return loginTime;
    }

    /**
     * 设置登录时间
     *
     * @param loginTime 登录时间
     */
    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }

    /**
     * 获取设备登出时间
     *
     * @return logout_time - 设备登出时间
     */
    public Date getLogoutTime() {
        return logoutTime;
    }

    /**
     * 设置设备登出时间
     *
     * @param logoutTime 设备登出时间
     */
    public void setLogoutTime(Date logoutTime) {
        this.logoutTime = logoutTime;
    }

    /**
     * 获取状态，0：未注册，1：已注册待审核，2：已注销，3：未登录，4：已登录
     *
     * @return status - 状态，0：未注册，1：已注册待审核，2：已注销，3：未登录，4：已登录
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置状态，0：未注册，1：已注册待审核，2：已注销，3：未登录，4：已登录
     *
     * @param status 状态，0：未注册，1：已注册待审核，2：已注销，3：未登录，4：已登录
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 获取门禁位置代码
     *
     * @return gate_code - 门禁位置代码
     */
    public String getGateCode() {
        return gateCode;
    }

    /**
     * 设置门禁位置代码
     *
     * @param gateCode 门禁位置代码
     */
    public void setGateCode(String gateCode) {
        this.gateCode = gateCode;
    }

    /**
     * 获取门禁位置说明
     *
     * @return gate_remark - 门禁位置说明
     */
    public String getGateRemark() {
        return gateRemark;
    }

    /**
     * 设置门禁位置说明
     *
     * @param gateRemark 门禁位置说明
     */
    public void setGateRemark(String gateRemark) {
        this.gateRemark = gateRemark;
    }

    /**
     * 获取操作员
     *
     * @return operator - 操作员
     */
    public String getOperator() {
        return operator;
    }

    /**
     * 设置操作员
     *
     * @param operator 操作员
     */
    public void setOperator(String operator) {
        this.operator = operator;
    }

    /**
     * 获取记录创建时间
     *
     * @return gmt_create - 记录创建时间
     */
    public Date getGmtCreate() {
        return gmtCreate;
    }

    /**
     * 设置记录创建时间
     *
     * @param gmtCreate 记录创建时间
     */
    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    /**
     * 获取记录修改时间
     *
     * @return gmt_update - 记录修改时间
     */
    public Date getGmtUpdate() {
        return gmtUpdate;
    }

    /**
     * 设置记录修改时间
     *
     * @param gmtUpdate 记录修改时间
     */
    public void setGmtUpdate(Date gmtUpdate) {
        this.gmtUpdate = gmtUpdate;
    }
}