package com.classam.service.impl;

import com.classam.comment.Output;
import com.classam.entity.Course;
import com.classam.mapper.CourseMapper;
import com.classam.service.ICourseService;
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
public class CourseServiceImpl extends ServiceImpl<CourseMapper, Course> implements ICourseService {

    @Override
    public Output check(Course course) {
        if (Objects.isNull(course.getCid())){
            return new Output(Output.STATUS_FAIL,"缺少对应的Cid字段",null);
        }

        if (Objects.isNull(course.getPeriod())){
            return new Output(Output.STATUS_FAIL,"缺少对应的Period参数",null);
        }

        if (Objects.isNull(course.getSpecialtyId())){
            return new Output(Output.STATUS_FAIL,"缺少对应的SpecialtyId参数",null);
        }
        return null;
    }
}
