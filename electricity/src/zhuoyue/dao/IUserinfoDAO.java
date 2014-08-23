package zhuoyue.dao;
import java.util.List;

import zhuoyue.vo.Userinfo;
public interface IUserinfoDAO 
{
	public List<Userinfo> findAll() throws Exception;//查询全部员工信息 (测试成功)
	public List<Userinfo> findByKeyWord(String keyWord) throws Exception;//根据关键字查询员工信息(编号或姓名或部门)(测试成功)
	public Boolean login(Userinfo user) throws Exception;//登陆(测试成功)
	public Userinfo findByCode(String Code)throws Exception;//根据编号找到员工信息(测试成功)
	public Boolean doCreateUser(Userinfo user)throws Exception;//添加一个员工(测试成功)
	public Boolean doAlterUser(Userinfo user)throws Exception;//修改员工信息(测试成功)
	public Boolean doDelete(String code) throws Exception;//根据编号删除员工(测试成功)
	public Boolean doChangePwd(Userinfo user) throws Exception;//根据员工编号修改密码
	public Boolean doChangePrivilege(Userinfo user) throws Exception;//根据员工编号修改员工权限
}
