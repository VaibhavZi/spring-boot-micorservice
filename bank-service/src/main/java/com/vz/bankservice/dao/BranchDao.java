package com.vz.bankservice.dao;

import com.vz.bankservice.domain.Branch;

import java.util.List;

public interface BranchDao {
    Branch addBranch(Branch branch);
    List<Branch> getAllBranchs();
    Branch getBranch(String id);
    Branch updateBranch(Branch branch);
    Branch deleteBranchDetails(String branchId, String branchName);
}
