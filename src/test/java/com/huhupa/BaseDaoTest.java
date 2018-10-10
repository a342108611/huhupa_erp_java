package com.huhupa;

import com.huhupa.basicdata.dao.CompanyDao;
import com.huhupa.basicdata.entity.Company;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BaseDaoTest {
    @Autowired
    private CompanyDao customerDao;

    @Test
    public void testAdd(){
        Company customer = new Company();
        Company save = customerDao.save(customer);
        System.out.println(save);
    }
}
