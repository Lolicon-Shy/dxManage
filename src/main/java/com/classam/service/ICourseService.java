package com.classam.service;

import com.classam.comment.Output;
import com.classam.entity.Course;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 宋欢
 * @since 2020-06-24
 */
public interface ICourseService extends IService<Course> {

    Output check(Course course);
}
