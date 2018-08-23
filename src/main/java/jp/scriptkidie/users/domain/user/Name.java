package jp.scriptkidie.users.domain.user;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class Name {

	private String nameKana;
	private String nameKanji;
}
