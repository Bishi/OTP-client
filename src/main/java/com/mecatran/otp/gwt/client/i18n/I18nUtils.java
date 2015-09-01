/* -------------------------------------------------------------------------
    OpenTripPlanner GWT Client
    Copyright (C) 2015 Mecatran - info@mecatran.com

    This program is free software; you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation; either version 2 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License along
    with this program; if not, write to the Free Software Foundation, Inc.,
    51 Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA.
   ------------------------------------------------------------------------- */
package com.mecatran.otp.gwt.client.i18n;

public class I18nUtils {

	private static OpenTripPlannerClientMessages messages;

	static public void setLocale(String lang) {
		if (lang.equalsIgnoreCase("fr"))
			messages = new OpenTripPlannerClientMessagesFr();
		else
			messages = new OpenTripPlannerClientMessagesEn();
	}

	static public String tr(boolean nullSafe, String key, Object... arguments) {
		String str = messages.get(key);
		if (str == null && nullSafe)
			str = key;
		/*
		 * Poor man's implementation of MessageFormat. Not really efficient when
		 * we have lots of arguments, but this is seldom the case. This does not
		 * take into account escaping: we assume we do not need to display
		 * "{n}".
		 */
		for (int i = 0; i < arguments.length; i++) {
			str = str.replaceAll("\\{" + i + "\\}", arguments[i].toString());
		}
		return str;
	}

	static public String tr(String key, Object... arguments) {
		return tr(true, key, arguments);
	}
}
