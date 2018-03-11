package com.yrds.iris.persist.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "iris_feature_temp")
public class IrisFeatureTemp {
    /**
     * 主键ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 采集设备ID
     */
    @Column(name = "device_id")
    private Long deviceId;

    /**
     * 被采集人员的ID
     */
    @Column(name = "staff_id")
    private Long staffId;

    /**
     * 虹膜图片像数位深度
     */
    @Column(name = "img_depth")
    private Integer imgDepth;

    /**
     * 虹膜图像宽度
     */
    @Column(name = "img_width")
    private Integer imgWidth;

    /**
     * 虹膜图像高度
     */
    @Column(name = "img_height")
    private Integer imgHeight;

    /**
     * 虹膜图像数据长度，字节为单位
     */
    @Column(name = "img_len")
    private Integer imgLen;

    /**
     * 虹膜特征模板长度，字节单位
     */
    @Column(name = "feature_len")
    private Integer featureLen;

    /**
     * 虹膜算法名称
     */
    @Column(name = "alg_name")
    private String algName;

    /**
     * 虹膜算法版本号
     */
    @Column(name = "alg_version")
    private String algVersion;

    /**
     * 创建时间
     */
    @Column(name = "gmt_create")
    private Date gmtCreate;

    /**
     * 更新时间
     */
    @Column(name = "gmt_update")
    private Date gmtUpdate;

    /**
     * 图片数据
     */
    @Column(name = "img_data")
    private byte[] imgData;

    /**
     * 虹膜特征模板
     */
    private byte[] feature;

    /**
     * 获取主键ID
     *
     * @return id - 主键ID
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置主键ID
     *
     * @param id 主键ID
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取采集设备ID
     *
     * @return device_id - 采集设备ID
     */
    public Long getDeviceId() {
        return deviceId;
    }

    /**
     * 设置采集设备ID
     *
     * @param deviceId 采集设备ID
     */
    public void setDeviceId(Long deviceId) {
        this.deviceId = deviceId;
    }

    /**
     * 获取被采集人员的ID
     *
     * @return staff_id - 被采集人员的ID
     */
    public Long getStaffId() {
        return staffId;
    }

    /**
     * 设置被采集人员的ID
     *
     * @param staffId 被采集人员的ID
     */
    public void setStaffId(Long staffId) {
        this.staffId = staffId;
    }

    /**
     * 获取虹膜图片像数位深度
     *
     * @return img_depth - 虹膜图片像数位深度
     */
    public Integer getImgDepth() {
        return imgDepth;
    }

    /**
     * 设置虹膜图片像数位深度
     *
     * @param imgDepth 虹膜图片像数位深度
     */
    public void setImgDepth(Integer imgDepth) {
        this.imgDepth = imgDepth;
    }

    /**
     * 获取虹膜图像宽度
     *
     * @return img_width - 虹膜图像宽度
     */
    public Integer getImgWidth() {
        return imgWidth;
    }

    /**
     * 设置虹膜图像宽度
     *
     * @param imgWidth 虹膜图像宽度
     */
    public void setImgWidth(Integer imgWidth) {
        this.imgWidth = imgWidth;
    }

    /**
     * 获取虹膜图像高度
     *
     * @return img_height - 虹膜图像高度
     */
    public Integer getImgHeight() {
        return imgHeight;
    }

    /**
     * 设置虹膜图像高度
     *
     * @param imgHeight 虹膜图像高度
     */
    public void setImgHeight(Integer imgHeight) {
        this.imgHeight = imgHeight;
    }

    /**
     * 获取虹膜图像数据长度，字节为单位
     *
     * @return img_len - 虹膜图像数据长度，字节为单位
     */
    public Integer getImgLen() {
        return imgLen;
    }

    /**
     * 设置虹膜图像数据长度，字节为单位
     *
     * @param imgLen 虹膜图像数据长度，字节为单位
     */
    public void setImgLen(Integer imgLen) {
        this.imgLen = imgLen;
    }

    /**
     * 获取虹膜特征模板长度，字节单位
     *
     * @return feature_len - 虹膜特征模板长度，字节单位
     */
    public Integer getFeatureLen() {
        return featureLen;
    }

    /**
     * 设置虹膜特征模板长度，字节单位
     *
     * @param featureLen 虹膜特征模板长度，字节单位
     */
    public void setFeatureLen(Integer featureLen) {
        this.featureLen = featureLen;
    }

    /**
     * 获取虹膜算法名称
     *
     * @return alg_name - 虹膜算法名称
     */
    public String getAlgName() {
        return algName;
    }

    /**
     * 设置虹膜算法名称
     *
     * @param algName 虹膜算法名称
     */
    public void setAlgName(String algName) {
        this.algName = algName;
    }

    /**
     * 获取虹膜算法版本号
     *
     * @return alg_version - 虹膜算法版本号
     */
    public String getAlgVersion() {
        return algVersion;
    }

    /**
     * 设置虹膜算法版本号
     *
     * @param algVersion 虹膜算法版本号
     */
    public void setAlgVersion(String algVersion) {
        this.algVersion = algVersion;
    }

    /**
     * 获取创建时间
     *
     * @return gmt_create - 创建时间
     */
    public Date getGmtCreate() {
        return gmtCreate;
    }

    /**
     * 设置创建时间
     *
     * @param gmtCreate 创建时间
     */
    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    /**
     * 获取更新时间
     *
     * @return gmt_update - 更新时间
     */
    public Date getGmtUpdate() {
        return gmtUpdate;
    }

    /**
     * 设置更新时间
     *
     * @param gmtUpdate 更新时间
     */
    public void setGmtUpdate(Date gmtUpdate) {
        this.gmtUpdate = gmtUpdate;
    }

    /**
     * 获取图片数据
     *
     * @return img_data - 图片数据
     */
    public byte[] getImgData() {
        return imgData;
    }

    /**
     * 设置图片数据
     *
     * @param imgData 图片数据
     */
    public void setImgData(byte[] imgData) {
        this.imgData = imgData;
    }

    /**
     * 获取虹膜特征模板
     *
     * @return feature - 虹膜特征模板
     */
    public byte[] getFeature() {
        return feature;
    }

    /**
     * 设置虹膜特征模板
     *
     * @param feature 虹膜特征模板
     */
    public void setFeature(byte[] feature) {
        this.feature = feature;
    }
}