package com.mycompany.projectmanagement.repository;

import com.mycompany.projectmanagement.entity.PropertyEntity;
import org.springframework.data.repository.CrudRepository;
// CrudRepoistory has already definee methods which we can reused not need to implements
                                            //<name of entity, PK data type >
public interface PropertyRepository extends CrudRepository<PropertyEntity,Long> {

}
