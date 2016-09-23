package com.sape.order.dao.impl.mapper;

import com.sape.order.enums.AccountTypeEnum;

public class AccountTypeUserType extends EnumUserType<AccountTypeEnum> {
	public AccountTypeUserType() {
		super(AccountTypeEnum.class);
	}
}
