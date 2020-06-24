package com.classam.service.impl;

import com.classam.comment.Output;
import com.classam.entity.Department;
import com.classam.entity.Specialty;
import com.classam.mapper.SpecialtyMapper;
import com.classam.service.ISpecialtyService;
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
public class SpecialtyServiceImpl extends ServiceImpl<SpecialtyMapper, Specialty> implements ISpecialtyService {


    @Override
    public Output check(Specialty specialty) {
        if (Objects.isNull(specialty.getSpecialtyId())){
            return new Output(Output.STATUS_FAIL,"缺少对应的专业id参数",null);
        }

        if (Objects.isNull(specialty.getSpecialtyName())){
            return new Output(Output.STATUS_FAIL,"缺少对应的专业名称字段",null);
        }

        if (Objects.isNull(specialty.getInstructor())){
            return new Output(Output.STATUS_FAIL,"缺少对应的辅导员参数",null);
        }
        return null;
    }
}
