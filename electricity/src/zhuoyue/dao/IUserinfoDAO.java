package zhuoyue.dao;
import java.util.List;

import zhuoyue.vo.Userinfo;
public interface IUserinfoDAO 
{
	public List<Userinfo> findAll() throws Exception;//��ѯȫ��Ա����Ϣ (���Գɹ�)
	public List<Userinfo> findByKeyWord(String keyWord) throws Exception;//���ݹؼ��ֲ�ѯԱ����Ϣ(��Ż���������)(���Գɹ�)
	public Boolean login(Userinfo user) throws Exception;//��½(���Գɹ�)
	public Userinfo findByCode(String Code)throws Exception;//���ݱ���ҵ�Ա����Ϣ(���Գɹ�)
	public Boolean doCreateUser(Userinfo user)throws Exception;//���һ��Ա��(���Գɹ�)
	public Boolean doAlterUser(Userinfo user)throws Exception;//�޸�Ա����Ϣ(���Գɹ�)
	public Boolean doDelete(String code) throws Exception;//���ݱ��ɾ��Ա��(���Գɹ�)
	public Boolean doChangePwd(Userinfo user) throws Exception;//����Ա������޸�����
	public Boolean doChangePrivilege(Userinfo user) throws Exception;//����Ա������޸�Ա��Ȩ��
}
