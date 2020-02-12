package ru.gbuac.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import ru.gbuac.model.Doc;
import ru.gbuac.model.DocStatus;
import ru.gbuac.to.DocNumberTo;

import java.time.LocalDate;
import java.util.List;

@Transactional(readOnly = true)
public interface DocRepository extends JpaRepository<Doc, Integer> {
    @Transactional
    @Modifying
    @Query("DELETE FROM Doc d WHERE d.id=:id")
    int delete(@Param("id") int id);

    @Query("SELECT DISTINCT d FROM Doc d LEFT JOIN d.resolutions r LEFT JOIN r.resolutionsUsers ru " +
            "WHERE lower(ru.user.name)=lower(:userName) AND d.docStatus='IN_WORK' ORDER BY d.id")
    List<Doc> getAllInWorkByUserName(@Param("userName") String userName);

    @Query("SELECT DISTINCT d FROM Doc d LEFT JOIN d.resolutions r LEFT JOIN r.resolutionsUsers ru " +
            "WHERE (r.controlDate>:deadline OR r.controlDate IS NULL) " +
            "AND (lower(ru.user.name)=lower(:userName) OR r.department.id=:departmentId) AND " +
            "d.docStatus='IN_WORK' ORDER BY d.id")
    List<Doc> getAllInWorkMoreDeadline(@Param("userName") String userName,
                                       @Param("departmentId") int departmentId, @Param("deadline") LocalDate deadline);

    @Query("SELECT DISTINCT d FROM Doc d LEFT JOIN d.resolutions r LEFT JOIN r.resolutionsUsers ru " +
            "WHERE r.controlDate<=:deadline " +
            "AND (lower(ru.user.name)=lower(:userName) OR r.department.id=:departmentId) AND " +
            "d.docStatus='IN_WORK' ORDER BY d.id")
    List<Doc> getAllInWorkLessDeadline(@Param("userName") String userName,
                                       @Param("departmentId") int departmentId, @Param("deadline") LocalDate deadline);

    @Query("SELECT DISTINCT new ru.gbuac.to.DocItemTo(d.id, d.docStatus, d.regNum, d.regDateTime, d.projectRegNum, d.projectRegDateTime, " +
            " CONCAT(a.user.lastname, ' ', a.user.firstname, ' ', a.user.patronym), " +
            "d.docType.name) FROM Doc d JOIN d.agreementList a JOIN a.user WHERE " +
            "lower(a.user.name)=lower(:userName) AND a.currentUser=TRUE AND d.docStatus='IN_AGREEMENT' ORDER BY d.id")
    List<Doc> getAllAgreementByUserName(@Param("userName") String userName);

    @Query("SELECT DISTINCT new ru.gbuac.to.DocItemTo(d.id, d.docStatus, d.regNum, d.regDateTime, d.projectRegNum, d.projectRegDateTime, " +
            " CONCAT(a.user.lastname, ' ', a.user.firstname, ' ', a.user.patronym), " +
            "d.docType.name) FROM Doc d JOIN d.agreementList a JOIN a.user LEFT JOIN d.parentDoc pd " +
            "LEFT JOIN pd.resolutions r WHERE " +
            "(r.controlDate>:deadline OR r.controlDate IS NULL) " +
            "AND (lower(a.user.name)=lower(:userName) OR r.department.id=:departmentId) " +
            "AND a.currentUser=TRUE AND d.docStatus='IN_AGREEMENT' ORDER BY d.id")
    List<Doc> getAllAgreementMoreDeadline(@Param("userName") String userName,
                                          @Param("departmentId") int departmentId, @Param("deadline") LocalDate deadline);

    @Query("SELECT DISTINCT new ru.gbuac.to.DocItemTo(d.id, d.docStatus, d.regNum, d.regDateTime, d.projectRegNum, d.projectRegDateTime, " +
            " CONCAT(a.user.lastname, ' ', a.user.firstname, ' ', a.user.patronym), " +
            "d.docType.name) FROM Doc d JOIN d.agreementList a JOIN a.user LEFT JOIN d.parentDoc pd " +
            "LEFT JOIN pd.resolutions r WHERE " +
            "r.controlDate<=:deadline " +
            "AND (lower(a.user.name)=lower(:userName) OR r.department.id=:departmentId) " +
            "AND a.currentUser=TRUE AND d.docStatus='IN_AGREEMENT' ORDER BY d.id")
    List<Doc> getAllAgreementLessDeadline(@Param("userName") String userName, @Param("departmentId") int departmentId,
                                          @Param("deadline") LocalDate deadline);

