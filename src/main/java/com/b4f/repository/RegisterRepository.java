package com.b4f.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.b4f.entity.Register;

@Repository
public interface RegisterRepository extends JpaRepository<Register, Integer> {

	@Query("SELECT p FROM Register p WHERE " + "p.bloodGroup = :bloodGroup AND "
			+ "LOWER(p.userCountry) LIKE LOWER(CONCAT('%', :country, '%')) AND "
			+ "LOWER(p.userState) LIKE LOWER(CONCAT('%', :state, '%')) AND "
			+ "LOWER(p.userDistrict) LIKE LOWER(CONCAT('%', :district, '%')) AND "
			+ "LOWER(p.userCity) LIKE LOWER(CONCAT('%', :city, '%'))")
	List<Register> findDonorDetails(@Param("bloodGroup") String bloodGroup, @Param("country") String country,
			@Param("state") String state, @Param("district") String district, @Param("city") String city);

}
