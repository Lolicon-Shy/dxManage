package com.classam.service.impl;

import com.classam.comment.Output;
import com.classam.entity.Department;
import com.classam.mapper.DepartmentMapper;
import com.classam.service.IDepartmentService;
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
public class DepartmentServiceImpl extends ServiceImpl<DepartmentMapper, Department> implements IDepartmentService {

    @Override
    public Output check(Department department) {
        if (Objects.isNull(department.getDepartmentId())){
            return new Output(Output.STATUS_FAIL,"确少对应的系id参数");
        }

        if(Objects.isNull(department.getDepartmentName())){
            return new Output(Output.STATUS_FAIL,"缺少对应的系名称");
        }

        if (Objects.isNull(department.getDepartmentHead())){
            return new Output(Output.STATUS_FAIL,"缺少对应的系主任参数",null);
        }
        return null;
    }
}
