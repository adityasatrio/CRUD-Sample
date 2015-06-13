package test.asn.service;

import java.util.List;

import com.github.dandelion.datatables.core.ajax.DataSet;
import com.github.dandelion.datatables.core.ajax.DatatablesCriterias;

import test.asn.entity.Data;

public interface ServiceTest {

	Data insert(Data data) throws Exception;

	Data update(Data data) throws Exception;

	Boolean delete(Data data) throws Exception;

	Data findById(Integer id) throws Exception;

	List<Data> findAll() throws Exception;

	DataSet<Data> getDataTable(DatatablesCriterias criterias);

}
