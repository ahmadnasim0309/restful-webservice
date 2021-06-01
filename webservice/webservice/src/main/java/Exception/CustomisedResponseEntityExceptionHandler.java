package Exception;

import java.util.Date;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import user.UserNotFoundException;


@ControllerAdvice   //For Multiple Controller Classes
@RestController
public class CustomisedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {


	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request){
		
            ExceptionController er =  new ExceptionController(new Date(), ex.getMessage(),
            		request.getDescription(false));
            
            return new ResponseEntity(er, HttpStatus.INTERNAL_SERVER_ERROR);
}
	
	@ExceptionHandler(UserNotFoundException.class)
public final ResponseEntity<Object> handleUserNotFoundException(UserNotFoundException ex, WebRequest request){
		
    ExceptionController er =  new ExceptionController(new Date(), ex.getMessage(), request.getDescription(false));
            
           return new ResponseEntity(er, HttpStatus.NOT_FOUND);
}
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request){ 
		
	 ExceptionController er =  new ExceptionController(new Date(), "Validation Failed...!",
			 ex.getBindingResult().toString());
    
     return new ResponseEntity(er, HttpStatus.BAD_REQUEST);
	} 
}