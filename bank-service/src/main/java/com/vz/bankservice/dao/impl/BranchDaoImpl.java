package com.vz.bankservice.dao.impl;

import com.vz.bankservice.dao.BranchDao;
import com.vz.bankservice.domain.Branch;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BranchDaoImpl implements BranchDao {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public Branch addBranch(Branch branch) {
        Session session = sessionFactory.getCurrentSession();
        session.save(branch);
        Branch branch1 = session.load(Branch.class, branch.getBranchId());
        return branch1;
    }

    @Override
    public List<Branch> getAllBranchs() {
        Session session = sessionFactory.getCurrentSession();
        @SuppressWarnings("unchecked")
        List<Branch> list = session.createCriteria(Branch.class).list();
        return list;
    }

    @Override
    public Branch getBranch(String id) {
        Session session = sessionFactory.getCurrentSession();
        Branch branch = session.get(Branch.class, id);
        return branch;
    }

    @Override
    public Branch updateBranch(Branch branch) {
        Session session = sessionFactory.getCurrentSession();
        Branch branch1 = session.get(Branch.class, branch.getBranchId());
        if(branch1!=null){
            session.update(branch);
        }
        return null;
    }

    @Override
    public Branch deleteBranchDetails(String branchId, String branchName) {
        Session session = sessionFactory.getCurrentSession();
        Branch branch1 = session.get(Branch.class, branchId);
        if(branch1!=null&& branchName.equals(branch1.getBranchName())){
            session.delete(branch1);
        }
        return null;
    }
}
