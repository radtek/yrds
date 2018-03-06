package com.yrds.persist.model;

import java.util.Date;
import javax.persistence.*;

public class Attendances {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 员工id
     */
    @Column(name = "staff_id")
    private Long staffId;

    /**
     * 员工名称
     */
    @Column(name = "staff_name")
    private String staffName;

    /**
     * 考勤日期
     */
    private Date date;

    /**
     * 上班时间
     */
    private String atime;

    /**
     * 下班时间
     */
    private String ptime;

    /**
     * 0：请假 1：正常
     */
    private Integer status;

    /**
     * 设备ID
     */
    @Column(name = "device_id")
    private Long deviceId;

    /**
     * 设备类型：00：指纹，01：虹膜
     */
    @Column(name = "device_type")
    private String deviceType;

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
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取员工id
     *
     * @return staff_id - 员工id
     */
    public Long getStaffId() {
        return staffId;
    }

    /**
     * 设置员工id
     *
     * @param staffId 员工id
     */
    public void setStaffId(Long staffId) {
        this.staffId = staffId;
    }

    /**
     * 获取员工名称
     *
     * @return staff_name - 员工名称
     */
    public String getStaffName() {
        return staffName;
    }

    /**
     * 设置员工名称
     *
     * @param staffName 员工名称
     */
    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    /**
     * 获取考勤日期
     *
     * @return date - 考勤日期
     */
    public Date getDate() {
        return date;
    }

    /**
     * 设置考勤日期
     *
     * @param date 考勤日期
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * 获取上班时间
     *
     * @return atime - 上班时间
     */
    public String getAtime() {
        return atime;
    }

    /**
     * 设置上班时间
     *
     * @param atime 上班时间
     */
    public void setAtime(String atime) {
        this.atime = atime;
    }

    /**
     * 获取下班时间
     *
     * @return ptime - 下班时间
     */
    public String getPtime() {
        return ptime;
    }

    /**
     * 设置下班时间
     *
     * @param ptime 下班时间
     */
    public void setPtime(String ptime) {
        this.ptime = ptime;
    }

    /**
     * 获取0：请假 1：正常
     *
     * @return status - 0：请假 1：正常
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置0：请假 1：正常
     *
     * @param status 0：请假 1：正常
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 获取设备ID
     *
     * @return device_id - 设备ID
     */
    public Long getDeviceId() {
        return deviceId;
    }

    /**
     * 设置设备ID
     *
     * @param deviceId 设备ID
     */
    public void setDeviceId(Long deviceId) {
        this.deviceId = deviceId;
    }

    /**
     * 获取设备类型：00：指纹，01：虹膜
     *
     * @return device_type - 设备类型：00：指纹，01：虹膜
     */
    public String getDeviceType() {
        return deviceType;
    }

    /**
     * 设置设备类型：00：指纹，01：虹膜
     *
     * @param deviceType 设备类型：00：指纹，01：虹膜
     */
    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
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
}