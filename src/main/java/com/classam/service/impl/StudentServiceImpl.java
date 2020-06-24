package com.classam.service.impl;

import com.classam.comment.Output;
import com.classam.entity.Department;
import com.classam.entity.Student;
import com.classam.mapper.StudentMapper;
import com.classam.service.IStudentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 宋欢
 * @since 2020-06-24
 */
@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements IStudentService {


    @Override
    public Output check(Student student) {
        if (Objects.isNull(student.getSpecialtyId())){
            return new Output(Output.STATUS_FAIL,"请选择你的专业",null);
        }

        if (Objects.isNull(student.getName())){
            return new Output(Output.STATUS_FAIL,"请填写你的姓名",null);
        }

        if (Objects.isNull(student.getPassword())){
            return new Output(Output.STATUS_FAIL,"请填写你的密码",null);
        }
        return null;
    }
}
