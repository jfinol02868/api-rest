package com.finol.app.desarrollo.rest.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import org.springframework.stereotype.Component;

@Component
public class Util {
	
	public String getRadomPublicId() {
		SimpleDateFormat sfd = new SimpleDateFormat("yyyyMMddHHmm");
		return UUID.randomUUID().toString() + sfd.format(new Date()).toString();
	}
}
