package org.ssh.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;
import org.ssh.entity.Department;

@Transactional
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class DepartmentDaoTest {
   @Autowired
   private DepartmentDao departmentDao;
   private Logger logger= LoggerFactory.getLogger(this.getClass());
    @Test
    public void findCount() {
    }

    @Test
    public void findByPage() {

    }

    @Test
    public void save() {
        Department department=new Department();
        department.setDname("1");
        department.setDdesc("2");
        departmentDao.save(department);
        logger.info("ddddddddddddddddddddddddddddd");
        logger.error("ddddddddddddddddddddddddddddd");
        logger.warn("ddddddddddddddddddddddddddddd");
        logger.info("ddddddddddddddddddddddddddddd");

    }

    @Test
    public void findById() {
    }

    @Test
    public void update() {
    }

    @Test
    public void delete() {
    }

    @Test
    public void findAll() {
    }
}