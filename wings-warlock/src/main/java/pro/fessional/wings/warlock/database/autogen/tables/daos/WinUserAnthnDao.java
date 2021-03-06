/*
 * This file is generated by jOOQ.
 */
package pro.fessional.wings.warlock.database.autogen.tables.daos;


import org.jooq.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pro.fessional.wings.faceless.database.jooq.WingsJooqDaoJournalImpl;
import pro.fessional.wings.warlock.database.autogen.tables.WinUserAnthnTable;
import pro.fessional.wings.warlock.database.autogen.tables.pojos.WinUserAnthn;
import pro.fessional.wings.warlock.database.autogen.tables.records.WinUserAnthnRecord;

import javax.annotation.Generated;
import java.time.LocalDateTime;
import java.util.List;


/**
 * The table <code>wings_warlock.win_user_anthn</code>.
 */
@Generated(
    value = {
        "https://www.jooq.org",
        "jOOQ version:3.14.4",
        "schema version:2020102402"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
@Repository
public class WinUserAnthnDao extends WingsJooqDaoJournalImpl<WinUserAnthnTable, WinUserAnthnRecord, WinUserAnthn, Long> {

    /**
     * Create a new WinUserAnthnDao without any configuration
     */
    public WinUserAnthnDao() {
        super(WinUserAnthnTable.WinUserAnthn, WinUserAnthn.class);
    }

    /**
     * Create a new WinUserAnthnDao with an attached configuration
     */
    @Autowired
    public WinUserAnthnDao(Configuration configuration) {
        super(WinUserAnthnTable.WinUserAnthn, WinUserAnthn.class, configuration);
    }

    @Override
    public Long getId(WinUserAnthn object) {
        return object.getId();
    }

    /**
     * Fetch records that have <code>id BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<WinUserAnthn> fetchRangeOfId(Long lowerInclusive, Long upperInclusive) {
        return fetchRange(WinUserAnthnTable.WinUserAnthn.Id, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>id IN (values)</code>
     */
    public List<WinUserAnthn> fetchById(Long... values) {
        return fetch(WinUserAnthnTable.WinUserAnthn.Id, values);
    }

    /**
     * Fetch a unique record that has <code>id = value</code>
     */
    public WinUserAnthn fetchOneById(Long value) {
        return fetchOne(WinUserAnthnTable.WinUserAnthn.Id, value);
    }

    /**
     * Fetch records that have <code>create_dt BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<WinUserAnthn> fetchRangeOfCreateDt(LocalDateTime lowerInclusive, LocalDateTime upperInclusive) {
        return fetchRange(WinUserAnthnTable.WinUserAnthn.CreateDt, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>create_dt IN (values)</code>
     */
    public List<WinUserAnthn> fetchByCreateDt(LocalDateTime... values) {
        return fetch(WinUserAnthnTable.WinUserAnthn.CreateDt, values);
    }

    /**
     * Fetch records that have <code>modify_dt BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<WinUserAnthn> fetchRangeOfModifyDt(LocalDateTime lowerInclusive, LocalDateTime upperInclusive) {
        return fetchRange(WinUserAnthnTable.WinUserAnthn.ModifyDt, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>modify_dt IN (values)</code>
     */
    public List<WinUserAnthn> fetchByModifyDt(LocalDateTime... values) {
        return fetch(WinUserAnthnTable.WinUserAnthn.ModifyDt, values);
    }

    /**
     * Fetch records that have <code>delete_dt BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<WinUserAnthn> fetchRangeOfDeleteDt(LocalDateTime lowerInclusive, LocalDateTime upperInclusive) {
        return fetchRange(WinUserAnthnTable.WinUserAnthn.DeleteDt, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>delete_dt IN (values)</code>
     */
    public List<WinUserAnthn> fetchByDeleteDt(LocalDateTime... values) {
        return fetch(WinUserAnthnTable.WinUserAnthn.DeleteDt, values);
    }

    /**
     * Fetch records that have <code>commit_id BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<WinUserAnthn> fetchRangeOfCommitId(Long lowerInclusive, Long upperInclusive) {
        return fetchRange(WinUserAnthnTable.WinUserAnthn.CommitId, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>commit_id IN (values)</code>
     */
    public List<WinUserAnthn> fetchByCommitId(Long... values) {
        return fetch(WinUserAnthnTable.WinUserAnthn.CommitId, values);
    }

    /**
     * Fetch records that have <code>user_id BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<WinUserAnthn> fetchRangeOfUserId(Long lowerInclusive, Long upperInclusive) {
        return fetchRange(WinUserAnthnTable.WinUserAnthn.UserId, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>user_id IN (values)</code>
     */
    public List<WinUserAnthn> fetchByUserId(Long... values) {
        return fetch(WinUserAnthnTable.WinUserAnthn.UserId, values);
    }

    /**
     * Fetch records that have <code>auth_type BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<WinUserAnthn> fetchRangeOfAuthType(String lowerInclusive, String upperInclusive) {
        return fetchRange(WinUserAnthnTable.WinUserAnthn.AuthType, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>auth_type IN (values)</code>
     */
    public List<WinUserAnthn> fetchByAuthType(String... values) {
        return fetch(WinUserAnthnTable.WinUserAnthn.AuthType, values);
    }

    /**
     * Fetch records that have <code>username BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<WinUserAnthn> fetchRangeOfUsername(String lowerInclusive, String upperInclusive) {
        return fetchRange(WinUserAnthnTable.WinUserAnthn.Username, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>username IN (values)</code>
     */
    public List<WinUserAnthn> fetchByUsername(String... values) {
        return fetch(WinUserAnthnTable.WinUserAnthn.Username, values);
    }

    /**
     * Fetch records that have <code>password BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<WinUserAnthn> fetchRangeOfPassword(String lowerInclusive, String upperInclusive) {
        return fetchRange(WinUserAnthnTable.WinUserAnthn.Password, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>password IN (values)</code>
     */
    public List<WinUserAnthn> fetchByPassword(String... values) {
        return fetch(WinUserAnthnTable.WinUserAnthn.Password, values);
    }

    /**
     * Fetch records that have <code>extra_para BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<WinUserAnthn> fetchRangeOfExtraPara(String lowerInclusive, String upperInclusive) {
        return fetchRange(WinUserAnthnTable.WinUserAnthn.ExtraPara, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>extra_para IN (values)</code>
     */
    public List<WinUserAnthn> fetchByExtraPara(String... values) {
        return fetch(WinUserAnthnTable.WinUserAnthn.ExtraPara, values);
    }

    /**
     * Fetch records that have <code>extra_user BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<WinUserAnthn> fetchRangeOfExtraUser(String lowerInclusive, String upperInclusive) {
        return fetchRange(WinUserAnthnTable.WinUserAnthn.ExtraUser, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>extra_user IN (values)</code>
     */
    public List<WinUserAnthn> fetchByExtraUser(String... values) {
        return fetch(WinUserAnthnTable.WinUserAnthn.ExtraUser, values);
    }

    /**
     * Fetch records that have <code>expired_dt BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<WinUserAnthn> fetchRangeOfExpiredDt(LocalDateTime lowerInclusive, LocalDateTime upperInclusive) {
        return fetchRange(WinUserAnthnTable.WinUserAnthn.ExpiredDt, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>expired_dt IN (values)</code>
     */
    public List<WinUserAnthn> fetchByExpiredDt(LocalDateTime... values) {
        return fetch(WinUserAnthnTable.WinUserAnthn.ExpiredDt, values);
    }

    /**
     * Fetch records that have <code>failed_cnt BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<WinUserAnthn> fetchRangeOfFailedCnt(Integer lowerInclusive, Integer upperInclusive) {
        return fetchRange(WinUserAnthnTable.WinUserAnthn.FailedCnt, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>failed_cnt IN (values)</code>
     */
    public List<WinUserAnthn> fetchByFailedCnt(Integer... values) {
        return fetch(WinUserAnthnTable.WinUserAnthn.FailedCnt, values);
    }

    /**
     * Fetch records that have <code>failed_max BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<WinUserAnthn> fetchRangeOfFailedMax(Integer lowerInclusive, Integer upperInclusive) {
        return fetchRange(WinUserAnthnTable.WinUserAnthn.FailedMax, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>failed_max IN (values)</code>
     */
    public List<WinUserAnthn> fetchByFailedMax(Integer... values) {
        return fetch(WinUserAnthnTable.WinUserAnthn.FailedMax, values);
    }


    /**
     * Fetch records that have <code>id BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<WinUserAnthn> fetchRangeOfIdLive(Long lowerInclusive, Long upperInclusive) {
        return fetchRangeLive(WinUserAnthnTable.WinUserAnthn.Id, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>id IN (values)</code>
     */
    public List<WinUserAnthn> fetchByIdLive(Long... values) {
        return fetchLive(WinUserAnthnTable.WinUserAnthn.Id, values);
    }

    /**
     * Fetch a unique record that has <code>id = value</code>
     */
    public WinUserAnthn fetchOneByIdLive(Long value) {
        return fetchOneLive(WinUserAnthnTable.WinUserAnthn.Id, value);
    }

    /**
     * Fetch records that have <code>create_dt BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<WinUserAnthn> fetchRangeOfCreateDtLive(LocalDateTime lowerInclusive, LocalDateTime upperInclusive) {
        return fetchRangeLive(WinUserAnthnTable.WinUserAnthn.CreateDt, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>create_dt IN (values)</code>
     */
    public List<WinUserAnthn> fetchByCreateDtLive(LocalDateTime... values) {
        return fetchLive(WinUserAnthnTable.WinUserAnthn.CreateDt, values);
    }

    /**
     * Fetch records that have <code>modify_dt BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<WinUserAnthn> fetchRangeOfModifyDtLive(LocalDateTime lowerInclusive, LocalDateTime upperInclusive) {
        return fetchRangeLive(WinUserAnthnTable.WinUserAnthn.ModifyDt, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>modify_dt IN (values)</code>
     */
    public List<WinUserAnthn> fetchByModifyDtLive(LocalDateTime... values) {
        return fetchLive(WinUserAnthnTable.WinUserAnthn.ModifyDt, values);
    }

    /**
     * Fetch records that have <code>delete_dt BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<WinUserAnthn> fetchRangeOfDeleteDtLive(LocalDateTime lowerInclusive, LocalDateTime upperInclusive) {
        return fetchRangeLive(WinUserAnthnTable.WinUserAnthn.DeleteDt, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>delete_dt IN (values)</code>
     */
    public List<WinUserAnthn> fetchByDeleteDtLive(LocalDateTime... values) {
        return fetchLive(WinUserAnthnTable.WinUserAnthn.DeleteDt, values);
    }

    /**
     * Fetch records that have <code>commit_id BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<WinUserAnthn> fetchRangeOfCommitIdLive(Long lowerInclusive, Long upperInclusive) {
        return fetchRangeLive(WinUserAnthnTable.WinUserAnthn.CommitId, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>commit_id IN (values)</code>
     */
    public List<WinUserAnthn> fetchByCommitIdLive(Long... values) {
        return fetchLive(WinUserAnthnTable.WinUserAnthn.CommitId, values);
    }

    /**
     * Fetch records that have <code>user_id BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<WinUserAnthn> fetchRangeOfUserIdLive(Long lowerInclusive, Long upperInclusive) {
        return fetchRangeLive(WinUserAnthnTable.WinUserAnthn.UserId, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>user_id IN (values)</code>
     */
    public List<WinUserAnthn> fetchByUserIdLive(Long... values) {
        return fetchLive(WinUserAnthnTable.WinUserAnthn.UserId, values);
    }

    /**
     * Fetch records that have <code>auth_type BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<WinUserAnthn> fetchRangeOfAuthTypeLive(String lowerInclusive, String upperInclusive) {
        return fetchRangeLive(WinUserAnthnTable.WinUserAnthn.AuthType, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>auth_type IN (values)</code>
     */
    public List<WinUserAnthn> fetchByAuthTypeLive(String... values) {
        return fetchLive(WinUserAnthnTable.WinUserAnthn.AuthType, values);
    }

    /**
     * Fetch records that have <code>username BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<WinUserAnthn> fetchRangeOfUsernameLive(String lowerInclusive, String upperInclusive) {
        return fetchRangeLive(WinUserAnthnTable.WinUserAnthn.Username, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>username IN (values)</code>
     */
    public List<WinUserAnthn> fetchByUsernameLive(String... values) {
        return fetchLive(WinUserAnthnTable.WinUserAnthn.Username, values);
    }

    /**
     * Fetch records that have <code>password BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<WinUserAnthn> fetchRangeOfPasswordLive(String lowerInclusive, String upperInclusive) {
        return fetchRangeLive(WinUserAnthnTable.WinUserAnthn.Password, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>password IN (values)</code>
     */
    public List<WinUserAnthn> fetchByPasswordLive(String... values) {
        return fetchLive(WinUserAnthnTable.WinUserAnthn.Password, values);
    }

    /**
     * Fetch records that have <code>extra_para BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<WinUserAnthn> fetchRangeOfExtraParaLive(String lowerInclusive, String upperInclusive) {
        return fetchRangeLive(WinUserAnthnTable.WinUserAnthn.ExtraPara, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>extra_para IN (values)</code>
     */
    public List<WinUserAnthn> fetchByExtraParaLive(String... values) {
        return fetchLive(WinUserAnthnTable.WinUserAnthn.ExtraPara, values);
    }

    /**
     * Fetch records that have <code>extra_user BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<WinUserAnthn> fetchRangeOfExtraUserLive(String lowerInclusive, String upperInclusive) {
        return fetchRangeLive(WinUserAnthnTable.WinUserAnthn.ExtraUser, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>extra_user IN (values)</code>
     */
    public List<WinUserAnthn> fetchByExtraUserLive(String... values) {
        return fetchLive(WinUserAnthnTable.WinUserAnthn.ExtraUser, values);
    }

    /**
     * Fetch records that have <code>expired_dt BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<WinUserAnthn> fetchRangeOfExpiredDtLive(LocalDateTime lowerInclusive, LocalDateTime upperInclusive) {
        return fetchRangeLive(WinUserAnthnTable.WinUserAnthn.ExpiredDt, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>expired_dt IN (values)</code>
     */
    public List<WinUserAnthn> fetchByExpiredDtLive(LocalDateTime... values) {
        return fetchLive(WinUserAnthnTable.WinUserAnthn.ExpiredDt, values);
    }

    /**
     * Fetch records that have <code>failed_cnt BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<WinUserAnthn> fetchRangeOfFailedCntLive(Integer lowerInclusive, Integer upperInclusive) {
        return fetchRangeLive(WinUserAnthnTable.WinUserAnthn.FailedCnt, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>failed_cnt IN (values)</code>
     */
    public List<WinUserAnthn> fetchByFailedCntLive(Integer... values) {
        return fetchLive(WinUserAnthnTable.WinUserAnthn.FailedCnt, values);
    }

    /**
     * Fetch records that have <code>failed_max BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<WinUserAnthn> fetchRangeOfFailedMaxLive(Integer lowerInclusive, Integer upperInclusive) {
        return fetchRangeLive(WinUserAnthnTable.WinUserAnthn.FailedMax, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>failed_max IN (values)</code>
     */
    public List<WinUserAnthn> fetchByFailedMaxLive(Integer... values) {
        return fetchLive(WinUserAnthnTable.WinUserAnthn.FailedMax, values);
    }
}
