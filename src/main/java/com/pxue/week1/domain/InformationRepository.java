package com.pxue.week1.domain;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

//public interface InformationRepository extends CrudRepository<Information, Long> {
public interface InformationRepository extends JpaRepository<Information, Long> {
    Page<Information> findByRunningId(@Param("runningId") String runningId, Pageable pageable);
    //Page<Information> findByhealthWarningLevelDecrease(@Param("healthWarningLevel") String healthWarningLevel, Pageable pageable);
    void deleteByRunningId(@Param("runingId") String runningId);
}
