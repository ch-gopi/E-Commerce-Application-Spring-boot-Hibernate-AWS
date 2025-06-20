package dev.Gopi.productservice.inheritance.tableperclass;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("tpc_ur")
public interface UserRepository
extends JpaRepository<User, Long> {

    @Override
    <S extends User> S save(S entity);
}
