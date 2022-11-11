package com.hasandag.sr.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class Notification implements Serializable {

    private String notificationId;
    private Date createAt;
    private Boolean seen;
    private String message;

}
