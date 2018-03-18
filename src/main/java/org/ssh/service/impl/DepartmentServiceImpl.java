package org.ssh.service.impl;




import org.springframework.transaction.annotation.Transactional;
import org.ssh.dao.DepartmentDao;
import org.ssh.entity.Department;
import org.ssh.entity.PageBean;
import org.ssh.service.DepartmentService;

import java.util.List;
@Transactional
public class DepartmentServiceImpl implements DepartmentService {
    private DepartmentDao departmentDao;

	public void setDepartmentDao(DepartmentDao departmentDao) {
		this.departmentDao = departmentDao;
	}
/*
分页查询
 */
	public PageBean<Department> findByPage(Integer currPage) {
		PageBean<Department> pageBean=new PageBean<Department>();
		pageBean.setCurrPage(currPage);
		int pageSize = 3;	//每个显示记录数
		pageBean.setPageSize(pageSize);

		int totalCount = departmentDao.findCount();
		pageBean.setTotalCount(totalCount);//总记录数

		double tc = totalCount;
		Double num = Math.ceil(tc/pageSize);
		pageBean.setTotalPage(num.intValue());//总共页数计算

		int begin = (currPage - 1)*pageSize;//开始页计算
		List<Department> list = departmentDao.findByPage(begin, pageSize);
		pageBean.setList(list);
		return pageBean;
	}

	public void save(Department department) {
       departmentDao.save(department);
	}

	public Department findById(Integer did) {
		return departmentDao.findById(did);
	}

	public void update(Department department) {
       departmentDao.update(department);
	}

	public void delete(Department department) {
		departmentDao.delete(department);

	}

	public List<Department> findAll() {
		return  departmentDao.findAll();
	}
}
