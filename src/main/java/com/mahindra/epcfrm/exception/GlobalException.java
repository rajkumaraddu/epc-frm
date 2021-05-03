/*
 * package com.mahindra.epcfrm.exception;
 * 
 * import java.io.IOException; import java.security.SignatureException; import
 * java.util.Date; import java.util.HashMap; import java.util.Map; import
 * org.springframework.http.HttpStatus; import
 * org.springframework.http.ResponseEntity; import
 * org.springframework.validation.FieldError; import
 * org.springframework.web.bind.MethodArgumentNotValidException; import
 * org.springframework.web.bind.annotation.ControllerAdvice; import
 * org.springframework.web.bind.annotation.ExceptionHandler; import
 * org.springframework.web.context.request.WebRequest;
 * 
 * @ControllerAdvice public class GlobalException {
 * 
 * // handle DataNotFoundException
 * 
 * @ExceptionHandler(DataNotFoundException.class) public ResponseEntity<?>
 * handleDataNotFoundException(DataNotFoundException exception, WebRequest
 * request) { ErrorDetails details = new ErrorDetails(new Date(),
 * exception.getMessage(), request.getDescription(false), null, 404, false);
 * return new ResponseEntity<>(details, HttpStatus.NOT_FOUND); }
 * 
 * // handle DataNotFoundException
 * 
 * @ExceptionHandler(IOException.class) public ResponseEntity<?>
 * handleDataNotFoundException(IOException exception, WebRequest request) {
 * ErrorDetails details = new ErrorDetails(new Date(), exception.getMessage(),
 * request.getDescription(false), null, 404, false); return new
 * ResponseEntity<>(details, HttpStatus.NOT_FOUND); }
 * 
 * // handle ValidationException
 * 
 * @ExceptionHandler(CustomValidationException.class) public ResponseEntity<?>
 * handleValidationException(CustomValidationException exception, WebRequest
 * request) { ErrorDetails details = new ErrorDetails(new Date(),
 * exception.getMessage(), request.getDescription(false), null, 404, false);
 * return new ResponseEntity<>(details, HttpStatus.NOT_FOUND); }
 * 
 * // handle ResourceAlreadyExists
 * 
 * @ExceptionHandler(ResourceAlreadyExistsException.class) public
 * ResponseEntity<?>
 * handleResourceAlreadyExistsException(ResourceAlreadyExistsException
 * exception, WebRequest request) { ErrorDetails details = new ErrorDetails(new
 * Date(), exception.getMessage(), request.getDescription(false), null, 404,
 * false); return new ResponseEntity<>(details, HttpStatus.NOT_FOUND); }
 * 
 * 
 * // handle Global Exception
 * 
 * @ExceptionHandler(Exception.class) public ResponseEntity<?>
 * handleGlobalException(Exception exception, WebRequest request) { ErrorDetails
 * details = new ErrorDetails(new Date(), exception.getMessage(),
 * request.getDescription(false), null, 404, false); return new
 * ResponseEntity<>(details, HttpStatus.INTERNAL_SERVER_ERROR); }
 * 
 * @ExceptionHandler(MethodArgumentNotValidException.class) public Map<String,
 * String> handleValidationExceptions(MethodArgumentNotValidException ex) {
 * Map<String, String> errors = new HashMap<>();
 * ex.getBindingResult().getAllErrors().forEach((error) -> { String fieldName =
 * ((FieldError) error).getField(); String errorMessage =
 * error.getDefaultMessage(); errors.put(fieldName, errorMessage); }); return
 * errors; }
 * 
 * 
 * @ExceptionHandler(RuntimeException.class) public ResponseEntity<ErrorDetails>
 * handleRunTimeException(RuntimeException exception, WebRequest request) {
 * ErrorDetails details = new ErrorDetails(new Date(), exception.getMessage(),
 * request.getDescription(false), null, 404, false); return new
 * ResponseEntity<>(details, HttpStatus.INTERNAL_SERVER_ERROR); }
 * 
 * @ExceptionHandler(SignatureException.class) public
 * ResponseEntity<ErrorDetails> handleSignatureException(SignatureException
 * exception, WebRequest request) { ErrorDetails details = new ErrorDetails(new
 * Date(), exception.getMessage(), request.getDescription(false), null, 404,
 * false); return new ResponseEntity<ErrorDetails>(details,
 * HttpStatus.BAD_REQUEST); }
 * 
 * }
 */