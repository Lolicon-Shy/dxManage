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
@ApiModel(value="Course对象", description="")
public class Course extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "课程号码")
    private Integer cid;

    @ApiModelProperty(value = "学时")
    private String period;

    @ApiModelProperty(value = "学分")
    private String credit;

    @ApiModelProperty(value = "课程介绍")
    private Integer specialtyId;

    @ApiModelProperty(value = "课程信息")
    private String classInfo;


}
