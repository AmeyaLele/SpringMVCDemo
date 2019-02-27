package com.capgemini.mvc.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capgemini.mvc.model.Department;

@Component
public class DepartmentDAOImpl extends AbstractDAO<Integer, Department> implements DepartmentDAO{

	@Override
	public Department findByID(int departmentId) {
		return getByKey(departmentId);
	}

	@Override
	public Department findByName(String departmentName) {
	
	Criteria criteria = createEntityCriteria();
	criteria.createCriteria("departmentName",departmentName);
	return (Department) criteria.uniqueResult();
	}

	@Override
	public void saveDepartment(Department department) {		
		persist(department);
	}
	
	@Override
	public List<Department> findAll(){
		return getSession().createCriteria(Department.class).list();
		
	}

	@Override
	public List<String> findAllDepartmentName() {
		DetachedCriteria criteria = DetachedCriteria.forClass(Department.class, "dept")
				.setProjection(Projections.property("departmentName"));
		
		return criteria.getExecutableCriteria(getSession()).list();
	}

	@Override
	public void updateDepartment(Department department) {
		persist(department);
	}

	@Override
	public void deleteDepartment(Department department) {
		// TODO Auto-generated method stub

	}

}
