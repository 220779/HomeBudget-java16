package ee.secretagency.homebudgetjava16.dto;

import lombok.Builder;

import java.time.ZonedDateTime;


@Builder
public record ErrorInfo(
        ZonedDateTime timeStamp,
        int status,
        String error,
        String messages,
        String path

) {


}


