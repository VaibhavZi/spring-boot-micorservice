package com.vz.bankservice.service.impl;

import com.vz.bankservice.dao.BranchDao;
import com.vz.bankservice.domain.Branch;
import com.vz.bankservice.service.BranchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BranchServiceImpl implements BranchService {
    @Autowired
    private BranchDao branchDao;

    @Override
    public Branch addBranch(Branch branch) {
        return branchDao.addBranch(branch);
    }

    @Override
    public List<Branch> getAllBranchs() {
        return branchDao.getAllBranchs();
    }

    @Override
    public Branch getBranch(String id) {
        return branchDao.getBranch(id);
    }

    @Override
    public Branch updateBranch(Branch branch) {
        return branchDao.updateBranch(branch);
    }

    @Override
    public Branch deleteBranchDetails(String branchId, String branchName) {
        return branchDao.deleteBranchDetails(branchId, branchName);
    }
}
