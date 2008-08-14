/* This code is part of Freenet. It is distributed under the GNU General
 * Public License, version 2 (or at your option any later version). See
 * http://www.gnu.org/ for further details of the GPL. */
package freenet.config;

import freenet.l10n.L10n;
import freenet.support.api.BooleanCallback;

public class BooleanOption extends Option<Boolean, BooleanCallback> {
	public BooleanOption(SubConfig conf, String optionName, boolean defaultValue, int sortOrder, 
			boolean expert, boolean forceWrite, String shortDesc, String longDesc, BooleanCallback cb) {
		super(conf, optionName, cb, sortOrder, expert, forceWrite, shortDesc, longDesc, Option.DataType.BOOLEAN);
		this.defaultValue = defaultValue;
		this.currentValue = defaultValue;
	}

	public Boolean parseString(String val) throws InvalidConfigValueException {
		if(val.equalsIgnoreCase("true") || val.equalsIgnoreCase("yes")) {
			return true;
		} else if(val.equalsIgnoreCase("false") || val.equalsIgnoreCase("no")) {
			return false;
		} else
			throw new OptionFormatException(L10n.getString("BooleanOption.parseError", "val", val));
	}

	@Override
	protected String toString(Boolean val) {
		return val.toString();
	}
}