    @Query("SELECT DISTINCT new ru.gbuac.to.DocItemTo(d.id, d.docStatus, d.regNum, d.regDateTime, d.projectRegNum, d.projectRegDateTime, " +
            "(SELECT CONCAT(a.user.lastname, ' ', a.user.firstname, ' ', a.user.patronym) FROM d.agreementList a " +
            "WHERE a.currentUser=TRUE), d.docType.name) FROM Doc d JOIN d.agreementList c WHERE " +
            "(lower(c.user.name)=lower(:userName) AND c.decisionType IS NOT NULL) OR lower(d.initialUser.name)=lower(:userName) AND " +
            "d.docStatus<>'DELETED' ORDER BY d.id")
    List<Doc> getAllAgreedByUserName(@Param("userName") String userName);

    @Query("SELECT DISTINCT new ru.gbuac.to.DocItemTo(d.id, d.docStatus, d.regNum, d.regDateTime, d.projectRegNum, d.projectRegDateTime, " +
            "(SELECT CONCAT(a.user.lastname, ' ', a.user.firstname, ' ', a.user.patronym) FROM d.agreementList a " +
            "WHERE a.currentUser=TRUE), d.docType.name) FROM Doc d JOIN d.agreementList c WHERE " +
            "((lower(c.user.name)=lower(:userName) AND c.decisionType IS NOT NULL) OR lower(d.initialUser.name)=lower(:userName)) " +
            "AND d.docStatus<>'IN_AGREEMENT' ORDER BY d.id")
    List<Doc> getAllRegisteredByUserName(@Param("userName") String userName);

    @Query("SELECT DISTINCT d FROM Doc d LEFT JOIN d.resolutions r LEFT JOIN r.department dep " +
            "LEFT JOIN r.resolutionsUsers ru WHERE d.docStatus<>'DELETED' ORDER BY d.id")
    List<Doc> getAll();

    @Query("SELECT d FROM Doc d WHERE d.docType.id=:docTypeId AND d.docStatus<>'DELETED'")
    List<Doc> getAllByDocType(@Param("docTypeId") int docTypeId);

    @Query("SELECT DISTINCT new ru.gbuac.to.DocItemTo(d.id, d.docStatus, d.regNum, d.regDateTime, d.projectRegNum, d.projectRegDateTime, " +
            "(SELECT CONCAT(a.user.lastname, ' ', a.user.firstname, ' ', a.user.patronym) FROM d.agreementList a " +
            "WHERE a.currentUser=TRUE), d.docType.name) FROM Doc d WHERE d.docStatus='IN_AGREEMENT' ORDER BY d.id")
    List<Doc> getAllAgreement();

    @Query("SELECT DISTINCT new ru.gbuac.to.DocItemTo(d.id, d.docStatus, d.regNum, d.regDateTime, d.projectRegNum, d.projectRegDateTime, " +
            "(SELECT CONCAT(a.user.lastname, ' ', a.user.firstname, ' ', a.user.patronym) FROM d.agreementList a " +
            "WHERE a.currentUser=TRUE), d.docType.name) FROM Doc d WHERE d.docStatus<>'IN_AGREEMENT' ORDER BY d.id")
    List<Doc> getAllRegistered();

    @Query("SELECT DISTINCT d FROM Doc d LEFT JOIN d.resolutions r LEFT JOIN r.department dep LEFT JOIN r.resolutionsUsers ru " +
            "WHERE dep.id=:departmentId AND ru.id IS NULL AND d.docStatus='IN_WORK' ORDER BY d.id")
    List<Doc> getAllDistribution(@Param("departmentId") int departmentId);

    @Query("SELECT DISTINCT d FROM Doc d LEFT JOIN d.resolutions r LEFT JOIN r.department dep LEFT JOIN r.resolutionsUsers ru " +
            "WHERE (r.controlDate>:deadline OR r.controlDate IS NULL) AND dep.id=:departmentId AND " +
            "ru.id IS NULL AND d.docStatus='IN_WORK' ORDER BY d.id")
    List<Doc> getAllDistributionMoreDeadline(@Param("departmentId") int departmentId, @Param("deadline") LocalDate deadline);

