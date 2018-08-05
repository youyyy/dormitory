package com.youyi.dormitory.dao;

import com.youyi.dormitory.entity.Zszt;

import java.util.Date;
import java.util.List;

public interface ZsztDao {
    List<Zszt> queryZszts();
    Zszt queryZsztByZid(int zid);
    List<Zszt> queryZsztByDate(Date date);
    List<Zszt> queryZsztByDid(int did);
    int insertZszt(Zszt zszt);
    int updateZszt(Zszt zszt);
    int deleteZsztByZid(int zid);
    int deleteZsztByDid(int did);
    int deleteZsztByDate(Date date);
}
