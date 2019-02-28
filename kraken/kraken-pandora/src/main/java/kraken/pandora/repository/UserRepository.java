package kraken.pandora.repository;

import kraken.pandora.orm.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

public interface UserRepository extends JpaRepository<User, Integer>, JpaSpecificationExecutor<User> {

//	void deleteById(int userId);

    @Transactional
	@Modifying
	@Query(value = "delete from ac_user where id = :userId", nativeQuery = true)
	void deleteById(@Param("userId") int userId);


    void deleteByName(String name);

//    @Transactional
//    @Modifying
//    @Query(value = "delete from ac_user where name = :name", nativeQuery = true)
//    void deleteByName(@Param("name") String name);


    void deleteByOrgId(int id);

//    @Transactional
//    @Modifying
//    @Query(value = "delete from ac_user u left join ac_org o on u.org_id = o.id where o.id = :orgId"
//            , nativeQuery = true)
//    void deleteByOrgId(@Param("orgId") Integer orgId);

}