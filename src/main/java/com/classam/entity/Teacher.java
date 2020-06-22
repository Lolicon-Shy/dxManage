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
@ApiModel(value="Teacher对象", description="")
public class Teacher extends BaseEntity implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "教师唯一id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "教师姓名")
    private String name;

    @ApiModelProperty(value = "教师性别")
    private String sex;

    @ApiModelProperty(value = "教师所任科目")
    private String subject;

    @ApiModelProperty(value = "教师所属院部")
    private String scaddress;

    @ApiModelProperty(value = "教师所属专业")
    private String specialty;


}
