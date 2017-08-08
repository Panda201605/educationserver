package com.linchuanedu.edu.service.service;

import com.linchuanedu.edu.common.model.DO.SubjectDO;
import com.linchuanedu.edu.common.model.DTO.GetSubjectDTO;
import com.linchuanedu.edu.common.model.DTO.AddSubjectInfoDTO;
import com.linchuanedu.edu.common.model.DTO.UpdateSubjectDTO;
import com.linchuanedu.edu.common.model.VO.SubjectInfoVO;
import com.linchuanedu.edu.common.util.TimeUtil;
import com.linchuanedu.edu.service.cache.SubjectCache;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by pansp on 2017-8-8.
 */
@Service
public class SubjectService {

    @Resource
    private SubjectCache subjectCache;

    public void addSubject(AddSubjectInfoDTO addSubjectInfoDTO){
        SubjectDO subjectDO = buildSubjectDO(addSubjectInfoDTO);
        subjectCache.addSubject(subjectDO);
    }

    public List<SubjectInfoVO> getSubject(GetSubjectDTO getSubjectDTO){
        SubjectDO subjectDO = new SubjectDO();
        subjectDO.setBookable(getSubjectDTO.getBookable());
        List<SubjectDO> listSubjectDO = subjectCache.getSubject(subjectDO);
        List<SubjectInfoVO> listSubjectInfoVO = new ArrayList<>();

        for(SubjectDO subject : listSubjectDO){
            SubjectInfoVO subjectInfoVO = buildSubjectInfoVO(subject);
            listSubjectInfoVO.add(subjectInfoVO);
        }

        return listSubjectInfoVO;
    }

    public void updateSubject(UpdateSubjectDTO updateSubjectDTO){
        SubjectDO subjectDO = buildSubjectDO(updateSubjectDTO);
        subjectCache.updateSubject(subjectDO);
    }


    private SubjectDO buildSubjectDO(AddSubjectInfoDTO addSubjectInfoDTO){
        SubjectDO subjectDO = new SubjectDO();
        subjectDO.setGrade(addSubjectInfoDTO.getGrade());
        subjectDO.setSubject(addSubjectInfoDTO.getSubject());
        subjectDO.setBookable(addSubjectInfoDTO.getBookable());
        subjectDO.setCreateBy(addSubjectInfoDTO.getUserId());
        subjectDO.setCreateTs(TimeUtil.getTimeStamp());
        return subjectDO;
    }

    private SubjectInfoVO buildSubjectInfoVO(SubjectDO subjectDO){
        SubjectInfoVO subjectInfoVO = new SubjectInfoVO();
        subjectInfoVO.setSubjectId(subjectDO.getSubjectId());
        subjectInfoVO.setGrade(subjectDO.getGrade());
        subjectInfoVO.setSubject(subjectDO.getSubject());
        subjectInfoVO.setBookable(subjectDO.getBookable());
        return subjectInfoVO;
    }

    private SubjectDO buildSubjectDO(UpdateSubjectDTO updateSubjectDTO){
        SubjectDO subjectDO = new SubjectDO();
        subjectDO.setSubjectId(updateSubjectDTO.getSubjectId());
        subjectDO.setGrade(updateSubjectDTO.getGrade());
        subjectDO.setSubject(updateSubjectDTO.getSubject());
        subjectDO.setBookable(updateSubjectDTO.getBookable());
        subjectDO.setModifyBy(updateSubjectDTO.getUserId());
        subjectDO.setModifyTs(TimeUtil.getTimeStamp());
        return subjectDO;
    }
}
