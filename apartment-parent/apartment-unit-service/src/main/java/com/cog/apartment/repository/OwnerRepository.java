package com.cog.apartment.repository;

import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import com.cog.apartment.entity.Owner;

public interface OwnerRepository extends CrudRepository<Owner, Long> {
	
	@Query("select o from Owner o")
	List<Owner> getAllOwnerDetails();
	
	@Query("update Owner o set o.ownerName=:ownerName,o.ownerAddress=:ownerAddress,o.emailId=:emailId,o.phoneNo=:phoneNo,o.delInd=:delInd,o.updtId=:updtId,o.updtDt=:updtDt where o.ownerId=:ownerId")
	int updateOwner(@Param("ownerId") Long ownerId,
			        @Param("ownerName") String ownerName,
			        @Param("ownerAddress") String ownerAddress,
			        @Param("emailId") String emailId,
			        @Param("phoneNo") String phoneNo,
			        @Param("delInd") String delInd,
			        @Param("updtId") Long updtId,
			        @Param("updtDt") Date updtDt);
	
	@Query("update Owner o set o.delInd='Y',o.updtId=:updtId,o.updtDt=:updtDt where o.ownerId=:ownerId")
	int deleteOwner(@Param("ownerId") Long ownerId, @Param("updtId") Long updtId, @Param("updtDt") Date updtDt);
	

}
