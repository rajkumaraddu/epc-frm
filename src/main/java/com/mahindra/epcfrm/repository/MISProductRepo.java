/**
 * 
 */
package com.mahindra.epcfrm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mahindra.epcfrm.entity.MISProductEntity;

/**
 * @author Raju.Addu
 *
 */
@Repository
public interface MISProductRepo extends JpaRepository<MISProductEntity, Integer> {

}
