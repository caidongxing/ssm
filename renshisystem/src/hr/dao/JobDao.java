package hr.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import static hr.util.common.HrmConstants.JOBTABLE;
import hr.dao.provider.JobDynaSqlProvider;
import hr.domain.Job;

public interface JobDao {
	@Select("select * from "+JOBTABLE+" where ID=#{id}")
	Job selectById(int id);
	
	
	@Select("select * from "+JOBTABLE+" ")
	List<Job> selectAllJob();
	
	
	//动态查询
	@SelectProvider(type=JobDynaSqlProvider.class,method="selectWhitParam")
	List<Job> selectByPage(Map<String, Object> params);
	@SelectProvider(type=JobDynaSqlProvider.class,method="count")
	Integer count(Map<String, Object> params);
	
	@Delete("delete from "+JOBTABLE+" where ID=#{id}")
	void delectById(Integer id);
	
	
	@SelectProvider(type=JobDynaSqlProvider.class,method="insertJob")
	void save(Job job);
	
	
	@SelectProvider(type=JobDynaSqlProvider.class,method="updateJob")
	void update(Job job);
}









