package com.classam.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.classam.comment.Output;
import com.classam.entity.Department;
import com.classam.service.IDepartmentService;
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
@RequestMapping("/api/department")
public class DepartmentController {

    @Autowired
    private IDepartmentService iDepartmentService;

    @PostMapping("/add")
    public Output add(@RequestBody Department department){
        Output check = this.iDepartmentService.check(department);
        if (check != null){
            return check;
        }

        boolean save = this.iDepartmentService.save(department);
        if (save){
            return new Output(Output.STATUS_SUCCESS,"添加成功",department);
        }

        return new Output(Output.STATUS_FAIL,"添加失败",null);
    }

    @GetMapping("/delete/{id}")
    public Output delete(@PathVariable("id") Integer id) {
        if(Objects.isNull(id)){
            return new Output(Output.STATUS_FAIL,"缺少对应的id",false);
        }
        boolean success = this.iDepartmentService.removeById(id);
        if (success){
            return new Output(Output.STATUS_SUCCESS,"删除成功",true);
        }
        return new Output(Output.STATUS_FAIL,"删除失败",false);
    }

    @PostMapping("/update")
    public Output update(@RequestBody Department department){
        if (Objects.isNull(department.getDepartmentId())){
            return new Output(Output.STATUS_FAIL,"缺少对应的id字段",false);
        }
        boolean success = this.iDepartmentService.updateById(department);
        if (success){
            return new Output(Output.STATUS_SUCCESS,"修改成功",true);
        }
        return new Output(Output.STATUS_FAIL,"修改失败",false);
    }

    @PostMapping("/page/{pageIndex}/{pageSize}")
    public Output page(@PathVariable("pageIndex") Integer pageIndex,@PathVariable("pageSize") Integer pageSize){
        int pageInd = pageIndex == null ? 1 : pageIndex;
        int pageSi = pageSize == null ? 10 : pageSize;

        Page<Department> departmentPage = new Page<>(pageInd,pageSi);
        QueryWrapper<Department> departmentQueryWrapper = new QueryWrapper<>();
        departmentQueryWrapper
                .orderByDesc("create_time");
        Page<Department> page = this.iDepartmentService.page(departmentPage,departmentQueryWrapper);
        return new Output(Output.STATUS_SUCCESS,"查询成功",page);
    }

    @GetMapping("/list")
    public Output list(){
        List<Department> list = this.iDepartmentService.list();
        if (list.size()>0){
            return new Output(Output.STATUS_SUCCESS,"查询成功",list);
        }
        return new Output(Output.STATUS_FAIL,"没有数据",null);
    }

}
