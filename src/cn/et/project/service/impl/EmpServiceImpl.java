package cn.et.project.service.impl;


import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.et.project.dao.EmpMapper;
import cn.et.project.entity.Emp;
import cn.et.project.entity.EmpExample;
import cn.et.project.entity.EmpExample.Criteria;
import cn.et.project.service.EmpService;
import cn.et.project.utils.PageTools;



@Service
public class EmpServiceImpl implements EmpService {
	@Autowired
	EmpMapper em;
	/* (non-Javadoc)
	 * @see cn.et.service.impl.EmpService#queryFood(java.lang.Integer, java.lang.Integer, java.lang.Integer)
	 */
	public PageTools queryEmp(Integer deptid, Integer page, Integer rows) {
		EmpExample ep = new EmpExample();
		if(deptid!=null) {
			ep.createCriteria().andDeptidEqualTo(deptid);
		}
		int total = (int)em.countByExample(ep);
		PageTools pts = new PageTools(page, total, rows);
		RowBounds rbs = new RowBounds(pts.getStartIndex()-1, rows);
		List<Emp> empList = em.selectByExampleWithRowbounds(ep, rbs);
		pts.setRows(empList);
		return pts;
	}
	public PageTools queryEmpByName(String ename, Integer deptid, Integer page, Integer rows) {
		EmpExample ep = new EmpExample();
		Criteria c = ep.createCriteria();
		if(ename==null) {
			ename="";
		}
		if(deptid!=null){
			c.andDeptidEqualTo(deptid);
		}
		c.andEnameLike("%"+ename+"%");
		int total = (int)em.countByExample(ep);
		PageTools pts = new PageTools(page, total, rows);
		RowBounds rbs = new RowBounds(pts.getStartIndex()-1, rows);
		List<Emp> empList = em.selectByExampleWithRowbounds(ep, rbs);
		pts.setRows(empList);
		return pts;
	}
	/* (non-Javadoc)
	 * @see cn.et.service.impl.EmpService#saveFood(cn.et.entity.Emp)
	 */
	public  void saveEmp(Emp emp) {
		em.insert(emp);
	}
	
	/* (non-Javadoc)
	 * @see cn.et.service.impl.EmpService#deleteFood(java.lang.Integer)
	 */
	public void deleteEmp(Integer id) {
		em.deleteByPrimaryKey(id);
	}

	/* (non-Javadoc)
	 * @see cn.et.service.impl.EmpService#updateFood(cn.et.entity.Emp)
	 */
	public void updateEmp(Emp emp) {
		em.updateByPrimaryKey(emp);
	}
}
