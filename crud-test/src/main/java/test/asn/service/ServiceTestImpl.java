package test.asn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import test.asn.dao.DaoTest;
import test.asn.entity.Data;

import com.github.dandelion.datatables.core.ajax.DataSet;
import com.github.dandelion.datatables.core.ajax.DatatablesCriterias;

@Service
public class ServiceTestImpl implements ServiceTest {

	@Autowired
	private DaoTest DaoTest;

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class, timeout = 30)
	public Data insert(Data data) throws Exception {
		Data dataToSave = new Data();
		dataToSave.setUserName(data.getUserName());
		dataToSave.setEmail(data.getEmail());
		dataToSave.setPhoneNumber(data.getPhoneNumber());

		return DaoTest.insert(dataToSave);
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class, timeout = 30)
	public Data update(Data data) throws Exception {
		Data savedData = findById(data.getId());

		savedData.setUserName(data.getUserName());
		savedData.setEmail(data.getEmail());
		savedData.setPhoneNumber(data.getPhoneNumber());

		return DaoTest.update(savedData);
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class, timeout = 30)
	public Boolean delete(Data data) throws Exception {
		Boolean success = Boolean.TRUE;
		try {
			DaoTest.delete(data);
		} catch (Exception ex) {
			success = Boolean.FALSE;
		}
		return success;
	}

	@Transactional(isolation = Isolation.REPEATABLE_READ, timeout = 30)
	public Data findById(Integer id) throws Exception {
		return DaoTest.findById(id);
	}

	@Transactional(isolation = Isolation.REPEATABLE_READ, timeout = 30)
	public List<Data> findAll() throws Exception {
		return DaoTest.findAll();
	}

	@Transactional(isolation = Isolation.REPEATABLE_READ, timeout = 30)
	public DataSet<Data> getDataTable(DatatablesCriterias criterias) {
		List<Data> list = DaoTest.findAll();
		Long total = Long.parseLong(String.valueOf(list.size()));

		return new DataSet<Data>(list, total, total);
	}
}
