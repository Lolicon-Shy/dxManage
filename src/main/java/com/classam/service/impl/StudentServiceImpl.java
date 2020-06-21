package com.classam.service.impl;

import com.classam.comment.Output;
import com.classam.entity.Student;
import com.classam.mapper.StudentMapper;
import com.classam.service.StudentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 宋欢
 * @since 2020-06-21
 */
@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements StudentService {

    @Override
    public Output check(Student student) {
        if (student.getName()==null){
            return new Output(Output.STATUS_FAIL,"缺少name字段");
        }
        if (student.getSex()==null){
            return new Output(Output.STATUS_FAIL,"缺少sex字段");
        }
        if (student.getSpecialty()==null){
            return new Output(Output.STATUS_FAIL,"缺少specialty字段");
        }
        if (student.getPassword()==null){
            return new Output(Output.STATUS_FAIL,"缺少password字段");
        }
        return null;
    }
}
