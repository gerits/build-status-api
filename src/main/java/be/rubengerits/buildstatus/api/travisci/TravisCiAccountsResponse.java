package be.rubengerits.buildstatus.api.travisci;

import java.util.List;

public class TravisCiAccountsResponse {

	private List<Account> accounts;

	public List<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}

}
