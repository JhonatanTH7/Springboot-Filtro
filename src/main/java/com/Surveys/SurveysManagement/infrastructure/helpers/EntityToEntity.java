package com.Surveys.SurveysManagement.infrastructure.helpers;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import org.springframework.beans.BeanUtils;

public class EntityToEntity {

    public static <FROM_ENTITY, TO_ENTITY> TO_ENTITY entityToEntity(FROM_ENTITY from_Entity,
            Class<TO_ENTITY> to_Entity) {
        Constructor<TO_ENTITY> constructor;
        TO_ENTITY entity;
        try {
            constructor = to_Entity.getDeclaredConstructor();
            entity = constructor.newInstance();
            BeanUtils.copyProperties(from_Entity, entity);
            return entity;
        } catch (InstantiationException | IllegalAccessException | IllegalArgumentException
                | InvocationTargetException | NoSuchMethodException | SecurityException e) {
            System.out.println("ERROR >>>>>>>>>>> " + e.getMessage());
        }
        return null;
    }

}
