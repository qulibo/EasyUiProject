package cn.et.project.service.impl;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.et.project.dao.FoodMapper;
import cn.et.project.entity.Food;
import cn.et.project.entity.FoodExample;
import cn.et.project.service.FoodService;
import cn.et.project.utils.PageTools;


@Service
public class FoodServiceImpl implements FoodService {
	@Autowired
	FoodMapper fm;
	public PageTools queryFood(String foodname, Integer page, Integer rows) {
		if(foodname==null) {
			foodname="";
		}
		FoodExample fe = new FoodExample();
		fe.createCriteria().andFoodnameLike("%"+foodname+"%");
		int total = (int)fm.countByExample(fe);
		PageTools pageTools = new PageTools(page, total, rows);
		RowBounds rbs = new RowBounds(pageTools.getStartIndex()-1, rows);
		List<Food> foodList = fm.selectByExampleWithRowbounds(fe, rbs);
		pageTools.setRows(foodList);
		return pageTools;
	}
	

	public  void saveFood(Food food) {
		fm.insert(food);
	}
	

	public void deleteFood(Integer foodId) {
		fm.deleteByPrimaryKey(foodId);
	}

	public void updateFood(Food food) {
		fm.updateByPrimaryKey(food);
	}
}
