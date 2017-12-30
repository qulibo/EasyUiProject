package cn.et.project.service;

import cn.et.project.entity.Emp;
import cn.et.project.utils.PageTools;

public interface EmpService {
	public abstract PageTools queryEmpByName(String ename, Integer deptid, Integer page, Integer rows);
	
	public abstract PageTools queryEmp(Integer deptid, Integer page,
			Integer rows);

	public abstract void saveEmp(Emp emp);

	public abstract void deleteEmp(Integer id);

	public abstract void updateEmp(Emp emp);

}