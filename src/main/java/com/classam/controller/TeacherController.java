package com.classam.controller;


import com.classam.comment.Output;

import com.classam.entity.Teacher;
import com.classam.service.TeacherService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author 宋欢
 * @since 2020-06-21
 */
@ApiModel("教师控制类")
@RestController
@RequestMapping("/api/teacher")
public class TeacherController {
    @Autowired
    private TeacherService teacherService;

    @RequestMapping("/list")
    public Output list() {
        List<Teacher> list = this.teacherService.list();
        if (list.size() > 1) {
            return new Output(Output.STATUS_SUCCESS, "查询成功", list);
        }
        return new Output(Output.STATUS_FAIL, "没有数据", null);
    }

    @RequestMapping("/deleteById/{id}")
    public Output deleteById(@PathVariable("id") Integer id) {
        boolean success = this.teacherService.removeById(id);
        if (success) {
            return new Output(Output.STATUS_SUCCESS, "删除成功", true);
        }
        return new Output(Output.STATUS_FAIL, "删除失败", false);
    }

    @RequestMapping("/updateOrAdd")
    public Output updateOrAdd(@RequestBody Teacher teacher) {
        boolean success = this.teacherService.saveOrUpdate(teacher);
        if (success) {
            return new Output(Output.STATUS_SUCCESS, "修改或添加成功", true);
        }

        return new Output(Output.STATUS_FAIL, "修改或添加失败", false);
    }

    @RequestMapping("/update")
    public Output update(@RequestBody Teacher teacher) {
        boolean success = this.teacherService.updateById(teacher);
        if (success) {
            return new Output(Output.STATUS_SUCCESS, "修改成功", true);
        }

        return new Output(Output.STATUS_FAIL, "修改失败", false);
    }

    @RequestMapping("/add")
    public Output add(@RequestBody Teacher teacher) {
        boolean success = this.teacherService.save(teacher);
        if (success) {
            return new Output(Output.STATUS_SUCCESS, "修改成功", true);
        }

        return new Output(Output.STATUS_FAIL, "修改失败", false);
    }

}

