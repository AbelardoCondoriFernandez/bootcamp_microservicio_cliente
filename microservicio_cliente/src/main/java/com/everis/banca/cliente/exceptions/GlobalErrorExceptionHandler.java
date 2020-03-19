package com.everis.banca.cliente.exceptions;

import org.springframework.boot.autoconfigure.web.ResourceProperties;
import org.springframework.boot.autoconfigure.web.reactive.error.AbstractErrorWebExceptionHandler;
import org.springframework.boot.web.reactive.error.ErrorAttributes;
import org.springframework.context.ApplicationContext;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.codec.ServerCodecConfigurer;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.*;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Component
@Order(-1)
public class GlobalErrorExceptionHandler extends AbstractErrorWebExceptionHandler{



	public GlobalErrorExceptionHandler(ErrorAttributes errorAttributes, ResourceProperties resourceProperties, ApplicationContext applicationContext, ServerCodecConfigurer configurer) {
			super(errorAttributes, resourceProperties, applicationContext);
			this.setMessageWriters(configurer.getWriters());
		}

		@Override
		protected RouterFunction<ServerResponse> getRoutingFunction(ErrorAttributes errorAttributes) {
			return RouterFunctions.route(RequestPredicates.all(), this::renderErrorResponse);
		}

		private Mono<ServerResponse> renderErrorResponse(ServerRequest request) {
			Map<String, Object> errorPropertiesMap = getErrorAttributes(request, false);
			final Map<String, Object> mapException = new HashMap<>();

			HttpStatus httpStatus;
			String status = String.valueOf(errorPropertiesMap.get("status"));
			switch (status) {
				case "500":
					mapException.put("error", "500");
					mapException.put("exception", "Status 500 Error Internal");
					httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
					break;
				default:
					mapException.put("error", "Invalid Variables");
					mapException.put("exception", "Status 400 BadRequest");
					httpStatus = HttpStatus.BAD_REQUEST;
					break;
			}

			mapException.put("mensaje", errorPropertiesMap.get("message"));
			mapException.put("ruta", request.uri());
			mapException.put("fecha-error", LocalDateTime.now());

			return ServerResponse.status(httpStatus)
					.contentType(MediaType.APPLICATION_STREAM_JSON)
					.body(BodyInserters.fromValue(mapException));
		}
	}
	