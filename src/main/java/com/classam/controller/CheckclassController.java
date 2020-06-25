package com.classam.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.classam.comment.Output;
import com.classam.entity.Checkclass;
import com.classam.service.ICheckclassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Objects;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 宋欢
 * @since 2020-06-24
 */
@RestController
@RequestMapping("/api/checkclass")
public class CheckclassController {

    @Autowired
    private ICheckclassService iCheckclassService;

    @PostMapping("/add")
    public Output add(@RequestBody Checkclass checkclass){
        Output output = this.iCheckclassService.check(checkclass);
        if (output != null){
            return output;
        }

        boolean success = this.iCheckclassService.save(checkclass);
        if (success){
            return new Output(Output.STATUS_SUCCESS,"添加成功",null);
        }
        return new Output(Output.STATUS_FAIL,"添加失败",null);
    }

    @GetMapping("/delete/{id}")
    public Output delete(@PathVariable("id") Integer id) {
        if(Objects.isNull(id)){
            return new Output(Output.STATUS_FAIL,"缺少对应的id",false);
        }
        boolean success = this.iCheckclassService.removeById(id);
        if (success){
            return new Output(Output.STATUS_SUCCESS,"删除成功",true);
        }
        return new Output(Output.STATUS_FAIL,"删除失败",false);
    }

    @PostMapping("/update")
    public Output update(@RequestBody Checkclass checkclass){
        if (Objects.isNull(checkclass.getId())){
            return new Output(Output.STATUS_FAIL,"却晒对应的id字段",false);
        }

        boolean success = this.iCheckclassService.updateById(checkclass);
        if (success){
            return new Output(Output.STATUS_SUCCESS,"修改成功",true);
        }
        return new Output(Output.STATUS_FAIL,"修改失败",false);
    }

    @PostMapping("/page/{pageIndex}/{pageSize}")
    public Output page(@PathVariable("pageIndex") Integer pageIndex,@PathVariable("pageSize") Integer pageSize){
        int pageInd = pageIndex == null ? 1 : pageIndex;
        int pageSi = pageSize == null ? 10 : pageSize;

        Page<Checkclass> checkclassPage = new Page<>();
        QueryWrapper<Checkclass> checkclassQueryWrapper = new QueryWrapper<>();
        checkclassQueryWrapper
                .orderByDesc("create_time");
        Page<Checkclass> page = this.iCheckclassService.page(checkclassPage,checkclassQueryWrapper);
        return new Output(Output.STATUS_SUCCESS,"查询成功",page);
    }

    @GetMapping("/list")
    public Output list(){
        List<Checkclass> list = this.iCheckclassService.list();
        if (list.size()>0){
            return new Output(Output.STATUS_SUCCESS,"查询成功",list);
        }
        return new Output(Output.STATUS_FAIL,"没有数据",null);
    }

}