    @Query("SELECT DISTINCT d FROM Doc d LEFT JOIN d.resolutions r LEFT JOIN r.department dep LEFT JOIN r.resolutionsUsers ru " +
            "WHERE r.controlDate<=:deadline AND dep.id=:departmentId AND " +
            "ru.id IS NULL AND d.docStatus='IN_WORK' ORDER BY d.id")
    List<Doc> getAllDistributionLessDeadline(@Param("departmentId") int departmentId, @Param("deadline") LocalDate deadline);

    @Query("SELECT DISTINCT d FROM Doc d LEFT JOIN d.resolutions r LEFT JOIN r.department dep LEFT JOIN r.resolutionsUsers ru " +
            "WHERE dep.id=:departmentId AND ru.id IS NOT NULL AND d.docStatus='IN_WORK' ORDER BY d.id")
    List<Doc> getAllDistributed(@Param("departmentId") int departmentId);

    @Query("SELECT DISTINCT d FROM Doc d LEFT JOIN d.resolutions r LEFT JOIN r.department dep LEFT JOIN r.resolutionsUsers ru " +
            "WHERE ru.user.name=:userName AND r.controlDate>=:mounthAgo AND r.controlDate<=:today AND d.docStatus<>'DELETED' ORDER BY d.id")
    List<Doc> getAllAtThisMounthOnControl(@Param("userName") String userName, @Param("today") LocalDate today,
                                          @Param("mounthAgo") LocalDate mounthAgo);

    @Query("SELECT DISTINCT d FROM Doc d LEFT JOIN d.resolutions r LEFT JOIN r.department dep LEFT JOIN r.resolutionsUsers ru " +
            "WHERE ru.user.name=:userName AND r.controlDate>=:mounthAgo AND r.controlDate<:today " +
            "AND r.executionDateTime <= r.controlDate AND d.docStatus<>'DELETED' ORDER BY d.id")
    List<Doc> getAllAtThisMounthOnControlCompletedInTime(@Param("userName") String userName, @Param("today") LocalDate today,
                                          @Param("mounthAgo") LocalDate mounthAgo);

    @Query("SELECT DISTINCT d FROM Doc d LEFT JOIN d.resolutions r LEFT JOIN r.department dep LEFT JOIN r.resolutionsUsers ru " +
            "WHERE ru.user.name=:userName AND r.controlDate>=:mounthAgo AND r.controlDate<:today " +
            "AND r.executionDateTime > r.controlDate AND d.docStatus<>'DELETED' ORDER BY d.id")
    List<Doc> getAllAtThisMounthOnControlCompletedAfterTime(@Param("userName") String userName, @Param("today") LocalDate today,
                                                   @Param("mounthAgo") LocalDate mounthAgo);

    @Query("SELECT DISTINCT d FROM Doc d LEFT JOIN d.resolutions r LEFT JOIN r.department dep LEFT JOIN r.resolutionsUsers ru " +
            "WHERE ru.user.name=:userName AND r.controlDate<:today " +
            "AND r.executionDateTime is NULL AND d.docStatus<>'DELETED' ORDER BY d.id")
    List<Doc> getAllAtThisMounthOnControlNotCompleted(@Param("userName") String userName, @Param("today") LocalDate today);

    @Query("SELECT new ru.gbuac.to.DocNumberTo(d.id, d.regNum) FROM Doc d WHERE d.regNum IS NOT NULL AND " +
            "d.docStatus<>'DELETED' ORDER BY d.regNum")
    List<DocNumberTo> getRegNumbers();

    @Query("SELECT d.docType.id FROM Doc d WHERE d.id=:id")
    int getDocTypeByDocId(@Param("id") int id);

    @Query("SELECT d.docStatus FROM Doc d WHERE d.id=:id")
    DocStatus getDocStatusByDocId(@Param("id") int id);

    @Transactional
    @Modifying
    @Query("UPDATE Doc d SET d.docStatus=:docStatus WHERE d.id=:id")
    void setDocStatusByDocId(@Param("id") int id, @Param("docStatus") DocStatus docStatus);

    @Transactional
    @Modifying
    @Query("UPDATE Doc d SET d.urlPDF=:urlPdf WHERE d.id=:id")
    void setUrlPDF(@Param("id") int id, @Param("urlPdf") String urlPdf);
}
