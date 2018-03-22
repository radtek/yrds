package com.yrds.iris.persist.model;

import java.util.Date;
import javax.persistence.*;

public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "staff_id")
    private String staffId;

    /**
     * 年龄
     */
    private Integer age;

    private String username;

    /**
     * 性别
     */
    private Integer sex;

    /**
     * 部门
     */
    @Column(name = "department_id")
    private Integer departmentId;

    private String email;

    private String password;

    /**
     * 虹膜
     */
    private Integer iris;

    /**
     * 人脸
     */
    private Integer face;

    /**
     * 指纹
     */
    private Integer finger;

    /**
     * 是否系统管理员
     */
    @Column(name = "is_system")
    private Integer isSystem;

    /**
     * 状态
     */
    private Integer status;

    @Column(name = "remember_token")
    private String rememberToken;

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "updated_at")
    private Date updatedAt;

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
     * @return staff_id
     */
    public String getStaffId() {
        return staffId;
    }

    /**
     * @param staffId
     */
    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }

    /**
     * 获取年龄
     *
     * @return age - 年龄
     */
    public Integer getAge() {
        return age;
    }

    /**
     * 设置年龄
     *
     * @param age 年龄
     */
    public void setAge(Integer age) {
        this.age = age;
    }

    /**
     * @return username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * 获取性别
     *
     * @return sex - 性别
     */
    public Integer getSex() {
        return sex;
    }

    /**
     * 设置性别
     *
     * @param sex 性别
     */
    public void setSex(Integer sex) {
        this.sex = sex;
    }

    /**
     * 获取部门
     *
     * @return department_id - 部门
     */
    public Integer getDepartmentId() {
        return departmentId;
    }

    /**
     * 设置部门
     *
     * @param departmentId 部门
     */
    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    /**
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 获取虹膜
     *
     * @return iris - 虹膜
     */
    public Integer getIris() {
        return iris;
    }

    /**
     * 设置虹膜
     *
     * @param iris 虹膜
     */
    public void setIris(Integer iris) {
        this.iris = iris;
    }

    /**
     * 获取人脸
     *
     * @return face - 人脸
     */
    public Integer getFace() {
        return face;
    }

    /**
     * 设置人脸
     *
     * @param face 人脸
     */
    public void setFace(Integer face) {
        this.face = face;
    }

    /**
     * 获取指纹
     *
     * @return finger - 指纹
     */
    public Integer getFinger() {
        return finger;
    }

    /**
     * 设置指纹
     *
     * @param finger 指纹
     */
    public void setFinger(Integer finger) {
        this.finger = finger;
    }

    /**
     * 获取是否系统管理员
     *
     * @return is_system - 是否系统管理员
     */
    public Integer getIsSystem() {
        return isSystem;
    }

    /**
     * 设置是否系统管理员
     *
     * @param isSystem 是否系统管理员
     */
    public void setIsSystem(Integer isSystem) {
        this.isSystem = isSystem;
    }

    /**
     * 获取状态
     *
     * @return status - 状态
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置状态
     *
     * @param status 状态
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * @return remember_token
     */
    public String getRememberToken() {
        return rememberToken;
    }

    /**
     * @param rememberToken
     */
    public void setRememberToken(String rememberToken) {
        this.rememberToken = rememberToken;
    }

    /**
     * @return created_at
     */
    public Date getCreatedAt() {
        return createdAt;
    }

    /**
     * @param createdAt
     */
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * @return updated_at
     */
    public Date getUpdatedAt() {
        return updatedAt;
    }

    /**
     * @param updatedAt
     */
    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
}