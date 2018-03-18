package org.ssh.service;

import java.util.List;
import org.ssh.entity.Department;
import org.ssh.entity.PageBean;


public interface DepartmentService {

	PageBean<Department> findByPage(Integer currPage);

	void save(Department department);

	Department findById(Integer did);

	void update(Department department);

	void delete(Department department);

	List<Department> findAll();

}
