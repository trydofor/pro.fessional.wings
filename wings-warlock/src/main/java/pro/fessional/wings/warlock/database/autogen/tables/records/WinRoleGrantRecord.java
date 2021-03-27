/*
 * This file is generated by jOOQ.
 */
package pro.fessional.wings.warlock.database.autogen.tables.records;


import org.jooq.Field;
import org.jooq.Record3;
import org.jooq.Record5;
import org.jooq.Row5;
import org.jooq.impl.UpdatableRecordImpl;
import pro.fessional.wings.warlock.database.autogen.tables.WinRoleGrantTable;
import pro.fessional.wings.warlock.database.autogen.tables.interfaces.IWinRoleGrant;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;


/**
 * The table <code>wings_warlock.win_role_grant</code>.
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
@Entity
@Table(
    name = "win_role_grant",
    uniqueConstraints = {
        @UniqueConstraint(name = "KEY_win_role_grant_PRIMARY", columnNames = { "refer_role", "grant_type", "grant_entry" })
    }
)
public class WinRoleGrantRecord extends UpdatableRecordImpl<WinRoleGrantRecord> implements Record5<Long, Integer, Long, LocalDateTime, Long>, IWinRoleGrant {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>win_role_grant.refer_role</code>.
     */
    @Override
    public void setReferRole(Long value) {
        set(0, value);
    }

    /**
     * Getter for <code>win_role_grant.refer_role</code>.
     */
    @Column(name = "refer_role", nullable = false, precision = 19)
    @NotNull
    @Override
    public Long getReferRole() {
        return (Long) get(0);
    }

    /**
     * Setter for <code>win_role_grant.grant_type</code>.
     */
    @Override
    public void setGrantType(Integer value) {
        set(1, value);
    }

    /**
     * Getter for <code>win_role_grant.grant_type</code>.
     */
    @Column(name = "grant_type", nullable = false, precision = 10)
    @NotNull
    @Override
    public Integer getGrantType() {
        return (Integer) get(1);
    }

    /**
     * Setter for <code>win_role_grant.grant_entry</code>.
     */
    @Override
    public void setGrantEntry(Long value) {
        set(2, value);
    }

    /**
     * Getter for <code>win_role_grant.grant_entry</code>.
     */
    @Column(name = "grant_entry", nullable = false, precision = 19)
    @NotNull
    @Override
    public Long getGrantEntry() {
        return (Long) get(2);
    }

    /**
     * Setter for <code>win_role_grant.create_dt</code>.
     */
    @Override
    public void setCreateDt(LocalDateTime value) {
        set(3, value);
    }

    /**
     * Getter for <code>win_role_grant.create_dt</code>.
     */
    @Column(name = "create_dt", nullable = false, precision = 3)
    @Override
    public LocalDateTime getCreateDt() {
        return (LocalDateTime) get(3);
    }

    /**
     * Setter for <code>win_role_grant.commit_id</code>.
     */
    @Override
    public void setCommitId(Long value) {
        set(4, value);
    }

    /**
     * Getter for <code>win_role_grant.commit_id</code>.
     */
    @Column(name = "commit_id", nullable = false, precision = 19)
    @NotNull
    @Override
    public Long getCommitId() {
        return (Long) get(4);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record3<Long, Integer, Long> key() {
        return (Record3) super.key();
    }

    // -------------------------------------------------------------------------
    // Record5 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row5<Long, Integer, Long, LocalDateTime, Long> fieldsRow() {
        return (Row5) super.fieldsRow();
    }

    @Override
    public Row5<Long, Integer, Long, LocalDateTime, Long> valuesRow() {
        return (Row5) super.valuesRow();
    }

    @Override
    public Field<Long> field1() {
        return WinRoleGrantTable.WinRoleGrant.ReferRole;
    }

    @Override
    public Field<Integer> field2() {
        return WinRoleGrantTable.WinRoleGrant.GrantType;
    }

    @Override
    public Field<Long> field3() {
        return WinRoleGrantTable.WinRoleGrant.GrantEntry;
    }

    @Override
    public Field<LocalDateTime> field4() {
        return WinRoleGrantTable.WinRoleGrant.CreateDt;
    }

    @Override
    public Field<Long> field5() {
        return WinRoleGrantTable.WinRoleGrant.CommitId;
    }

    @Override
    public Long component1() {
        return getReferRole();
    }

    @Override
    public Integer component2() {
        return getGrantType();
    }

    @Override
    public Long component3() {
        return getGrantEntry();
    }

    @Override
    public LocalDateTime component4() {
        return getCreateDt();
    }

    @Override
    public Long component5() {
        return getCommitId();
    }

    @Override
    public Long value1() {
        return getReferRole();
    }

    @Override
    public Integer value2() {
        return getGrantType();
    }

    @Override
    public Long value3() {
        return getGrantEntry();
    }

    @Override
    public LocalDateTime value4() {
        return getCreateDt();
    }

    @Override
    public Long value5() {
        return getCommitId();
    }

    @Override
    public WinRoleGrantRecord value1(Long value) {
        setReferRole(value);
        return this;
    }

    @Override
    public WinRoleGrantRecord value2(Integer value) {
        setGrantType(value);
        return this;
    }

    @Override
    public WinRoleGrantRecord value3(Long value) {
        setGrantEntry(value);
        return this;
    }

    @Override
    public WinRoleGrantRecord value4(LocalDateTime value) {
        setCreateDt(value);
        return this;
    }

    @Override
    public WinRoleGrantRecord value5(Long value) {
        setCommitId(value);
        return this;
    }

    @Override
    public WinRoleGrantRecord values(Long value1, Integer value2, Long value3, LocalDateTime value4, Long value5) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        return this;
    }

    // -------------------------------------------------------------------------
    // FROM and INTO
    // -------------------------------------------------------------------------

    @Override
    public void from(IWinRoleGrant from) {
        setReferRole(from.getReferRole());
        setGrantType(from.getGrantType());
        setGrantEntry(from.getGrantEntry());
        setCreateDt(from.getCreateDt());
        setCommitId(from.getCommitId());
    }

    @Override
    public <E extends IWinRoleGrant> E into(E into) {
        into.from(this);
        return into;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached WinRoleGrantRecord
     */
    public WinRoleGrantRecord() {
        super(WinRoleGrantTable.WinRoleGrant);
    }

    /**
     * Create a detached, initialised WinRoleGrantRecord
     */
    public WinRoleGrantRecord(Long referRole, Integer grantType, Long grantEntry, LocalDateTime createDt, Long commitId) {
        super(WinRoleGrantTable.WinRoleGrant);

        setReferRole(referRole);
        setGrantType(grantType);
        setGrantEntry(grantEntry);
        setCreateDt(createDt);
        setCommitId(commitId);
    }
}
