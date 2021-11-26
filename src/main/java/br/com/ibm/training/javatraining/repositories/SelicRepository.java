package br.com.ibm.training.javatraining.repositories;

import br.com.ibm.training.javatraining.entity.SelicEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SelicRepository extends JpaRepository<SelicEntity,Long> {


}
