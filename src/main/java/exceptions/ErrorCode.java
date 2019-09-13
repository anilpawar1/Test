package exceptions;

/**
 * @author ganesh
 * 
 * 	<br>
 *	1xx	-	informational
 *	<br>
 *	2xx	-	success
 *	<br>
 *	3xx	-	Redirection
 *	<br>	
 *	4xx	-	Client error
 *	<br>
 *	5xx	-	Server error
 *	<br>	
 *	<b> GT Unique Generic Status Code digit - xxyyy </b> 
 *	<br>
 *	xx	-	It will represent status code family. Possible range 00 - 99
 *	<br>
 *	yyy	-	This will be represent resource or entity . Possible range 000 - 999
 *	<br>
 *	E.g.
 *		<b> NOT_FOUND </b> - Not found represent http status code 404, same we will take family code as xx - 05 or if someone have 
 *	best suggestion then will take that one.
 *	<br>
 *		If Vehicle resource not found then it will be 001 , for Driver resource not found then it will be 002 ,
 *		for VehicleDriverAssoc resource not found then it will be 003.
 *	<br>
 *	GT Unique generic status code should be 05001 - Vehicle resource not found.
 *	
 *	
 */
public enum ErrorCode {
	// start Bad Request family code.
	BAD_REQUEST("01000"),
	INVALID_PARAMTER("01001"),
	// end Bad Request family code.

	// start Unauthorized family code.
	UNAUTHORIZED("02000"),
	// end Unauthorized family code.

	// start Payment Required
	PAYMENT_REQUIRED("03000"),
	// end Payment Required

	// start FORBIDDEN family code.
	FORBIDDEN("04000"),
	VEHICLE_NOT_ACCESSIBLE("04001"),
	CLIENT_ORG_NOT_ACCESSIBLE("04002"),
	USER_NOT_ACCESSIBLE("04003"),
	WORKSHEETS_NOT_ACCESSIBLE("04004"),
	// end FORBIDDEN family code.

	// start Resource not found family code.
	RESOURCE_NOT_FOUND("05000"),
	NOTE_NOT_FOUND("44041"),
	USER_NOT_FOUND("05001"),
	VEHICLE_NOT_FOUND("05002"),
	DRIVER_NOT_FOUND("05003"),
	CLIENT_ORG_NOT_FOUND("05004"),
	WAYPOINT_NOT_FOUND("05005"),
	WORKSHEET_NOT_FOUND("05006"),
	SUBSCRIPTION_NOT_FOUND("05007"),
	SUBSCRIPTIONS_NOT_FOUND("05008"),
	TEMPLATE_NOT_FOUND("05009"),
	TEMPLATES_NOT_FOUND("05010"),
	//end Resource not found family code.

	// start NOT Acceptable family code.
	NOT_ACCEPTABLE("06000"),
	// end NOT Acceptable family code.

	// start CONFLICT family code.
	CONFLICT("07000"),
	// end CONFLICT family code.

	// start Resource already deleted family code.
	RESOURCE_ALREADY_DELETED("08000"),
	SUBSCRIPTION_ALREADY_DELETED("08001"),
	// end Resource already deleted family code.

	// start Bad resource family code.
	BAD_RESOURCE("09000"),
	BAD_RESOURCE_SUBSCRIPTION("09001"),
	BAD_RESOURCE_USER("09002"),
	BAD_RESOURCE_VEHICLE("09003"),
	// end Bad resource family code.

	// start Internal Server error family codes.
	INTERNAL_SERVER_ERROR("50000");

	private ErrorCode(String code) {
		this.code = code;
	}

	private String code;

	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}
}
