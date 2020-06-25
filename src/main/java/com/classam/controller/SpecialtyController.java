package com.classam.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.classam.comment.Output;
import com.classam.entity.Specialty;
import com.classam.service.ISpecialtyService;
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
@RequestMapping("/api/specialty")
public class SpecialtyController {
    @Autowired
    private ISpecialtyService iSpecialtyService;

    @PostMapping("/add")
    public Output add(@RequestBody Specialty specialty){
        Output check = this.iSpecialtyService.check(specialty);
        if (check != null){
            return check;
        }

        boolean save = this.iSpecialtyService.save(specialty);
        if (save){
            return new Output(Output.STATUS_SUCCESS,"添加成功",specialty);
        }

        return new Output(Output.STATUS_FAIL,"添加失败",null);
    }

    @GetMapping("/delete/{id}")
    public Output delete(@PathVariable("id") Integer id) {
        if(Objects.isNull(id)){
            return new Output(Output.STATUS_FAIL,"缺少对应的id",false);
        }
        boolean success = this.iSpecialtyService.removeById(id);
        if (success){
            return new Output(Output.STATUS_SUCCESS,"删除成功",true);
        }
        return new Output(Output.STATUS_FAIL,"删除失败",false);
    }

    @PostMapping("/update")
    public Output update(@RequestBody Specialty specialty){
        if (Objects.isNull(specialty.getSpecialtyId())){
            return new Output(Output.STATUS_FAIL,"缺少对应的id字段",false);
        }
        boolean success = this.iSpecialtyService.updateById(specialty);
        if (success){
            return new Output(Output.STATUS_SUCCESS,"修改成功",true);
        }
        return new Output(Output.STATUS_FAIL,"修改失败",false);
    }

    @PostMapping("/page/{pageIndex}/{pageSize}")
    public Output page(@PathVariable("pageIndex") Integer pageIndex,@PathVariable("pageSize") Integer pageSize){
        int pageInd = pageIndex == null ? 1 : pageIndex;
        int pageSi = pageSize == null ? 10 : pageSize;

        Page<Specialty> specialtyPage = new Page<>();
        QueryWrapper<Specialty> specialtyQueryWrapper = new QueryWrapper<>();
        specialtyQueryWrapper
                .orderByDesc("create_time");
        Page<Specialty> page = this.iSpecialtyService.page(specialtyPage,specialtyQueryWrapper);
        return new Output(Output.STATUS_SUCCESS,"查询成功",page);
    }

    @GetMapping("/list")
    public Output list(){
        List<Specialty> list = this.iSpecialtyService.list();
        if (list.size()>0){
            return new Output(Output.STATUS_SUCCESS,"查询成功",list);
        }
        return new Output(Output.STATUS_FAIL,"没有数据",null);
    }
}
