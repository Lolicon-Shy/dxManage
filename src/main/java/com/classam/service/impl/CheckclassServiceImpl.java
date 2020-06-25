package com.classam.service.impl;

import com.classam.comment.Output;
import com.classam.entity.Checkclass;
import com.classam.mapper.CheckclassMapper;
import com.classam.service.ICheckclassService;
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
public class CheckclassServiceImpl extends ServiceImpl<CheckclassMapper, Checkclass> implements ICheckclassService {

    @Resource
    private CheckclassMapper checkclassMapper;

    @Override
    public Output check(Checkclass checkclass) {
        if (Objects.isNull(checkclass.getCid())){
            return new Output(Output.STATUS_FAIL,"缺少对应的Cid参数",null);
        }

        if (Objects.isNull(checkclass.getSId())){
            return new Output(Output.STATUS_FAIL,"缺少对应的Sid参数",null);
        }

        if (Objects.isNull(checkclass.getTid())){
            return new Output(Output.STATUS_FAIL,"缺少对应的Tid参数",null);
        }
      
        return null;
    }

}
