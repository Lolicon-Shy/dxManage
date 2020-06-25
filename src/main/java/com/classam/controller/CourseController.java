package com.classam.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.classam.comment.Output;
import com.classam.entity.Course;
import com.classam.service.ICourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
@RequestMapping("/api/course")
public class CourseController {

    @Autowired
    private ICourseService iCourseService;

    @PostMapping("/add")
    public Output add(@RequestBody Course course){
        Output check = this.iCourseService.check(course);
        if (check != null){
            return check;
        }

        boolean save = this.iCourseService.save(course);
        if (save){
            return new Output(Output.STATUS_SUCCESS,"添加成功",course);
        }

        return new Output(Output.STATUS_FAIL,"添加失败",null);
    }

    @GetMapping("/delete/{id}")
    public Output delete(@PathVariable("id") Integer id) {
        if(Objects.isNull(id)){
            return new Output(Output.STATUS_FAIL,"缺少对应的id",false);
        }
        boolean success = this.iCourseService.removeById(id);
        if (success){
            return new Output(Output.STATUS_SUCCESS,"删除成功",true);
        }
        return new Output(Output.STATUS_FAIL,"删除失败",false);
    }

    @PostMapping("/update")
    public Output update(@RequestBody Course course){
        if (Objects.isNull(course.getId())){
            return new Output(Output.STATUS_FAIL,"缺少对应的id字段",false);
        }

        boolean success = this.iCourseService.updateById(course);
        if (success){
            return new Output(Output.STATUS_SUCCESS,"修改成功",true);
        }
        return new Output(Output.STATUS_FAIL,"修改失败",false);
    }

    @PostMapping("/page/{pageIndex}/{pageSize}")
    public Output page(@PathVariable("pageIndex") Integer pageIndex,@PathVariable("pageSize") Integer pageSize){
        int pageInd = pageIndex == null ? 1 : pageIndex;
        int pageSi = pageSize == null ? 10 : pageSize;

        Page<Course> coursePage = new Page<>();
        QueryWrapper<Course> courseQueryWrapper = new QueryWrapper<>();
        courseQueryWrapper
                .orderByDesc("create_time");
        Page<Course> page = this.iCourseService.page(coursePage,courseQueryWrapper);
        return new Output(Output.STATUS_SUCCESS,"查询成功",page);
    }

    @GetMapping("/list")
    public Output list(){
        List<Course> list = this.iCourseService.list();
        if (list.size()>0){
            return new Output(Output.STATUS_SUCCESS,"查询成功",list);
        }
        return new Output(Output.STATUS_FAIL,"没有数据",null);
    }

    @PostMapping("/selectByName/{name}")
    public Output selectByName(@PathVariable("name") String name){
        Map<String, Object> stringObjectHashMap = new HashMap<>();
        stringObjectHashMap.put("name",name);
        List<Course> courses = this.iCourseService.listByMap(stringObjectHashMap);
        if (courses.size()>0){
            return new Output(Output.STATUS_SUCCESS,"查询成功",courses);
        }

        return new Output(Output.STATUS_FAIL,"没有这个课",null);
    }

}
