package com.lirun.sharebook.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lirun.sharebook.DAO.StudentsDAO;
import com.lirun.sharebook.service.StudentsService;
import com.lirun.sharebook.vo.Students;
@Service
public class StudentsServiceImpl implements StudentsService{
	@Autowired
	StudentsDAO studentsDAO;
	@Override
	public Students getStudentById(int id) {
		return studentsDAO.getStudentById(id);
	}

}
