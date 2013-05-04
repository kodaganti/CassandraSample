package com.cts.dal;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 */
public class App {
	static EntityManagerFactory emf = null;
	static EntityManager manager = null;

	static {
		emf = Persistence.createEntityManagerFactory("cassandra_pu");
		manager = emf.createEntityManager();
		System.setProperty("cassandra.join_ring", "false");
	}

	public static void main(String[] args) {
		insert();
		update();
		findAll();
		findByName();
		delete();
		findByName();
		System.out.println("Manager Created");
	}

	private static void findByName() {
		ZipLocationBean bean = manager.find(ZipLocationBean.class, "95126");
		System.out.println(""+bean);
	}

	private static void findAll() {
		Query query = manager.createQuery("Select z from ZipLocationBean z");
		List<ZipLocationBean> result = query.getResultList();
		System.out.println("Got List");
	}

	private static void delete() {
		ZipLocationBean bean = manager.find(ZipLocationBean.class, "95126");
		manager.remove(bean);
	}

	private static void update() {
		ZipLocationBean bean = manager.find(ZipLocationBean.class, "95126");
		bean.setCity("SanJose");
		manager.merge(bean);
		System.out.println(""+bean);
	}

	private static void insert() {
		ZipLocationBean bean = new ZipLocationBean();
		bean.setCity("San Jose");
		bean.setCountry("US");
		bean.setLatitude(12.3);
		bean.setLongitude(11.3);
		bean.setState("California");
		bean.setZipcode("95126");
		manager.persist(bean);
	}
}