package com.digi.Samplebe;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.digi.model.Authorities;
import com.digi.model.BillingAddress;
import com.digi.model.Cart;
import com.digi.model.CartItem;
import com.digi.model.Category;
import com.digi.model.Customer;
import com.digi.model.CustomerOrder;
import com.digi.model.Product;
import com.digi.model.ShippingAddress;
import com.digi.model.User;

@Configuration
@EnableTransactionManagement   //commit / rollback
public class DBconfiguration {
	@Bean(name="dataSource")
	public DataSource getDataSource() {
	    BasicDataSource dataSource = new BasicDataSource();
	    dataSource.setDriverClassName("org.h2.Driver");
	    dataSource.setUrl("jdbc:h2:tcp://localhost/~/shalini");
	    dataSource.setUsername("sa");
	    dataSource.setPassword("sa");
	    return dataSource;
	}
	/*
	 * <bean id="sessionFactory" class="org.springframework.orm.hibernate4.LocalSessionFactoryBuilder">
	 * <property name="dataSource" ref="dataSource">
	 */
	@Bean //SessionFactory - factory of session objects
	public SessionFactory sessionFactory() {
		LocalSessionFactoryBuilder lsf=
				new LocalSessionFactoryBuilder(getDataSource());
		Properties hibernateProperties=new Properties();
		hibernateProperties.setProperty(
				"hibernate.dialect", "org.hibernate.dialect.H2Dialect");
		hibernateProperties.setProperty("hibernate.hbm2ddl.auto", "update");
		hibernateProperties.setProperty("hibernate.show_sql", "true");
		lsf.addProperties(hibernateProperties);
		//An array of Class objects of all the entities
		//Map all entities to relational table
		Class classes[]=new Class[]{Product.class,Category.class,User.class,Authorities.class,BillingAddress.class,Cart.class,Customer.class,ShippingAddress.class,CartItem.class,CustomerOrder.class};
		//localsessionfactorybuilder -> sessionfactory -> map all entities with relation table
	    return lsf.addAnnotatedClasses(classes).buildSessionFactory();
	}
	@Bean
	public HibernateTransactionManager hibTransManagement(){
		return new HibernateTransactionManager(sessionFactory());
	}

}
