package kr.flab.ottsharing.notification.infrastructure.reader;

import kr.flab.ottsharing.notification.domain.ReadUserModel;
import kr.flab.ottsharing.notification.domain.UserReader;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.SqlSessionTemplate;


@Mapper
public class MyBatisUserReader implements UserReader {

    private final SqlSessionTemplate template;

    public MyBatisUserReader(SqlSessionTemplate template) {
        this.template = template;
    }

    @Override
    public ReadUserModel getUserByEmail(String email) {
        return template.getMapper(UserReader.class).getUserByEmail(email);

    }
}
