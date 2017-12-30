package cn.et.project.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.et.project.dao.DeptMapper;
import cn.et.project.dao.EmpMapper;
import cn.et.project.entity.Dept;
import cn.et.project.entity.DeptExample;
import cn.et.project.entity.Emp;
import cn.et.project.entity.EmpExample;
import cn.et.project.entity.TreeNode;
import cn.et.project.service.DeptService;


@Service
public class DeptServiceImpl implements DeptService {
	@Autowired
	DeptMapper sm;
	@Autowired
	EmpMapper sm1;
	/* (non-Javadoc)
	 * @see cn.et.food.service.impl.StudentService#queryStudent(java.lang.String)
	 */
	/* (non-Javadoc)
	 * @see cn.et.food.service.impl.DeptService#queryTreeNode(java.lang.Integer)
	 */
	public List<TreeNode> queryTreeNode(Integer pid){
	
		DeptExample se=new DeptExample();
		se.createCriteria().andPidEqualTo(pid);
		List<Dept> dept=sm.selectByExample(se);
		List<TreeNode> deptList=new ArrayList<TreeNode>();
		for(Dept d:dept){
			TreeNode tn=new TreeNode();
			tn.setId(d.getDid());
			tn.setText(d.getDname());
			//判断当前节点下是否还存在子节点
			if(queryTreeNode(d.getDid()).size()==0){
				tn.setState("open");
			}
			deptList.add(tn);
		}
		return deptList;
	}
	public List<Emp> queryEmp(Integer id){
		EmpExample ee=new EmpExample();
		if(id!=null)
			ee.createCriteria().andDeptidEqualTo(id);
		return sm1.selectByExample(ee);
	}
	
}
