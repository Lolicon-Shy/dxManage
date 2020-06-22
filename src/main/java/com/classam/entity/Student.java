package com.classam.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.Version;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

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
 * @since 2020-06-21
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="Student对象", description="")
public class Student extends BaseEntity implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "学生唯一id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "学生姓名")
    private String name;

    @ApiModelProperty(value = "学生性别")
    private String sex;

    @ApiModelProperty(value = "学生地址")
    private String address;

    @ApiModelProperty(value = "学生专业")
    private String specialty;

    @ApiModelProperty(value = "学生密码")
    private String password;

}
