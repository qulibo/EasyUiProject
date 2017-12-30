package cn.et.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.et.project.entity.Emp;
import cn.et.project.entity.TreeNode;
import cn.et.project.service.DeptService;


@Controller
public class DeptController {
	@Autowired
	DeptService service;
	@ResponseBody
	@RequestMapping("/queryDept")
	public List<TreeNode> queryStudent(Integer id){
		if(id==null){
			id=0;
		}
		return service.queryTreeNode(id);
	}
	@ResponseBody
	@RequestMapping("/queryEmp")
	public List<Emp> queryEmp(Integer id){
		return service.queryEmp(id);
	}
	
	
}
