package in.co.vwits.emp.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import in.co.vwits.emp.dao.EmployeeDao;
import in.co.vwits.emp.model.Employee;
@Repository
public class EmployeeJpaImpl implements EmployeeDao {
	@PersistenceContext
	private EntityManager factory;
	/*public EmployeeJpaImpl()
    {
    	factory=Persistence.createEntityManagerFactory("empapp");
    }*/
	public List<Employee> All()
	{
		//EntityManager em=factory.createEntityManager();
		//EntityTransaction tx=em.getTransaction();
		//tx.begin();
		String jpql="FROM Employee";
		TypedQuery<Employee> query = factory.createQuery(jpql,Employee.class);
		List<Employee> studentList = query.getResultList();
		//tx.commit();
		//em.close();
		
		return studentList;
	}
	@Override
	public int save(Employee s) {
		// TODO Auto-generated method stub
		//EntityManager em=factory.createEntityManager();
		//EntityTransaction tx=em.getTransaction();
		//tx.begin();
		factory.persist(s);
		//tx.commit();
		
		return 0;
		
	}
	@Override
	public void UpdateSalById(int id, double salary) {
		// TODO Auto-generated method stub
				//EntityManager em=factory.createEntityManager();
				//EntityTransaction tx=em.getTransaction();
				//tx.begin();
			    Employee s=new Employee();
			    s.setId(id);
			    s.setSalary(salary);
			    factory.merge(s);//this fires update query
				//tx.commit();
				//em.close();
				
		
	}
	@Override
	public void DeleteById(int id) {
		// TODO Auto-generated method stub
		//EntityManager em=factory.createEntityManager();
		//EntityTransaction tx=em.getTransaction();
		//tx.begin();
	    factory.remove(factory.find(Employee.class, id));//This fires a delete query
		//tx.commit();
		//em.close();
	}

}
