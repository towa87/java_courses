package ru.stqa.pft.appmanager;

import org.apache.commons.net.ftp.FTPClient;
import sun.net.ftp.FtpClient;
import sun.net.ftp.FtpProtocolException;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Created by Антон on 19.10.2016.
 */
public class FtpHelper {
  private final ApplicationManager app;
  private FTPClient ftp;
  public FtpHelper(ApplicationManager app){
    this.app = app;
    ftp = new FTPClient();
  }
  public void upload(File file, String target, String backup) throws IOException, FtpProtocolException {
    ftp.connect(app.getProperty("ftp.host"));
    ftp.login(app.getProperty("ftp.login"), app.getProperty("ftp.password"));
    ftp.deleteFile(backup);
    ftp.rename(target, backup);
    ftp.enterLocalPassiveMode();
    ftp.storeFile(target, new FileInputStream(file));
    ftp.disconnect();
  }
  public void restore(String backup, String target) throws IOException, FtpProtocolException {
    ftp.connect(app.getProperty("ftp.host"));
    ftp.login(app.getProperty("ftp.login"), app.getProperty("ftp.password"));
    ftp.deleteFile(target);
    ftp.rename(backup, target);
    ftp.disconnect();
  }
}
