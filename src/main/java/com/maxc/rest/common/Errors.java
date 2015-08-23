
package com.maxc.rest.common;

/**
 * 
 * @author ant_shake_tree
 *
 */
public enum Errors {
	PARAMETOR_ERROR(0x50000001,"PARAMETOR_ERROR","")
	,DYNAMIC_STREMENTING(0x50000002,"DYNAMIC_STREMENTING","[sql error] Dynamic stretching  data is null."),
	DEFAULT(0,"","");
	
	private int error;
	private String propertyName;
	private String message;

	/**
	 * @return propertyName
	 */
	public String getPropertyName() {
		return propertyName;
	}

	/**
	 * @param propertyName
	 *            the propertyName to set
	 */
	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}

	/**
	 * @return error
	 */
	public int getError() {
		return error;
	}

	/**
	 * @param error
	 *            the error to set
	 */
	public void setError(int error) {
		this.error = error;
	}

	/**
	 * @return message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message
	 *            the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * <p>
	 * Title:
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @param name
	 * @param ordinal
	 */

	private Errors(int error, String propertyName, String message) {
		this.error = error;
		this.propertyName = propertyName;
		this.message = message;
	}

	/**
	 * 通过属性名得到错误enum
	 * 
	 * @return: void
	 * @param string
	 */
	public static Errors fromByPropertyName(String string) {

		for (Errors r : values()) {
			if (r.getPropertyName().equalsIgnoreCase(string)) {
				return r;
			}
		}
		return DEFAULT;
	}

}
