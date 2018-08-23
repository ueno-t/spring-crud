package jp.scriptkidie.users.infrastructure.entity.auditing;

import java.util.Date;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

public class AuditListener {

    @PrePersist
    public void setCreatedOn(Auditable auditable) {
        Audit audit = auditable.getAudit();

        if(audit == null) {
            audit = new Audit();
            auditable.setAudit(audit);
        }

        audit.setCreateDate(new Date());
        audit.setCreateUserId("");
        audit.setUpdateDate(new Date());
        audit.setUpdateUserId("");
    }

    @PreUpdate
    public void setUpdadtedOn(Auditable auditable) {
        Audit audit = auditable.getAudit();

        if(audit == null) {
            audit = new Audit();
            auditable.setAudit(audit);
        }

        audit.setUpdateDate(new Date());
        audit.setUpdateUserId("");
    }
}
