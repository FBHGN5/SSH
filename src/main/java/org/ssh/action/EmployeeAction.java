package org.ssh.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.ssh.entity.Department;
import org.ssh.entity.Employee;
import org.ssh.entity.PageBean;
import org.ssh.service.DepartmentService;
import org.ssh.service.EmployeeService;

import java.util.List;

public class EmployeeAction extends ActionSupport implements ModelDriven<Employee> {
     //模型驱动使用的对象
    private Employee employee=new Employee();
    private final Logger logger= LoggerFactory.getLogger(this.getClass());
    public Employee getModel() {
        return employee;
    }
    private EmployeeService employeeService;
    private DepartmentService departmentService;
    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public void setDepartmentService(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    /*
               登陆执行的方法
                */
    public String login()
    {
        Employee existemployee=employeeService.login(employee);
       if(existemployee==null)
        {
            this.addActionError("用户名或密码错误！");
            return INPUT;
        }
        else{
//            用户信息存入session
            ActionContext.getContext().getSession().put("existEmployee", existemployee);
            return SUCCESS;
        }

    }
    private Integer currPage=1;

    public void setCurrPage(Integer currPage) {
        this.currPage = currPage;
    }
  public String findAll()
  {
      PageBean<Employee> pageBean=employeeService.findByPage(currPage);
      ActionContext.getContext().getValueStack().push(pageBean);
      System.out.println(pageBean.getList()+"dddddddddddddddd");
      return "findAll";
  }
    public String saveUI()
    {
        List<Department> list=departmentService.findAll();
        ActionContext.getContext().getValueStack().set("list",list);

        return "saveUI";
    }
    public String save()
    {
        employeeService.save(employee);
        System.out.println("dddddd");
        return "saveSuccess";
    }
   public String edit()
   {    List<Department> list=departmentService.findAll();
       ActionContext.getContext().getValueStack().set("list",list);
       employee=employeeService.findById(employee.getEid());
       return "editSuccess";
   }
   public String update()
   {
       employeeService.update(employee);
       return "updateSuccess";
   }
   public String delete()
   {
       employee=employeeService.findById(employee.getEid());
       employeeService.delete(employee);
       return "deleteSuccess";
   }
}
