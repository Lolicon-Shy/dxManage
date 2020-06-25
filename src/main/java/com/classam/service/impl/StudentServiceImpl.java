package com.classam.service.impl;

import com.classam.comment.Output;
import com.classam.entity.Department;
import com.classam.entity.Student;
import com.classam.mapper.StudentMapper;
import com.classam.service.IStudentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
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

    @Resource
    private StudentMapper studentMapper;

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

    @Override
    public Output gradeInfo(Integer sid) {

        List<Map<String, Object>> maps = this.studentMapper.gradeInfo(sid);
        if (maps.size()>0){
            return new Output(Output.STATUS_SUCCESS,"查询成功",maps);
        }
        return null;
    }

    @Override
    public Output selectStuCheck(Integer sid) {
        List<Map<String, Object>> maps = this.studentMapper.selectStuCheck(sid);
        if (maps.size()>0){
            return new Output(Output.STATUS_SUCCESS,"查询成功",maps);
        }

        return new Output(Output.STATUS_FAIL,"查询失败，没有数据",null);
    }


}
