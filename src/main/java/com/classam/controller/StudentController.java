package com.classam.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.classam.comment.Output;
import com.classam.entity.Student;
import com.classam.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Objects;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author 宋欢
 * @since 2020-06-24
 */
@RestController
@RequestMapping("/api/student")
public class StudentController {
    @Autowired
    private IStudentService iStudentService;

    @PostMapping("/add")
    public Output add(@RequestBody Student student) {
        Output check = this.iStudentService.check(student);
        if (check != null) {
            return check;
        }

        boolean save = this.iStudentService.save(student);
        if (save) {
            return new Output(Output.STATUS_SUCCESS, "添加成功", student);
        }

        return new Output(Output.STATUS_FAIL, "添加失败", null);
    }

    @GetMapping("/delete/{id}")
    public Output delete(@PathVariable("id") Integer id) {
        if (Objects.isNull(id)) {
            return new Output(Output.STATUS_FAIL, "缺少对应的id", false);
        }
        boolean success = this.iStudentService.removeById(id);
        if (success) {
            return new Output(Output.STATUS_SUCCESS, "删除成功", true);
        }
        return new Output(Output.STATUS_FAIL, "删除失败", false);
    }

    @PostMapping("/update")
    public Output update(@RequestBody Student student) {
        if (Objects.isNull(student.getId())) {
            return new Output(Output.STATUS_FAIL, "缺少对应的id字段", false);
        }
        boolean success = this.iStudentService.updateById(student);
        if (success) {
            return new Output(Output.STATUS_SUCCESS, "修改成功", true);
        }
        return new Output(Output.STATUS_FAIL, "修改失败", false);
    }

    @PostMapping("/page/{pageIndex}/{pageSize}")
    public Output page(@PathVariable("pageIndex") Integer pageIndex, @PathVariable("pageSize") Integer pageSize) {
        int pageInd = pageIndex == null ? 1 : pageIndex;
        int pageSi = pageSize == null ? 10 : pageSize;

        Page<Student> studentPage = new Page<>();
        QueryWrapper<Student> studentQueryWrapper = new QueryWrapper<>();
        studentQueryWrapper
                .orderByDesc("create_time");
        Page<Student> page = this.iStudentService.page(studentPage, studentQueryWrapper);
        return new Output(Output.STATUS_SUCCESS, "查询成功", page);
    }

    @GetMapping("/list")
    public Output list() {
        List<Student> list = this.iStudentService.list();
        if (list.size() > 0) {
            return new Output(Output.STATUS_SUCCESS, "查询成功", list);
        }
        return new Output(Output.STATUS_FAIL, "没有数据", null);
    }

    /**
     * 按id查询学生成绩
     * @param sid
     * @return
     */
    @GetMapping("/gradeInfo/{sid}")
    public Output getGradeInfoById(@PathVariable("sid") Integer sid){
        if (Objects.isNull(sid)){
            return new Output(Output.STATUS_FAIL,"确少学生id参数",null);
        }
        Output output = this.iStudentService.gradeInfo(sid);
        if (output != null){
            return output;
        }

        return new Output(Output.STATUS_FAIL,"查询失败，没有数据",null);
    }

    /**
     * 查询学生选课信息
     * @param sid
     * @return
     */
    @GetMapping("/selectCheck/{sid}")
    public Output selectCheck(@PathVariable("sid")Integer sid){
        if (Objects.isNull(sid)){
            return new Output(Output.STATUS_FAIL,"请传入学号",null);
        }
        Output output = this.iStudentService.selectStuCheck(sid);
        if (output!=null){
            return output;
        }
        return new Output(Output.STATUS_FAIL,"没有此学生",null);
    }


}
