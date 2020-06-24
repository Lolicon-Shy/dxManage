package com.classam.entity;

import com.classam.comment.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author 宋欢
 * @since 2020-06-24
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value="Department对象", description="")
public class Department extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "系号码")
    private Integer departmentId;

    @ApiModelProperty(value = "系名称")
    private String departmentName;

    @ApiModelProperty(value = "系主任")
    private String departmentHead;

    @ApiModelProperty(value = "联系方式")
    private String contact;

    @ApiModelProperty(value = "系介绍")
    private String departmentInfo;


}
