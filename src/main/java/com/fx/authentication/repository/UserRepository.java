package com.fx.authentication.repository;

import com.fx.authentication.entity.SysUser;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface UserRepository extends Neo4jRepository<SysUser, Long> {

}
