package com.linchuanedu.edu.service.cache;

import com.linchuanedu.edu.common.model.DO.SubjectDO;
import com.linchuanedu.edu.dao.ISubjectDao;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by pansp on 2017-8-8.
 */
@Component
public class SubjectCache {

    @Resource
    private ISubjectDao iSubjectDao;

    public void addSubject(SubjectDO subjectDO){
        iSubjectDao.addSubject(subjectDO);
    }

    public List<SubjectDO> getSubject(SubjectDO subjectDO){
        return iSubjectDao.getSubject(subjectDO);
    }

    public void updateSubject(SubjectDO subjectDO){
        iSubjectDao.updateSubject(subjectDO);
    }
}
