package com.barclays.ipfp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.barclays.ipfp.model.FileHeader;

@Repository
public interface FileHeaderRepo extends JpaRepository<FileHeader, Integer>{

}
