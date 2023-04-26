package com.liquidjava.flightcontrollers.examples.eval_ftp_1;

//https://raw.githubusercontent.com/mavlink/MAVSDK/main/examples/ftp_server/ftp_server.cpp

import io.mavsdk.ftp.Ftp;

public class FtpTest {
	public static void main(String[] args) {
		Ftp ftp = new Ftp();
		ftp.initialize();
		// suppose we have a /home directory in the companion computer
		ftp.setRootDirectory("/home");

		// get the computer ID
		ftp.getOurCompid();
	}
}