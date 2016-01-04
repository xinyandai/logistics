package org.module.server.data;

import org.module.common.po.AbstractPO;

public abstract class POfactory<T extends AbstractPO> {
	public abstract T getPO(String s);
}
