package com.classam.service;

import com.classam.comment.Output;
import com.classam.entity.Department;
import com.classam.entity.Specialty;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 宋欢
 * @since 2020-06-24
 */
public interface ISpecialtyService extends IService<Specialty> {
    Output check(Specialty specialty);
}
