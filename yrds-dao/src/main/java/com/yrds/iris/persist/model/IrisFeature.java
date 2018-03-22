package com.yrds.iris.persist.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "iris_feature")
public class IrisFeature {
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
    @Column(name = "user_id")
    private Long userId;

    /**
     * 虹膜图片像数位深度
     */
    @Column(name = "img_depth")
    private Integer imgDepth;

    /**
     * 左眼虹膜图像宽度
     */
    @Column(name = "img_l_width")
    private Integer imgLWidth;

    /**
     * 左眼虹膜图像高度
     */
    @Column(name = "img_l_height")
    private Integer imgLHeight;

    /**
     * 左眼虹膜图像数据长度，字节为单位
     */
    @Column(name = "img_l_len")
    private Integer imgLLen;

    /**
     * 左眼虹膜特征模板长度，字节单位
     */
    @Column(name = "feature_l_len")
    private Integer featureLLen;

    /**
     * 右眼虹膜图像宽度
     */
    @Column(name = "img_r_width")
    private Integer imgRWidth;

    /**
     * 右眼虹膜图像高度
     */
    @Column(name = "img_r_height")
    private Integer imgRHeight;

    /**
     * 右眼虹膜图像数据长度，字节为单位
     */
    @Column(name = "img_r_len")
    private Integer imgRLen;

    /**
     * 右眼虹膜特征模板长度，字节单位
     */
    @Column(name = "feature_r_len")
    private Integer featureRLen;

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
     * 识别时间
     */
    @Column(name = "match_time")
    private Date matchTime;

    /**
     * 匹配次数
     */
    @Column(name = "match_count")
    private Long matchCount;

    /**
     * 状态，0：有效，1：锁定，2：无效
     */
    private Integer status;

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
     * 左眼图片数据
     */
    @Column(name = "img_l_data")
    private byte[] imgLData;

    /**
     * 左眼虹膜特征模板
     */
    @Column(name = "feature_l_data")
    private byte[] featureLData;

    /**
     * 右眼图片数据
     */
    @Column(name = "img_r_data")
    private byte[] imgRData;

