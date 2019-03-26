package com.xiaoz.mapper;

import com.xiaoz.model.User;
import com.xiaoz.vo.UserQueryVO;
import java.util.List;
import java.util.Map;

public interface UserMapper {
//    @Insert("insert into user (username, sex, birthday, address) value (#{username}, #{sex}, #{birthday}, #{address})")
    int save(User user);

//    @Select("SELECT * FROM user where id = #{id}")
    User findUserById(int id);

    List<User>  findUserByUserQueryVO(UserQueryVO vo);

    List<User>  findUserByMap(Map<String,Object> map);

    int findUserCount(UserQueryVO vo);

    User findUserByIdResultMap(int userId);

    List<User> findUserList(UserQueryVO vo);

    List<User> findUserByIds(UserQueryVO vo);

    List<User> findUserByIds2(List<Integer> ids);
}
