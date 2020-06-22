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
@ApiModel(value="Course对象", description="")
public class Course extends BaseEntity implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "课程唯一id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "课程类别")
    private String type;

    @ApiModelProperty(value = "课程院部")
    private String checksc;

    @ApiModelProperty(value = "课程专业")
    private String specialty;

    @ApiModelProperty(value = "教师号")
    private Integer tid;

    @ApiModelProperty(value = "上课地点")
    private String poclass;

    @ApiModelProperty(value = "课程介绍")
    private String classinf;

}
