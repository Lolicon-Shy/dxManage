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
@ApiModel(value="Checkclass对象", description="")
public class Checkclass extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    private Integer id;

    @ApiModelProperty(value = "学号")
    private Integer sId;

    @ApiModelProperty(value = "课程号")
    private Integer cid;

    @ApiModelProperty(value = "教师工号")
    private Integer tid;

    @ApiModelProperty(value = "分数")
    private Double score;


}
