package com._2020211001001129xiajianbo.week5.demo.service;
import com._2020211001001129xiajianbo.week5.demo.dao.UserDao;
import com._2020211001001129xiajianbo.week5.demo.entity.userEntity;
public class UserService {
    UserDao userDao=new UserDao();
    public String login(userEntity userEntity){
        userEntity userResult=userDao.login(userEntity);
        if(userResult!=null){
            return "登陆成功";
        }
        else {
            return "登陆失败";
        }
    }
}
