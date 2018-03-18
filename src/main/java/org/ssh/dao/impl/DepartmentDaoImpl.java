package org.ssh.dao.impl;


import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.ssh.dao.DepartmentDao;
import org.ssh.entity.Department;

import java.util.List;

public class DepartmentDaoImpl extends HibernateDaoSupport implements DepartmentDao {

	public int findCount() {

		String hql= "select count(*) from Department";
		List<Long> list= (List<Long>) this.getHibernateTemplate().find(hql);
		if(list.size()>0)
		{ System.out.println("ddao"+list.get(0).intValue());
			return list.get(0).intValue();
		}
		return 0;
	}

	public List<Department> findByPage(int begin, int pageSize) {
		DetachedCriteria criteria=DetachedCriteria.forClass(Department.class);
		List<Department> list= (List<Department>) this.getHibernateTemplate().findByCriteria(criteria,begin,pageSize);
		return  list;
	}

	public void save(Department department) {


		this.getHibernateTemplate().save(department);
	}

	public Department findById(Integer did) {
		return this.getHibernateTemplate().get(Department.class,did);
	}

	public void update(Department department) {
       this.getHibernateTemplate().update(department);
	}

	public void delete(Department department) {
       this.getHibernateTemplate().delete(department);
	}

	public List<Department> findAll() {
		return (List<Department>) this.getHibernateTemplate().find("from Department");
	}
}
