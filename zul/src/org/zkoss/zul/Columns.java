/* Columns.java

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Tue Oct 25 16:00:29     2005, Created by tomyeh
}}IS_NOTE

Copyright (C) 2005 Potix Corporation. All Rights Reserved.

{{IS_RIGHT
	This program is distributed under GPL Version 2.0 in the hope that
	it will be useful, but WITHOUT ANY WARRANTY.
}}IS_RIGHT
*/
package org.zkoss.zul;

import java.io.IOException;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.UiException;
import org.zkoss.zk.ui.sys.ContentRenderer;
import org.zkoss.zul.impl.HeadersElement;

/**
 * Defines the columns of a grid.
 * Each child of a columns element should be a {@link Column} element.
 * <p>Default {@link #getZclass}: z-columns.(since 3.5.0)
 *
 * @author tomyeh
 */
public class Columns extends HeadersElement implements org.zkoss.zul.api.Columns {
	private boolean _columnshide = true;
	private boolean _columnsgroup = true;
	
	/** Returns the grid that it belongs to.
	 * <p>It is the same as {@link #getParent}.
	 */
	public Grid getGrid() {
		return (Grid)getParent();
	}
	/** Returns the grid that it belongs to.
	 * <p>It is the same as {@link #getParent}.
	 * @since 3.5.2
	 */
	public org.zkoss.zul.api.Grid getGridApi() {
		return getGrid();
	}

	/**
	 * Sets whether to enable hiding of columns with the header context menu.
	 * <p>Note that it is only applied when {@link #getMenupopup()} is auto. 
	 * @since 3.5.0
	 */
	public void setColumnshide(boolean columnshide) {
		if (_columnshide != columnshide) {
			_columnshide = columnshide;
			smartUpdate("columnshide", _columnshide);
		}
	}
	/**
	 * Returns whether to enable hiding of columns with the header context menu.
	 * <p>Default: true.
	 * @since 3.5.0
	 */
	public boolean isColumnshide() {
		return _columnshide;
	}
	/**
	 * Sets whether to enable grouping of columns with the header context menu.
	 * <p>Note that it is only applied when {@link #getMenupopup()} is auto. 
	 * @since 3.5.0
	 */
	public void setColumnsgroup(boolean columnsgroup) {
		if (_columnsgroup != columnsgroup) {
			_columnsgroup = columnsgroup;
			smartUpdate("columnsgroup", _columnsgroup);
		}
	}
	/**
	 * Returns whether to enable grouping of columns with the header context menu.
	 * <p>Default: true.
	 * @since 3.5.0
	 */
	public boolean isColumnsgroup() {
		return _columnsgroup;
	}
	
	public void invalidate() {
		final Grid grid = getGrid();
		if (grid != null) grid.invalidate();
		else super.invalidate();
	}

	// super
	protected void renderProperties(org.zkoss.zk.ui.sys.ContentRenderer renderer)
	throws java.io.IOException {
		super.renderProperties(renderer);
		
		if (!_columnsgroup) 
			renderer.render("columnsgroup", false);
		if (!_columnshide) 
			renderer.render("columnshide", false);
	}
	
	//-- Component --//
	public String getZclass() {
		return _zclass == null ? "z-columns" : _zclass;
	}
	public void setParent(Component parent) {
		if (parent != null && !(parent instanceof Grid))
			throw new UiException("Unsupported parent for columns: "+parent);
		super.setParent(parent);
	}
	
	public boolean insertBefore(Component child, Component insertBefore) {
		if (!(child instanceof Column))
			throw new UiException("Unsupported child for columns: "+child);
		return super.insertBefore(child, insertBefore);
	}
}
