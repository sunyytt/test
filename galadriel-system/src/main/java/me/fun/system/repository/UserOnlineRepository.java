package me.fun.system.repository;

import me.fun.system.entity.domain.UserOnline;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface UserOnlineRepository extends JpaRepository<UserOnline, Long>, JpaSpecificationExecutor<UserOnline> {

    UserOnline findByUserName(String userName);
}
