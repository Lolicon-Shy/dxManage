package com.classam.service.impl;

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

}
