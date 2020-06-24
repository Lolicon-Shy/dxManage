package com.classam.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.classam.comment.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableId;
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
@ApiModel(value="Admin对象", description="")
public class Admin extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "管理员工号")
    private Integer aid;

    @ApiModelProperty(value = "管理员姓名")
    private String name;

    @ApiModelProperty(value = "性别")
    private String sex;

    @ApiModelProperty(value = "管理员密码")
    private String password;


}
