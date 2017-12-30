package cn.et.project.service;

import java.util.List;

import cn.et.project.entity.Emp;
import cn.et.project.entity.TreeNode;

public interface DeptService {

	/* (non-Javadoc)
	 * @see cn.et.food.service.impl.StudentService#queryStudent(java.lang.String)
	 */
	public abstract List<TreeNode> queryTreeNode(Integer pid);
	
	public List<Emp> queryEmp(Integer id);

}