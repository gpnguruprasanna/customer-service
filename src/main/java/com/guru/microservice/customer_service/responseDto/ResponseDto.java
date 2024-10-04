package com.guru.microservice.customer_service.responseDto;

import lombok.Data;

import java.util.Calendar;
import java.util.Date;

@Data
public class ResponseDto {
    private Integer httpStatus;
    private Date timeStamp;
    private boolean success;
    private Object objcet;
    private ResponseError error;

       public ResponseDto(Integer httpStatus, boolean success, Object objcet, ResponseError error){
            this.httpStatus=httpStatus;
            this.success=success;
            this.objcet=objcet;
            this.error=error;
        }
    public Date getTimeStamp() {
        return Calendar.getInstance().getTime();
    }
}
