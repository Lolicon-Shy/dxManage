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
@ApiModel(value="Teacher对象", description="")
public class Teacher extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键id")
    private Integer id;

    @ApiModelProperty(value = "教师工号")
    private Integer tid;

    @ApiModelProperty(value = "教师姓名")
    private String name;

    @ApiModelProperty(value = "教师密码")
    private String password;

    @ApiModelProperty(value = "教师性别")
    private String sex;

    @ApiModelProperty(value = "系号码")
    private Integer departmentId;

    @ApiModelProperty(value = "专业号")
    private Integer specialtyId;


}
