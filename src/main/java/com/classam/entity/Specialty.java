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
@ApiModel(value="Specialty对象", description="")
public class Specialty extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "专业号码")
    private Integer specialtyId;

    @ApiModelProperty(value = "系号码")
    private Integer departmentId;

    @ApiModelProperty(value = "专业名称")
    private String specialtyName;

    @ApiModelProperty(value = "辅导员")
    private String instructor;

    @ApiModelProperty(value = "联系方式")
    private String contact;

    @ApiModelProperty(value = "专业介绍")
    private String specialty;


}
