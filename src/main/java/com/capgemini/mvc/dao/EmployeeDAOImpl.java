package com.capgemini.mvc.dao;
import java.util.List;

import javax.activation.DataSource;
import javax.persistence.Query;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.capgemini.mvc.model.Employee;

@Component
public class EmployeeDAOImpl extends AbstractDAO<Integer, Employee> implements EmployeeDAO {
	
	@Override
	public Employee findById(int employeeId) {
		
		return getByKey(employeeId);
	}

	@Override
	public void saveEmployee(Employee employee) {
		
		persist(employee);
		
	}

	@Override
	public void updateEmployee(Employee employee) {
		
		persist(employee);
		
	}

	@Override
	public void deleteEmployeeById(Integer employeeId) {

		Query query= (Query) getSession().createSQLQuery("delete from EMPLOYEE where E_ID =:employeeId");
		query.setParameter(0, employeeId);
		query.executeUpdate();
	}

	@Override
	public List findAllEmployees() {
		// TODO Auto-generated method stub
		/*Query query= (Query) getSession().createSQLQuery("select * from EMPLOYEE");
		return query.getResultList();
		*/
		Criteria criteria = createEntityCriteria();
		return criteria.list();
	}

	@Override
	public Employee findBySSN(String ssn) {
		
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("ssn", ssn));				
		return (Employee) criteria.uniqueResult();
	}
	
}
