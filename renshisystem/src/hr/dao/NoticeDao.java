package hr.dao;

import hr.dao.provider.NoticeDynaSqlProvider;
import hr.domain.Notice;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.mapping.FetchType;

import static hr.util.common.HrmConstants.NOTICETABLE;
public interface NoticeDao {
	@SelectProvider(type=NoticeDynaSqlProvider.class,method="selectWhitParam")
	@Results({
		@Result(id=true,column="id",property="id"),
		@Result(column="CREATE_DATE",property="createDate",javaType=java.util.Date.class),
		@Result(column="USER_ID",property="user",
		one=@One(select="hr.dao.UserDao.selectById",
		fetchType=FetchType.EAGER))
		})
	List<Notice> selectPage(Map<String, Object> params);
	@SelectProvider(type=NoticeDynaSqlProvider.class,method="count")
	Integer count(Map<String, Object> params);
	
	@Select("select *from "+NOTICETABLE+" where id=#{id}")
	Notice selectById(Integer id);
	
	@Delete("delete from "+NOTICETABLE+" where id=#{id}")
	void deleteById(Integer id);
	
	@SelectProvider(type=NoticeDynaSqlProvider.class,method="insertNotice")
	void save(Notice notice);
	
	@SelectProvider(type=NoticeDynaSqlProvider.class,method="updateNotice")
	void update(Notice notice);
	
	
	
}
