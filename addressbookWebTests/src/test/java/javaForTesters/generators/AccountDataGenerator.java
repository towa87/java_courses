package javaForTesters.generators;
  import com.beust.jcommander.JCommander;
        import com.beust.jcommander.Parameter;
        import com.beust.jcommander.ParameterException;
        import com.google.gson.Gson;
        import com.google.gson.GsonBuilder;
        import com.thoughtworks.xstream.XStream;
  import javaForTesters.model.AccountCreation;
         import java.io.File;
        import java.io.FileWriter;
        import java.io.IOException;
        import java.io.Writer;
        import java.util.ArrayList;
        import java.util.List;
/**
 * Created by Антон on 01.10.2016.
 */
public class AccountDataGenerator {
  @Parameter(names = "-c", description = "Account count")
  public int count;
  @Parameter(names = "-f", description = "Target file")
  public String file;

  @Parameter(names = "-d", description = "Data format")
  public String format;

  public static void main (String[] args) throws IOException {
    AccountDataGenerator generator = new AccountDataGenerator();

    JCommander jCommander  = new JCommander(generator);
    try{
      jCommander.parse(args);

    }catch (ParameterException ex)
    {
      jCommander.usage();
      return;
    }
    generator.run();
    // int count = Integer.parseInt(args[0]);
    //File file = new File(args[1]);
  }

  private void run() throws IOException {
    List<AccountCreation> accounts = generateAccounts(count);
    if(format.equals("csv"))
      saveAsCsv(accounts, new File (file));
    else if(format.equals("xml")){
      saveAsXml(accounts, new File (file));
    }
    else if(format.equals("json")){
      saveAsJson(accounts, new File (file));
    }
    else{
      System.out.println("Unknown format: " + format );
    }
  }

  private void saveAsJson(List<AccountCreation> accounts, File file) throws IOException {
    Gson gson = new GsonBuilder().setPrettyPrinting().excludeFieldsWithoutExposeAnnotation().create();
    String json = gson.toJson(accounts);
    Writer writer = new FileWriter(file);
    writer.write(json);
    writer.close();
  }

  private void saveAsXml(List<AccountCreation> accountCreations, File file) throws IOException {
    XStream xstream = new XStream();
    xstream.processAnnotations(AccountCreation.class);

    String xml = xstream.toXML(accountCreations);
    Writer writer = new FileWriter(file);
    writer.write(xml);
    writer.close();
  }

  private static List<AccountCreation> generateAccounts(int count) {
    List<AccountCreation> accounts = new ArrayList<AccountCreation>();
    for (int i = 0; i < count; i++) {
      accounts.add(new AccountCreation().withName(String.format("test %s", i))
              .withLastname1(String.format("test %s", i)).withAddress(String.format("test %s", i))
              .withEmail(String.format("test%s@test.com", i)).withEmail2(String.format("test%s@test.com", i+1)).withEmail3(String.format("test%s@test.com", i+2))
              .withTelephoneHome(String.format("99999999%s", i)).withWorkPhone(String.format("888888888%s", i)).withMobilePhone(String.format("666666663%s", i)));
    }
    return accounts;}

  private static void saveAsCsv(List<AccountCreation> accounts, File file) throws IOException {

    Writer writer = new FileWriter(file);
    for (AccountCreation account: accounts) {
      writer.write(String.format("%s;%s;%s\n", account.getName(), account.getLastname(), account.getAddress()));
    }
    writer.close();
  }
}
