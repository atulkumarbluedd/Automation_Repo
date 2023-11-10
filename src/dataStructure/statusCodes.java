package dataStructure;

public class statusCodes {
	/* 200 -ok
	 * 201 - created
	 * 204- no content
	 * *************redirection***********
	 * 304- not modified- suppose you have one API which usually don't change so when you hit that API then you will get this status.
	 * ********client side error**********************
	 * 400- Bad request- when user is "missing" some APIkey or password  or not proper information is given
	 * 401- Unauthorized - when user provided the wrong details.
	 * 403- forbidden - user don't have access 
	 * 404- not found - user is trying to access the non existing API
	 * 405- Method not allowed-
	 * 414- url is too long 
	 * 415- unsupported media type
	 * *************** server error***************
	 * 500- internal server error - some bug or exceptions
	 * 501- Not implemented - user is accessing the API which is not implemented.
	 * 502- bad gateway :: The 502 Bad Gateway error is an HTTP status code that means 
	 ---- that one server on the internet received an invalid response from another serve
	 * 503- service unavailable- Application server is down
	 * 504- gateway timeout - server is taking too much time to serve the request due to traffic.
	 * 
	 * 
	 *  
	 * */

}
