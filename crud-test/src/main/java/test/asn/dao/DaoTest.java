package test.asn.dao;

import java.util.List;

import test.asn.entity.Data;

public interface DaoTest {

	Data insert(Data data);

	Data update(Data data);

	void delete(Data data);
	
	Data findById(Integer id);
	
	List<Data> findAll();
}
