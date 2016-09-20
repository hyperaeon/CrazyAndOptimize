package com.netease.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netease.domain.Admin;
import com.netease.repositories.AdminRepository;

@Service
public class AdminService {
    @Autowired
    private AdminRepository adminRespository;

    public Admin getAdminByName(String username) {
        return adminRespository.findByUsername(username);
    }

    public List<Admin> getAll() {
        return adminRespository.findAll();
    }

    public Admin save(Admin admin) {
        return adminRespository.save(admin);
    }
    
    /**
     * delete the seleted admin.
     * @param admin
     * @author zhanglei.
     * @serialData 2014年12月24日.
     */
    public void delete(Admin admin){
   	 	adminRespository.delete(admin);
   }
}
