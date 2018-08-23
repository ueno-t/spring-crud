package jp.scriptkidie.users.infrastructure.entity.auditing;

public interface Auditable {

	Audit getAudit();

	void setAudit(Audit audit);
}
