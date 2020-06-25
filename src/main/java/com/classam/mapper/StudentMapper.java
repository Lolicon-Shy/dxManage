package com.classam.mapper;

import com.classam.entity.Student;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 宋欢
 * @since 2020-06-24
 */
@Mapper
public interface StudentMapper extends BaseMapper<Student> {

    /**
     * 查询学生成绩信息
     * @return
     */
    @Select("SELECT s.s_id as '学号', s.`name` as '学生姓名' ,c.`name` as '科目',ch.score AS '分数'\n" +
            "FROM student s,checkclass ch,course c     \n" +
            "WHERE s.s_id = ch.s_id AND ch.cid = c.cid and s.s_id = #{sid}")
    List<Map<String,Object>> gradeInfo(Integer sid);

    /**
     * 查询学生选课信息
     * @return
     */
    @Select("SELECT s.s_id as '学号' ,s.`name` as '姓名' , c.`name` as '课程',c.credit as '学分',t.`name` as '老师'\n" +
            "FROM student s,checkclass ch,course c,teacher t\n" +
            "WHERE s.s_id = ch.s_id and ch.cid = c.cid and ch.tid = t.tid   and s.s_id = #{sid}")
    List<Map<String,Object>> selectStuCheck(Integer sid);

}
