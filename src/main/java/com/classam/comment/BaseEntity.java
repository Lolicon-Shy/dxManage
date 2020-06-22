package com.classam.comment;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.Version;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class BaseEntity {
    /**
     * 页码，从第几页开始
     */
    @TableField(exist = false)
    @JsonIgnore
    private Integer pageIndex;

    /**
     * 页数，每页显示多少条数据
     */
    @TableField(exist = false)
    @JsonIgnore
    private Integer pageSize;

    /**
     * 创建时间
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    @TableField(fill = FieldFill.INSERT)
    @JsonProperty("createTime")
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    @JsonProperty("updateTime")
    private LocalDateTime updateTime;

    /**
     * 逻辑删除
     */
    @TableLogic
    @JsonIgnore
    private Integer isDelete;

    /**
     * 乐观锁（版本号）
     */
    @Version
    @JsonIgnore
    private Integer version;
}
