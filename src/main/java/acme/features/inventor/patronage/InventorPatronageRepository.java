package acme.features.inventor.patronage;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.patronage.Patronage;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface InventorPatronageRepository extends AbstractRepository{
	
	@Query("select patronage from Patronage patronage where patronage.id = :id")
	Patronage findOnePatronageById(int id);

	@Query("select patronage from Patronage patronage where patronage.inventor.id = :id and patronage.published = true")
	Collection<Patronage> findPatronagesByInventorId(int id);
	
	@Query("select patronage from Patronage patronage where patronage.inventor.id = :id and patronage.status = PROPOSED")
	Collection<Patronage> findProposedPatronageByInventorId(int id);
	
	@Query("select sc.systemCurrency from SystemConfiguration sc ")
	String findSystemCurrency();


}
