package hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class hibernateinit {

	private static SessionFactory sessionFactory;
	static{
		final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
				.configure() // configures settings from hibernate.cfg.xml
				.build();
		try {
			sessionFactory = new MetadataSources( registry ).buildMetadata().buildSessionFactory();
//			System.out.println("init");
		}
		catch (Exception e) {
			// The registry would be destroyed by the SessionFactory, but we had trouble building the SessionFactory
			// so destroy it manually.
			StandardServiceRegistryBuilder.destroy( registry );
		}
	}
	
	//private Session session;
	//private Transaction transaction;
	
	public static SessionFactory getSessionFactory()
	{
		return sessionFactory;
	}
	
//	public static Session getSession() {
//		Session session = sessionFactory.openSession();
//		return session;
//	}
	
	public static void close(){
		try {
			sessionFactory.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
