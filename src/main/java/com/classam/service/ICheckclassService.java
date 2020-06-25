package com.classam.service;

import com.classam.comment.Output;
import com.classam.entity.Checkclass;
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
public interface ICheckclassService extends IService<Checkclass> {

    Output check(Checkclass checkclass);

}
