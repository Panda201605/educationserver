package com.linchuanedu.edu.dao;

import com.linchuanedu.edu.common.model.DO.SubjectDO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by pansp on 2017-8-8.
 */
@Mapper
@Component(value = "iSubjectDao")
public interface ISubjectDao {
    //添加学科
    void addSubject(SubjectDO subjectDO);
    //获取学科信息
    List<SubjectDO> getSubject(SubjectDO subjectDO);
    //修改学科信息
    void updateSubject(SubjectDO subjectDO);
}
