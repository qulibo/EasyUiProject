package cn.et.project.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


import cn.et.project.entity.Emp;
import cn.et.project.entity.Result;
import cn.et.project.service.EmpService;
import cn.et.project.utils.PageTools;



@Controller
public class EmpController {
	@Autowired
	EmpService service;
	
	@ResponseBody
	@RequestMapping(value="/queryEmp",method={RequestMethod.GET})
	public PageTools queryEmp(@RequestParam(required=false)Integer deptid, Integer page,Integer rows){
		return service.queryEmp(deptid, page, rows);
	}
	
	
	@ResponseBody
	@RequestMapping(value="/queryEmpByName",method={RequestMethod.GET})
	public PageTools queryEmpByName(@RequestParam(required=false)String ename, @RequestParam(required=false)Integer deptid, Integer page,Integer rows){
		return service.queryEmpByName(ename, deptid, page, rows);
	}
	
	
	@ResponseBody
	@RequestMapping(value="/emp/{id}",method={RequestMethod.DELETE})
	public Result deleteEmp(@PathVariable Integer id) throws Exception{
		Result res = new Result();
		try {
			service.deleteEmp(id);
			res.setCode(1);
		} catch (Exception e) {
			res.setCode(0);
			res.setMessage(e);
		}
		return res;
	}
	
	@ResponseBody
	@RequestMapping(value="/emp/{id}",method={RequestMethod.PUT})
	public Result udpateEmp(@PathVariable Integer id,Emp emp) throws Exception{
		emp.setId(id);
		Result res = new Result();
		res.setCode(1);
		try {
			service.updateEmp(emp);
		} catch (Exception e) {
			res.setCode(0);
			res.setMessage(e);
		}
		return res;
	}
	
	@ResponseBody
	@RequestMapping(value="/emp",method={RequestMethod.POST})
	public Result saveEmp(Emp emp) throws Exception{
		Result res = new Result();
		res.setCode(1);
		try {
			service.saveEmp(emp);
		} catch (Exception e) {
			res.setCode(0);
			res.setMessage(e);
		}
		return res;
	}
}
