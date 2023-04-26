/**
 * https://raw.githubusercontent.com/mavlink/MAVSDK/main/examples/ftp_server/ftp_server.cpp
 */
package com.liquidjava.flightcontrollers.examples.eval_ftp_1;


public class FtpTest {
    public static void main(java.lang.String[] args) {
        io.mavsdk.ftp.Ftp ftp = new io.mavsdk.ftp.Ftp();
        // suppose we have a /home directory in the companion computer
        ftp.setRootDirectory("/home");
        // get the computer ID
        ftp.getOurCompid();
    }
}

