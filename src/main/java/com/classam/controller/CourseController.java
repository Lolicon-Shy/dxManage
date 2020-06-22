package com.classam.controller;


import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.conditions.update.UpdateChainWrapper;
import com.classam.comment.Output;
import com.classam.entity.Course;
import com.classam.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author 宋欢
 * @since 2020-06-21
 */
@RestController
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @RequestMapping("/list")
    public Output list() {
        List<Course> list = this.courseService.list();
        if (list.size() > 1) {
            return new Output(Output.STATUS_SUCCESS, "查询成功", list);
        }
        return new Output(Output.STATUS_FAIL, "没有数据", null);
    }

    @RequestMapping("/deleteById/{id}")
    public Output deleteById(@PathVariable("id") Integer id) {
        boolean success = this.courseService.removeById(id);
        if (success) {
            return new Output(Output.STATUS_SUCCESS, "删除成功", true);
        }
        return new Output(Output.STATUS_FAIL, "删除失败", false);
    }

    @RequestMapping("/updateOrAdd")
    public Output updateOrAdd(@RequestBody Course course) {
        boolean success = this.courseService.saveOrUpdate(course);
        if (success) {
            return new Output(Output.STATUS_SUCCESS, "修改或删除成功", true);
        }

        return new Output(Output.STATUS_FAIL, "修改或删除失败", false);
    }

    @RequestMapping("/update")
    public Output update(@RequestBody Course course) {
        boolean success = this.courseService.updateById(course);
        if (success) {
            return new Output(Output.STATUS_SUCCESS, "修改成功", true);
        }

        return new Output(Output.STATUS_FAIL, "修改失败", false);
    }

    @RequestMapping("/add")
    public Output add(@RequestBody Course course) {
        boolean success = this.courseService.save(course);
        if (success) {
            return new Output(Output.STATUS_SUCCESS, "修改成功", true);
        }
        return new Output(Output.STATUS_FAIL, "修改失败", false);
    }


}

