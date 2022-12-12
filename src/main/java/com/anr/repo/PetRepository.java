package com.anr.repo;

import com.anr.model.PetDetails;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PetRepository extends ListCrudRepository<PetDetails, String> {
}
