package ucm.onlinedvdstore.repository;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.search.FullTextSession;
import org.hibernate.search.Search;


import org.hibernate.search.query.dsl.QueryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ucm.onlinedvdstore.bean.DVDBean;

@Repository
@SuppressWarnings("unchecked")
public class DVDRepository {

	@Autowired
	private SessionFactory mySessionFactory;

	@Transactional
	public void indexDVDS() throws Exception {
		try {
			Session session = mySessionFactory.getCurrentSession();

			FullTextSession fullTextSession = Search.getFullTextSession(session);
			fullTextSession.createIndexer().startAndWait();
		} catch (Exception e) {
			throw e;
		}
	}

	@Transactional
	public void insertDVDToDB(int id, String dvdCategory, String dvdName, String dvdDescription, double dvdPrice,
			String imagepath) {
		Session session = mySessionFactory.getCurrentSession();
		DVDBean dvdBean = new DVDBean();
		// UUID x = UUID.randomUUID();
		int x = 1;
		Date datenow = new Date();
		dvdBean.setId(id);
		dvdBean.setDvdCategory(dvdCategory);
		dvdBean.setDvdName(dvdName);
		dvdBean.setDvdDescription(dvdDescription);
		dvdBean.setDvdPrice(dvdPrice);
		dvdBean.setImagePath(imagepath);
		dvdBean.setCreateDate(datenow);
		dvdBean.setUpdateDate(datenow);

		session.saveOrUpdate(dvdBean);
	}

	public List<DVDBean> searchDVD(String searchText) throws Exception {
		try {
			Session session = mySessionFactory.openSession();
			FullTextSession fullTextSession = Search.getFullTextSession(session);
			QueryBuilder qb = fullTextSession.getSearchFactory().buildQueryBuilder().forEntity(DVDBean.class).get();
			org.apache.lucene.search.Query query = qb.keyword().onFields("dvdCategory", "dvdName", "dvdDescription")
					.matching(searchText).createQuery();
			org.hibernate.Query hibQuery = fullTextSession.createFullTextQuery(query, DVDBean.class);
			List<DVDBean> results = hibQuery.list();
			return results;
		} catch (Exception e) {
			throw e;
		}
	}

	public List<DVDBean> getDVDList(String searchText) {
		 Session session = mySessionFactory.openSession();
		 @SuppressWarnings("unchecked")
		 List<DVDBean> dvdList = session.createQuery("FROM DVDBean").list();
		session.close();
		 System.out.println("+++++++++++++++++Found :" +dvdList.size() + "DVDBean" +dvdList);
		 //System.out.println(dvdList.set(index, element));
		 return dvdList;
		 /* .buildQueryBuilder().forEntity(DVDBean.class).get(); String sql = "";
		 * SQLQuery query = sessiondb.createSQLQuery(sql); return query.list();
		 * Query hibQuery = fullTextSession.createQuery("from DVDBean");
		 * List<DVDBean> dvdList = hibQuery.list(); System.out.println(
		 * "dvd list retrieved: " + dvdList); return dvdList;
		 */

	}



}
