import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class FileGen {
String curDir = System.getProperty("user.dir");
int size;

    private static final String ALPHA_NUM = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final int MEGA_BYTE = 1024*1024;


    /**
     * @param mb Filesize in MB to be generated
     * @return File object
     * @throws IOException Could be lack of permissions or storage issues
     */
    public File getFile(int mb) throws IOException {
        System.out.println("cur dir = " + curDir);
        size = mb * MEGA_BYTE;
        Random r = new Random();
        String random = "";
        for (int i = 0; i < 150; i++) {
            random = random + ALPHA_NUM.charAt(r.nextInt(ALPHA_NUM.length()));
        }
        File file = new File(curDir + File.separator + "test" + mb + "MB.txt");
        if( file.createNewFile()) {
            FileWriter fw = new FileWriter(file);
            int i = 1000;
            int j = 0;
            while(file.length() < size){
                fw.write(random + "\n");
                j++;
            }
            System.out.println("printed : " + j);
            fw.flush();
            fw.close();
        }
        return file;
    }
}
