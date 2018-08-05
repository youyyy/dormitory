package com.youyi.dormitory.service.impl;

import com.youyi.dormitory.dao.ZsztDao;
import com.youyi.dormitory.dto.DormitoryResult;
import com.youyi.dormitory.entity.Zszt;
import com.youyi.dormitory.exception.DormitoryException;
import com.youyi.dormitory.service.ZsztService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class ZsztServiceImpl implements ZsztService{
    @Autowired
    private ZsztDao zsztDao;
    @Override
    public DormitoryResult queryZszts() {
        List<Zszt> zsztList =zsztDao.queryZszts();
        if(zsztList != null && zsztList.size()>0){
            return DormitoryResult.ok(zsztList);
        }else{
            return DormitoryResult.notFount("查询住宿情况为空");
        }
    }

    @Override
    public DormitoryResult queryZsztByZid(int zid) {
        if(zid >0){
            Zszt zszt = zsztDao.queryZsztByZid(zid);
            if(zszt != null){
                return DormitoryResult.ok(zszt);
            }else{
                throw new DormitoryException("查询住宿情况失败");
            }
        }
        return DormitoryResult.notFount("查询住宿条件错误");
    }

    @Override
    public DormitoryResult queryZsztByDate(Date date) {
        if(date != null){
            List<Zszt> zsztList = zsztDao.queryZsztByDate(date);
            if(zsztList != null){
                return DormitoryResult.ok(zsztList);
            }else{
                throw new DormitoryException("查询住宿情况失败");
            }
        }
        return DormitoryResult.notFount("查询住宿日期错误");
    }

    @Override
    public DormitoryResult queryZsztByDid(int did) {
        if(did >0){
            List<Zszt> zsztList = zsztDao.queryZsztByDid(did);
            if(zsztList != null){
                return DormitoryResult.ok(zsztList);
            }else{
                throw new DormitoryException("查询住宿情况失败");
            }
        }
        return DormitoryResult.notFount("查询住宿条件错误");
    }

    @Override
    public DormitoryResult addZszt(Zszt zszt) {
        if(zszt != null){
            try{
                int effectedNum = zsztDao.insertZszt(zszt);
                if(effectedNum>0){
                    return DormitoryResult.ok();
                }
                return DormitoryResult.notFount("插入住宿情况失败");
            }catch (Exception e){
                throw new DormitoryException("插入住宿情况异常："+e.getMessage());
            }
        }
        return DormitoryResult.notFount("插入住宿情况为空");
    }

    @Override
    public DormitoryResult modifyZszt(Zszt zszt) {
        if(zszt != null){
            try{
                int effectedNum = zsztDao.updateZszt(zszt
                );
                if(effectedNum>0){
                    return DormitoryResult.ok();
                }
                return DormitoryResult.notFount("更新住宿情况失败");
            }catch (Exception e){
                throw new DormitoryException("更新住宿情况异常："+e.getMessage());
            }
        }
        return DormitoryResult.notFount("更新住宿情况为空");
    }
    @Override
    public DormitoryResult deleteZsztByZid(int zid) {
        if(zid>0){
            try{
                int effectedNum = zsztDao.deleteZsztByZid(zid);
                if(effectedNum>0){
                    return DormitoryResult.ok();
                }
                return DormitoryResult.notFount("删除住宿情况失败");
            }
            catch (Exception e){
                throw new DormitoryException("删除住宿情况异常："+e.getMessage());
            }
        }
        return DormitoryResult.notFount("删除住宿情况参数为空");
    }

    @Override
    public DormitoryResult deleteZsztByDid(int did) {
        if(did>0){
            try{
                int effectedNum = zsztDao.deleteZsztByDid(did);
                if(effectedNum>0){
                    return DormitoryResult.ok();
                }
                return DormitoryResult.notFount("删除住宿情况失败");
            }
            catch (Exception e){
                throw new DormitoryException("删除住宿情况异常："+e.getMessage());
            }
        }
        return DormitoryResult.notFount("删除住宿情况参数为空");
    }

    @Override
    public DormitoryResult deleteZsztByDate(Date date) {
        if(date != null){
            try{
                int effectedNum = zsztDao.deleteZsztByDate(date);
                if(effectedNum>0){
                    return DormitoryResult.ok();
                }
                return DormitoryResult.notFount("删除住宿情况失败");
            }
            catch (Exception e){
                throw new DormitoryException("删除住宿情况异常："+e.getMessage());
            }
        }
        return DormitoryResult.notFount("删除住宿情况参数为空");    }
}
