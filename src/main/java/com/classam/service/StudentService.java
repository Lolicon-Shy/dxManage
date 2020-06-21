package com.classam.service;

import com.classam.comment.Output;
import com.classam.entity.Student;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 宋欢
 * @since 2020-06-21
 */
public interface StudentService extends IService<Student> {

    Output check(Student student);
}
