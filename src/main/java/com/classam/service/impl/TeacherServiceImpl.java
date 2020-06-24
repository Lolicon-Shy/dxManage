package com.classam.service.impl;

import com.classam.comment.Output;
import com.classam.entity.Department;
import com.classam.entity.Teacher;
import com.classam.mapper.TeacherMapper;
import com.classam.service.ITeacherService;
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
public class TeacherServiceImpl extends ServiceImpl<TeacherMapper, Teacher> implements ITeacherService {


    @Override
    public Output check(Teacher teacher) {
        if (Objects.isNull(teacher.getTid())){
            return new Output(Output.STATUS_FAIL,"缺少对应的教师编号信息",null);
        }

        if (Objects.isNull(teacher.getName())){
            return new Output(Output.STATUS_FAIL,"缺少教师姓名参数",null);
        }

        if (Objects.isNull(teacher.getSpecialtyId())){
            return new Output(Output.STATUS_FAIL,"缺少对应的专业id",null);
        }

        if (Objects.isNull(teacher.getDepartmentId())){
            return new Output(Output.STATUS_FAIL,"缺少对应的系号码",null);
        }

        return null;
    }
}
