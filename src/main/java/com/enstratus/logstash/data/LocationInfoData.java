package com.enstratus.logstash.data;

import org.apache.log4j.spi.LocationInfo;

import java.net.InetAddress;

public class LocationInfoData {
	public String file;
	public String clazz;
	public String method;
	public String line;
	public String source_host;

	public LocationInfoData() {
		super();
	}

	public LocationInfoData(final LocationInfo info) {
		this();
		this.file = info.getFileName();
		this.clazz = info.getClassName();
		this.method = info.getMethodName();
		this.line = info.getLineNumber();
		try {
			this.source_host = InetAddress.getLocalHost().getHostName();
		} catch (java.net.UnknownHostException uKhe) {
			this.source_host = "localhost";
		}
	}

	public LocationInfo toLocationInfo() {
		return new LocationInfo(file, clazz, method, line);
	}
}
