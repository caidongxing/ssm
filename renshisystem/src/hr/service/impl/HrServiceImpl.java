package hr.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import hr.dao.DeptDao;
import hr.dao.DocumentDao;
import hr.dao.EmployeeDao;
import hr.dao.JobDao;
import hr.dao.NoticeDao;
import hr.dao.UserDao;
import hr.domain.Dept;
import hr.domain.Document;
import hr.domain.Employee;
import hr.domain.Job;
import hr.domain.Notice;
import hr.domain.User;
import hr.service.HrService;
import hr.util.tag.PageModel;
@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT)
@Service("hrService")
public class HrServiceImpl implements HrService {
	@Autowired
	private UserDao userDao;
	@Autowired
	private DeptDao deptDao;
	@Autowired
	private EmployeeDao employeeDao;
	@Autowired
	private NoticeDao noticeDao;
	@Autowired
	private JobDao jobDao;
	@Autowired
	private DocumentDao documentDao;
	
	@Transactional(readOnly=true)
	@Override
	public User login(String loginname,String password){
		System.out.println("HrServiceImpl login-->");
		return userDao.selectByLoginnameAndPassword(loginname, password);
	}

	@Transactional(readOnly=true)
	@Override
	public User findUserById(Integer id) {
		// TODO Auto-generated method stub
		return userDao.selectById(id);
	}
	@Transactional(readOnly=true)
	@Override
	//点击用户查询这个按钮，会调用UserController.selectUser再调用findUser这个方法，
	//然后再调用userDao.count这个方法，然后调用selectByPage()
	public List<User> findUser(User user, PageModel pageModel) {
		Map<String, Object> params=new HashMap<String, Object>();
		params.put("user", user);
		//这个页有多少条数据，recordCount表示多少条
		int recordCount=userDao.count(params);
		System.out.println("点击用户查询按钮");
		System.out.println("recordCount --->"+recordCount);
		pageModel.setRecordCount(recordCount);
		if(recordCount>0){
			params.put("pageModel", pageModel);
			
		}
		List<User> users=userDao.selectByPage(params);
		return users;
	}

	@Override
	public void removeUserById(Integer id) {
		 userDao.deleteById(id);
	}

	@Override
	public void modifyUser(User user) {
		userDao.update(user);
	}

	@Override
	public void addUser(User user) {
		System.out.println("用户添加，在HrServiceImpl.addUser()");
		userDao.save(user);
	}
	@Transactional(readOnly=true)
	@Override
	public List<Employee> findEmployee(Employee employee, PageModel pageModel) {
		Map<String, Object> params=new HashMap<String, Object>();
		params.put("employee", employee);
		int recordCount=deptDao.count(params);
		System.out.println("recordCount---->>"+recordCount);
		pageModel.setRecordCount(recordCount);
		if(recordCount>0){
			params.put("pageModel", pageModel);
		}
		List<Employee> employees=employeeDao.selectByPage(params);
		return employees;
	}
	@Override
	public void removeEmployee(Integer id) {
		employeeDao.deleteById(id);
	}

	@Transactional(readOnly=true)
	@Override
	public Employee findEmployeeById(Integer id) {
//		System.out.println("findEmpoyeeByid");
		
		return employeeDao.selectById(id);
	}

	@Override
	public void addEmployee(Employee employee) {
		employeeDao.save(employee);
	}

	@Override
	public void modifyEmployee(Employee employee) {
		employeeDao.update(employee);
	}

	@Transactional(readOnly=true)
	@Override
	public List<Dept> findDept(Dept dept, PageModel pageModel) {
		Map<String, Object> params=new HashMap<String, Object>();
		params.put("dept", dept);
		int recordCount=deptDao.count(params);
		System.out.println("recordCount --->>"+recordCount);
		pageModel.setRecordCount(recordCount);
		if(recordCount>0){
			params.put("pageModel", pageModel);
		}
		List<Dept> depts=deptDao.selectByPage(params);
		return depts;
	}

	@Transactional(readOnly=true)
	@Override
	public List<Dept> findAllDept() {
		return deptDao.selectAllDept();
	}

	@Override
	public void removeDeptById(Integer id) {
		deptDao.deleteById(id);
	}

	@Override
	public void addDept(Dept dept) {
		deptDao.save(dept);
	}

	@Transactional(readOnly=true)
	@Override
	public Dept finDeptById(Integer id) {
		return deptDao.selectById(id);
	}

	@Override
	public void modifyDept(Dept dept) {
		deptDao.update(dept);
	}

	@Override
	public List<Job> findAllJob() {
		System.out.println("findAllJob");
		// TODO Auto-generated method stub
		return jobDao.selectAllJob();
	}

	@Transactional(readOnly=true)
	@Override
	public List<Job> findJob(Job job, PageModel pageModel) {
		Map<String, Object> params=new HashMap<String, Object>();
		params.put("job", job);
		int recordCount=jobDao.count(params);
		pageModel.setRecordCount(recordCount);
		if(recordCount>0){
			params.put("pageModel", pageModel);
		}
		List<Job> jobs=jobDao.selectByPage(params);
		return jobs;
	}

	@Override
	public void removeJobById(Integer id) {
		jobDao.delectById(id);
	}

	@Override
	public void addJob(Job job) {
		jobDao.save(job);
	}

	@Transactional(readOnly=true)
	@Override
	public Job findJobById(Integer id) {
		return jobDao.selectById(id);
	}

	@Override
	public void modifyJob(Job job) {
		jobDao.update(job);
	}

	@Transactional(readOnly=true)
	@Override
	public List<Notice> findNotice(Notice notice, PageModel pageModel) {
		Map<String, Object> params=new HashMap<String, Object>();
		params.put("notice", notice);
		int recordCount=noticeDao.count(params);
		pageModel.setRecordCount(recordCount);
		if(recordCount>0){
			params.put("pageModel", pageModel);
		}
		List<Notice> notices=noticeDao.selectPage(params);
		return notices;
	}

	@Transactional(readOnly=true)
	@Override
	public Notice findNoticeById(Integer id) {
		// TODO Auto-generated method stub
		return noticeDao.selectById(id);
	}

	@Override
	public void removeNoticeById(Integer id) {
		noticeDao.deleteById(id);
	}

	@Override
	public void addNotice(Notice notice) {
		noticeDao.save(notice);
	}

	@Override
	public void modifyNotice(Notice notice) {
		noticeDao.update(notice);
	}

	@Transactional(readOnly=true)
	@Override
	public List<Document> findDocument(Document document, PageModel pageModel) {
		Map<String, Object> params=new HashMap<String, Object>();
		params.put("document", document);
		int  recordCount=documentDao.count(params);
		System.out.println("recordCount --->>>"+recordCount);
		pageModel.setRecordCount(recordCount);
		if(recordCount>0){
			params.put("pageModel", pageModel);
		}
		System.out.println("hr Listqian");
		List<Document> documents = documentDao.selectByPage(params);//这行出问题了
		System.out.println("selectByPage");
		return documents;
		
	}

	
	@Override
	public void addDocument(Document document) {
		// TODO Auto-generated method stub
		documentDao.save(document);
	}

	@Override
	public void removeDocumentById(Integer id) {
		// TODO Auto-generated method stub
		documentDao.deleteById(id);
	}

	@Transactional(readOnly=true)
	@Override
	public Document findDocumentById(Integer id) {
		System.out.println("findDocument");
		// TODO Auto-generated method stub
		return documentDao.selectById(id);
	}

	@Override
	public void modifyDocument(Document document) {
		// TODO Auto-generated method stub
		documentDao.update(document);
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
