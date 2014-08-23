package zhuoyue.dao;

import java.util.List;
import zhuoyue.vo.Record;

public interface IRecordDAO 
{
	public Record findByPlanAndCode(int name,int count,int planCode,String code) throws Exception; //���ݼƻ��������������ҳ���¼
	public int getCount(int name) throws Exception;//���ݱ�����ȡ�ñ���ֶθ���,�ɹ�
	public List<String> getParameterName(int name,int count) throws Exception;//���ݱ������ֶθ�����ȡ�������֣��ɹ�
	public List<String> getStandard(int name,int count) throws Exception;//���ݱ������ֶθ�����ȡ��׼ֵ���ɹ�
	public List<Record> findAll(int name,int count) throws Exception;//���ݱ�������ȡȫ������ �ɹ� ?
	public int getMax(int name) throws Exception;//���ݱ�����ȡ���ID �ɹ�
	public List<Record> findByKeyword(int name,int count,String key) throws Exception;//���������������˴����ҳ���¼,�ɹ�?
	public Boolean doUpdateState(int name,int state,int id,String remark) throws Exception;//���ݱ�����id�޸ļ�¼ ״̬�뱸ע,�ɹ�
	public Record findByDateAndCode(int name,int count,String date,String code) throws Exception;//�ҳ�������¼,�ɹ�?
	public Boolean doUpdateParameter(int name,int id,List<String> parameter,int count) throws Exception;//�޸Ĳ���,�ɹ�
	public Boolean doInsert(int name,int count,Record record) throws Exception;//����һ����¼,�ɹ�?
	public Boolean doCreateTable(int name,List<String>parameterName,List<String>standard) throws Exception;//������,�ɹ�?
	public int findProblemByDateAndParameter(int name,String date,int parameter) throws Exception;
}
