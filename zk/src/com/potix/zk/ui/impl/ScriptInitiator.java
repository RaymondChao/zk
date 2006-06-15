/* ScriptInitiator.java

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Thu May 25 10:50:36     2006, Created by tomyeh@potix.com
}}IS_NOTE

Copyright (C) 2006 Potix Corporation. All Rights Reserved.

{{IS_RIGHT
	This program is distributed under GPL Version 2.0 in the hope that
	it will be useful, but WITHOUT ANY WARRANTY.
}}IS_RIGHT
*/
package com.potix.zk.ui.impl;

import com.potix.zk.ui.Page;
import com.potix.zk.ui.metainfo.Script;
import com.potix.zk.ui.util.Initiator;
import com.potix.zk.ui.util.Namespace;
import com.potix.zk.ui.util.Namespaces;

/**
 * An initiator used to evaluate a zscript file.
 *
 * @author <a href="mailto:tomyeh@potix.com">tomyeh@potix.com</a>
 */
public class ScriptInitiator implements Initiator {
	private final Script _script;

	public ScriptInitiator(Script script) {
		if (script == null) throw new IllegalArgumentException("null");
		_script = script;
	}
	public void doInit(Page page, Object[] args) throws Exception {
		final Namespace ns = Namespaces.beforeInterpret(null, page);
		try {
			page.interpret(_script.getScript(), ns);
		} finally {
			Namespaces.afterInterpret(ns);
		}
	}
	public void doCatch(Throwable ex) {
	}
	public void doFinally() {
	}
}
