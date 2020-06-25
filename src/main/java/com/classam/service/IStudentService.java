package com.classam.service;

import com.classam.comment.Output;
import com.classam.entity.Department;
import com.classam.entity.Student;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 宋欢
 * @since 2020-06-24
 */
public interface IStudentService extends IService<Student> {
    Output check(Student student);

    Output gradeInfo(Integer sid);

    Output selectStuCheck(Integer sid);
}
