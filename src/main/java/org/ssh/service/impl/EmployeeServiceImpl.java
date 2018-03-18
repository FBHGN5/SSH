package org.ssh.service.impl;



import org.springframework.transaction.annotation.Transactional;
import org.ssh.dao.EmployeeDao;
import org.ssh.entity.Department;
import org.ssh.entity.Employee;
import org.ssh.entity.PageBean;
import org.ssh.service.EmployeeService;

import java.util.List;


@Transactional
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeDao employeeDao;

    public void setEmployeeDao(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    public Employee login(Employee employee) {
    	return employeeDao.findByUsernameAndPassword(employee);
	}

	public PageBean<Employee> findByPage(Integer currPage) {
		PageBean<Employee> pageBean=new PageBean<Employee>();
		pageBean.setCurrPage(currPage);
		int pageSize = 3;	//每个显示记录数
		pageBean.setPageSize(pageSize);

		int totalCount = employeeDao.findCount();
		pageBean.setTotalCount(totalCount);//总记录数

		double tc = totalCount;
		Double num = Math.ceil(tc/pageSize);
		pageBean.setTotalPage(num.intValue());//总共页数计算

		int begin = (currPage - 1)*pageSize;//开始页计算
		List<Employee> list = employeeDao.findByPage(begin, pageSize);
		pageBean.setList(list);
		return pageBean;
	}

	public void save(Employee employee) {
      employeeDao.save(employee);
	}

	public Employee findById(Integer eid) {
		return employeeDao.findById(eid);
	}

	public void update(Employee employee) {
        employeeDao.update(employee);
	}

	public void delete(Employee employee) {
       employeeDao.delete(employee);
	}
}
