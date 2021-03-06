package org.ssh.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.ssh.dao.EmployeeDao;
import org.ssh.entity.Department;
import org.ssh.entity.Employee;


public class EmployeeDaoImpl extends HibernateDaoSupport implements EmployeeDao {


	public Employee findByUsernameAndPassword(Employee employee) {
		String hql = "from Employee where username=? and password=?";

		List<Employee> list= (List<Employee>) this.getHibernateTemplate().find(hql,employee.getUsername(),employee.getPassword());
		if(list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

	public int findCount() {

		String hql= "select count(*) from Employee";
		List<Long> list= (List<Long>) this.getHibernateTemplate().find(hql);
		if(list.size()>0)
		{
			return list.get(0).intValue();
		}
		return 0;
	}

	public List<Employee> findByPage(int begin, int pageSize) {
		DetachedCriteria criteria=DetachedCriteria.forClass(Employee.class);
		List<Employee> list= (List<Employee>) this.getHibernateTemplate().findByCriteria(criteria,begin,pageSize);
		return  list;
	}

	public void save(Employee employee) {
       this.getHibernateTemplate().save(employee);
	}

	public Employee findById(Integer eid) {
		return this.getHibernateTemplate().get(Employee.class,eid);
	}

	public void update(Employee employee) {
      this.getHibernateTemplate().update(employee);
	}

	public void delete(Employee employee) {
      this.getHibernateTemplate().delete(employee);
	}
}
