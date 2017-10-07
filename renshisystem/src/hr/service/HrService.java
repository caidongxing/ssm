package hr.service;

import java.util.List;

import hr.domain.Dept;
import hr.domain.Document;
import hr.domain.Employee;
import hr.domain.Job;
import hr.domain.Notice;
import hr.domain.User;
import hr.util.tag.PageModel;

public interface HrService {

	//用户登录
	User login(String loginname,String password);
	
	//根据id查询
	User findUserById(Integer id);
	
	//获得所有用户
	List<User> findUser(User user,PageModel pageModel);
	
	//根据Id删除用户
	void removeUserById(Integer id);
	
	//修改用户
	void modifyUser(User user);
	
	//添加用户
	void addUser(User user);
	
	//获得所有员工
	List<Employee> findEmployee(Employee employee,PageModel pageModel);
	
	//根据id删除员工
	void removeEmployee(Integer id);
	
	//根据id查询员工
	Employee findEmployeeById(Integer id);
	
	//添加员工
	void addEmployee(Employee employee);
	
	//修改员工
	void modifyEmployee(Employee employee);
	
	//获得所有部门，分页查询
	List<Dept> findDept(Dept dept,PageModel pageModel);
	
	//获得所有部门
	List<Dept> findAllDept();
	
	//根据id删除部门
	void removeDeptById(Integer id);
	
	//添加部门
	void addDept(Dept dept);
	
	//根据id查询部门
	Dept finDeptById(Integer id);
	
	//修改部门
	void modifyDept(Dept dept);
	
	//获得所有职位
	List<Job> findAllJob();
	
	//获得所有职位，分页查询
	List<Job> findJob(Job job,PageModel pageModel);
	
	//根据id删除职位
	void removeJobById(Integer id);
	
	//添加职位
	void addJob(Job job);
	
	//根据id查询职位
	Job findJobById(Integer id);
	
	//修改职位
	void modifyJob(Job job);
	
	//获得所有公告
	List<Notice> findNotice(Notice notice,PageModel pageModel);
	
	//根据id查询
	Notice findNoticeById(Integer id);
	
	//根据id删除公告
	void removeNoticeById(Integer id);
	
	//添加公告
	void addNotice(Notice notice);
	
	//修改公告
	void modifyNotice(Notice notice);
	
	/**
	 * 获得所有文档
	 * @return Document对象的List集合
	 * */
	List<Document> findDocument(Document document,PageModel pageModel);
	
	/**
	 * 添加文档
	 * @param Document 文件对象
	 * */
	void addDocument(Document document);
	
	/**
	 * 根据id查询文档
	 * @param id
	 * @return 文档对象
	 * */
	Document findDocumentById(Integer id);
	
	/**
	 * 根据id删除文档
	 * @param id
	 * */
	public void removeDocumentById(Integer id);
	
	/**
	 * 修改文档
	 * @param Document 公告对象
	 * */
	void modifyDocument(Document document);
	
}
