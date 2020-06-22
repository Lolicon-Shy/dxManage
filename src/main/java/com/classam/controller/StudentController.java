package com.classam.controller;


import com.alibaba.fastjson.JSON;
import com.classam.comment.Output;
import com.classam.entity.Student;
import com.classam.service.StudentService;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
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
@RestController
@RequestMapping("/api/student")
@EnableSwagger2
public class StudentController {

    private static Logger logger = LoggerFactory.getLogger("StudentController");

    @Autowired
    private StudentService studentService;

    @RequestMapping("/list")
    public Output list() {
        List<Student> list = this.studentService.list();
        if (list.size() > 1) {
            return new Output(Output.STATUS_SUCCESS, "查询成功", list);
        }
        return new Output(Output.STATUS_FAIL, "没有数据", null);
    }

    @RequestMapping("/deleteById/{id}")
    public Output deleteById(@PathVariable("id") Integer id) {
        logger.info("addStudent,id:" + JSON.toJSONString(id));
        boolean success = this.studentService.removeById(id);
        if (success) {
            return new Output(Output.STATUS_SUCCESS, "删除成功", true);
        }
        return new Output(Output.STATUS_FAIL, "删除失败", false);
    }

    @RequestMapping("/updateOrAdd")
    public Output updateOrAdd(@RequestBody Student student) {
        boolean success = this.studentService.saveOrUpdate(student);
        if (success) {
            return new Output(Output.STATUS_SUCCESS, "修改或删除成功", true);
        }

        return new Output(Output.STATUS_FAIL, "修改或删除失败", false);
    }

    @RequestMapping("/update")
    public Output update(@RequestBody Student student) {
        logger.info("updateStudent,student:" + JSON.toJSONString(student));
        boolean success = this.studentService.updateById(student);
        if (success) {
            return new Output(Output.STATUS_SUCCESS, "修改成功", true);
        }
        return new Output(Output.STATUS_FAIL, "修改失败", false);
    }

    @RequestMapping("/add")
    public Output add(@RequestBody Student student) {
        logger.info("addStudent,student:" + JSON.toJSONString(student));
        Output output = this.studentService.check(student);
        if (output != null) {
            return output;
        }
        boolean success = this.studentService.save(student);
        if (success) {
            return new Output(Output.STATUS_SUCCESS, "添加成功", true);
        }

        return new Output(Output.STATUS_FAIL, "添加失败", false);
    }

}

