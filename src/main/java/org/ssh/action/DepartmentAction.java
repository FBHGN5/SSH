package org.ssh.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.ssh.entity.Department;
import org.ssh.entity.PageBean;
import org.ssh.service.DepartmentService;

public class DepartmentAction extends ActionSupport implements ModelDriven<Department> {
    private Department department=new Department();

    public Department getModel() {
        return department;
    }

    private DepartmentService departmentService;

    public void setDepartmentService(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }
    private Integer currPage=1;

    public void setCurrPage(Integer currPage) {
        this.currPage = currPage;
    }
    public String findAll()
    {
        PageBean<Department> pageBean= departmentService.findByPage(currPage);
        //page村人员值栈
        ActionContext.getContext().getValueStack().push(pageBean);
      return "findAll";
    }
    public String saveUI()
    {
        return "saveUI";
    }
    public String save()
    {
        departmentService.save(department);
        System.out.println("ddddddd");
        return "saveSuccess";
    }
    public String edit()
    {
        department=departmentService.findById(department.getDid());
        return "editSuccess";
    }
    public String update()
    {
        departmentService.update(department);
        return "updateSuccess";
    }
    public String delete()
    {   department=departmentService.findById(department.getDid());
        departmentService.delete(department);
        return "deleteSuccess";
    }
}
