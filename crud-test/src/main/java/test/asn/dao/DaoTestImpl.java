package test.asn.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import test.asn.entity.Data;

@Repository
public class DaoTestImpl implements DaoTest {

	@Autowired
	private SessionFactory sessionFactory;

	public Data insert(Data data) {
		Session session = sessionFactory.getCurrentSession();
		session.save(data);
		return data;
	}

	public Data update(Data data) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(data);
		return data;
	}

	public void delete(Data data) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(data);
	}

	public Data findById(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		Data data = (Data) session.get(Data.class, id);
		return data;
	}

	public List<Data> findAll() {
		Session session = sessionFactory.getCurrentSession();
		List<Data> list = session.createCriteria(Data.class).list();
		return list;
	}

}
