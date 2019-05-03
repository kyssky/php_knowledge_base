package org.ksql.script.builder;

import org.ksql.script.annotation.Delete;
import org.ksql.script.annotation.Insert;
import org.ksql.script.annotation.Select;
import org.ksql.script.annotation.Update;
import org.ksql.script.bo.MapperMethod;
import org.ksql.script.bo.SqlType;
import org.mirror.reflection.agent.MethodAgent;


public class DefaultMapperMethodBuilder implements MapperMethodBuilder {

    @Override
    public MapperMethod builder(MethodAgent methodAgent) {
        MapperMethod mapperMethod = new MapperMethod();
        initBaseSql(methodAgent,mapperMethod);

        return mapperMethod;
    }

    private void initBaseSql(MethodAgent methodAgent, MapperMethod mapperMethod) {
        if(methodAgent.hasAnnotation(Select.class)){
            mapperMethod.setBaseSql(methodAgent.getAnnotation(Select.class).value());
            mapperMethod.setSqlType(SqlType.SELECT);
        }else if(methodAgent.hasAnnotation(Update.class)){
            mapperMethod.setBaseSql(methodAgent.getAnnotation(Update.class).value());
            mapperMethod.setSqlType(SqlType.SELECT);
        }else if(methodAgent.hasAnnotation(Insert.class)){
            mapperMethod.setBaseSql(methodAgent.getAnnotation(Insert.class).value());
            mapperMethod.setSqlType(SqlType.SELECT);
        }else if(methodAgent.hasAnnotation(Delete.class)){
            mapperMethod.setBaseSql(methodAgent.getAnnotation(Delete.class).value());
            mapperMethod.setSqlType(SqlType.SELECT);
        }
    }
}