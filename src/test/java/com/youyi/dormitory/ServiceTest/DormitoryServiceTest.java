package com.youyi.dormitory.ServiceTest;

import com.youyi.dormitory.dto.DormitoryResult;
import com.youyi.dormitory.entity.Building;
import com.youyi.dormitory.entity.Dormitory;
import com.youyi.dormitory.service.DormitoryService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DormitoryServiceTest {
    @Autowired
    private DormitoryService dormitoryService;
    @Test
    public void testAddDormitory(){
        Building building = new Building();
        building.setBid(3);
        Dormitory dormitory = new Dormitory();
        dormitory.setBuilding(building);
        dormitory.setNum("125");
        dormitory.setMaxMan(4);
        DormitoryResult result = dormitoryService.addDormitory(dormitory);
        Assert.assertEquals(new Integer(200),result.getStatus());
    }
}
