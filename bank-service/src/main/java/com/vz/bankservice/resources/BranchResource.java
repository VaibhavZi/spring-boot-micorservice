package com.vz.bankservice.resources;

import com.vz.bankservice.domain.Bank;
import com.vz.bankservice.domain.Branch;
import com.vz.bankservice.service.BranchService;
import jdk.nashorn.internal.ir.BreakableNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class BranchResource {

    @Autowired
    @LoadBalanced
    private RestTemplate restTemplate;

    @Autowired
    private BranchService branchService;

    @GetMapping("/branch")
    public List<Branch> getAllBranches(){
        return branchService.getAllBranchs();
    }

    @GetMapping("/branch/{branchId}")
    public ResponseEntity<Branch> getBranchUsingId(@PathVariable("branchId") String branchId){
        Branch branch = branchService.getBranch(branchId);
        if(branch!=null){
            return new ResponseEntity<Branch>(branch, HttpStatus.FOUND);
        }
        return new ResponseEntity<Branch>(HttpStatus.NOT_FOUND);
    }

    @PostMapping(consumes = "appication/json")
    public ResponseEntity<Branch> addNewBranch(@RequestBody Branch branch){
        Branch branch1 = branchService.addBranch(branch);
        if(branch1!=null)
        {
            return new ResponseEntity<Branch>(branch1, HttpStatus.CREATED);
        }
        return new ResponseEntity<Branch>(HttpStatus.BAD_REQUEST);
    }

    @PutMapping(path="/branch", consumes = "application/json")
    public ResponseEntity<Branch> updateBranchDetails(@RequestBody Branch branch){
        Branch branch1 = branchService.updateBranch(branch);
        if(branch1!=null)
            return new ResponseEntity<Branch>(branch1, HttpStatus.ACCEPTED);
        return new ResponseEntity<Branch>(HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping(path="/branch/delete/{bankId}/{branchId}/{branchName}")
    public ResponseEntity<Branch> deleteBranchDetails(@PathVariable("bankId")int bankCode,@PathVariable("branchId") String branchId, @PathVariable("branchName")String branchName ){

        Bank bankdetails = restTemplate.getForObject("http://bank-service/bank/" + bankCode, Bank.class);
        if(bankdetails!=null){
            ResponseEntity<Branch> branchUsingId = getBranchUsingId(branchId);
            String branchName1 = branchUsingId.getBody().getBranchName();
            if(branchName.equalsIgnoreCase(branchName1)) {
                Branch branch = branchService.deleteBranchDetails(branchId, branchName);
                return new ResponseEntity<Branch>(branch, HttpStatus.OK);
            }
        }
        return new ResponseEntity<Branch>(HttpStatus.NOT_FOUND);
    }
}
