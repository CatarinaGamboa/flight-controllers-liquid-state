// https://raw.githubusercontent.com/mavlink/MAVSDK/main/examples/ftp_server/ftp_server.cpp

import io.mavsdk.ftp.Ftp;

public class FTP {
  public static void main(String[] args) {
		Ftp ftp = new Ftp();
		ftp.initialize();
		// suppose we have a /home directory in the companion computer
		ftp.setRootDirectory("/home");
		
		// missing setId: Error
		
		// get the computer ID
		ftp.getOurCompid();
	}
}