    /**
     * 右眼虹膜特征模板
     */
    @Column(name = "feature_r_data")
    private byte[] featureRData;

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
     * @return user_id - 被采集人员的ID
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * 设置被采集人员的ID
     *
     * @param userId 被采集人员的ID
     */
    public void setUserId(Long userId) {
        this.userId = userId;
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
     * 获取左眼虹膜图像宽度
     *
     * @return img_l_width - 左眼虹膜图像宽度
     */
    public Integer getImgLWidth() {
        return imgLWidth;
    }

    /**
     * 设置左眼虹膜图像宽度
     *
     * @param imgLWidth 左眼虹膜图像宽度
     */
    public void setImgLWidth(Integer imgLWidth) {
        this.imgLWidth = imgLWidth;
    }

    /**
     * 获取左眼虹膜图像高度
     *
     * @return img_l_height - 左眼虹膜图像高度
     */
    public Integer getImgLHeight() {
        return imgLHeight;
    }

    /**
     * 设置左眼虹膜图像高度
     *
     * @param imgLHeight 左眼虹膜图像高度
     */
    public void setImgLHeight(Integer imgLHeight) {
        this.imgLHeight = imgLHeight;
    }

    /**
     * 获取左眼虹膜图像数据长度，字节为单位
     *
     * @return img_l_len - 左眼虹膜图像数据长度，字节为单位
     */
    public Integer getImgLLen() {
        return imgLLen;
    }

    /**
     * 设置左眼虹膜图像数据长度，字节为单位
     *
     * @param imgLLen 左眼虹膜图像数据长度，字节为单位
     */
    public void setImgLLen(Integer imgLLen) {
        this.imgLLen = imgLLen;
    }

    /**
     * 获取左眼虹膜特征模板长度，字节单位
     *
     * @return feature_l_len - 左眼虹膜特征模板长度，字节单位
     */
    public Integer getFeatureLLen() {
        return featureLLen;
    }

    /**
     * 设置左眼虹膜特征模板长度，字节单位
     *
     * @param featureLLen 左眼虹膜特征模板长度，字节单位
     */
    public void setFeatureLLen(Integer featureLLen) {
        this.featureLLen = featureLLen;
    }

    /**
     * 获取右眼虹膜图像宽度
     *
     * @return img_r_width - 右眼虹膜图像宽度
     */
    public Integer getImgRWidth() {
        return imgRWidth;
    }

    /**
     * 设置右眼虹膜图像宽度
     *
     * @param imgRWidth 右眼虹膜图像宽度
     */
    public void setImgRWidth(Integer imgRWidth) {
        this.imgRWidth = imgRWidth;
    }

    /**
     * 获取右眼虹膜图像高度
     *
     * @return img_r_height - 右眼虹膜图像高度
     */
    public Integer getImgRHeight() {
        return imgRHeight;
    }

    /**
     * 设置右眼虹膜图像高度
     *
     * @param imgRHeight 右眼虹膜图像高度
     */
    public void setImgRHeight(Integer imgRHeight) {
        this.imgRHeight = imgRHeight;
    }

    /**
     * 获取右眼虹膜图像数据长度，字节为单位
     *
     * @return img_r_len - 右眼虹膜图像数据长度，字节为单位
     */
    public Integer getImgRLen() {
        return imgRLen;
    }

    /**
     * 设置右眼虹膜图像数据长度，字节为单位
     *
     * @param imgRLen 右眼虹膜图像数据长度，字节为单位
     */
    public void setImgRLen(Integer imgRLen) {
        this.imgRLen = imgRLen;
    }

    /**
     * 获取右眼虹膜特征模板长度，字节单位
     *
     * @return feature_r_len - 右眼虹膜特征模板长度，字节单位
     */
    public Integer getFeatureRLen() {
        return featureRLen;
    }

    /**
     * 设置右眼虹膜特征模板长度，字节单位
     *
     * @param featureRLen 右眼虹膜特征模板长度，字节单位
     */
    public void setFeatureRLen(Integer featureRLen) {
        this.featureRLen = featureRLen;
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
     * 获取识别时间
     *
     * @return match_time - 识别时间
     */
    public Date getMatchTime() {
        return matchTime;
    }

    /**
     * 设置识别时间
     *
     * @param matchTime 识别时间
     */
    public void setMatchTime(Date matchTime) {
        this.matchTime = matchTime;
    }

    /**
     * 获取匹配次数
     *
     * @return match_count - 匹配次数
     */
    public Long getMatchCount() {
        return matchCount;
    }

    /**
     * 设置匹配次数
     *
     * @param matchCount 匹配次数
     */
    public void setMatchCount(Long matchCount) {
        this.matchCount = matchCount;
    }

    /**
     * 获取状态，0：有效，1：锁定，2：无效
     *
     * @return status - 状态，0：有效，1：锁定，2：无效
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置状态，0：有效，1：锁定，2：无效
     *
     * @param status 状态，0：有效，1：锁定，2：无效
     */
    public void setStatus(Integer status) {
        this.status = status;
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
     * 获取左眼图片数据
     *
     * @return img_l_data - 左眼图片数据
     */
    public byte[] getImgLData() {
        return imgLData;
    }

    /**
     * 设置左眼图片数据
     *
     * @param imgLData 左眼图片数据
     */
    public void setImgLData(byte[] imgLData) {
        this.imgLData = imgLData;
    }

    /**
     * 获取左眼虹膜特征模板
     *
     * @return feature_l_data - 左眼虹膜特征模板
     */
    public byte[] getFeatureLData() {
        return featureLData;
    }

    /**
     * 设置左眼虹膜特征模板
     *
     * @param featureLData 左眼虹膜特征模板
     */
    public void setFeatureLData(byte[] featureLData) {
        this.featureLData = featureLData;
    }

    /**
     * 获取右眼图片数据
     *
     * @return img_r_data - 右眼图片数据
     */
    public byte[] getImgRData() {
        return imgRData;
    }

    /**
     * 设置右眼图片数据
     *
     * @param imgRData 右眼图片数据
     */
    public void setImgRData(byte[] imgRData) {
        this.imgRData = imgRData;
    }

    /**
     * 获取右眼虹膜特征模板
     *
     * @return feature_r_data - 右眼虹膜特征模板
     */
    public byte[] getFeatureRData() {
        return featureRData;
    }

    /**
     * 设置右眼虹膜特征模板
     *
     * @param featureRData 右眼虹膜特征模板
     */
    public void setFeatureRData(byte[] featureRData) {
        this.featureRData = featureRData;
    }
}