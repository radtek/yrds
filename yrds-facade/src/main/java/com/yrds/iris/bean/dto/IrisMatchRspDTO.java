package com.yrds.iris.bean.dto;

import java.util.Date;

import com.kivi.framework.dto.BaseResDTO;

import lombok.Getter;
import lombok.Setter;

/**
 * 虹膜匹配响应
 * 
 * @author Eric
 *
 */
@Setter
@Getter
public class IrisMatchRspDTO extends BaseResDTO {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    private Long              id;

    /**
     * 被采集人员的ID
     */
    private Long              userId;

    /**
     * 匹配时间
     */
    private Date              matchTime;

}
