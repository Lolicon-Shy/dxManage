package com.classam.mapper;

import com.classam.entity.Student;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 宋欢
 * @since 2020-06-21
 */
@Mapper
public interface StudentMapper extends BaseMapper<Student> {

}
