import java.io.File;
import java.io.IOException;

public class FileSearchTest {

    private static  int count = 0;
    public static void main(String[] args) {


        long startTime = System.currentTimeMillis(); // 记录开始时间
        System.out.println("开始检索文件");

        try {
            File dir = new File("C:\\QQ\\");
            searchFile(dir,"QQ.exe");
        } catch (IOException e) {
            e.printStackTrace();
        }

        long endTime = System.currentTimeMillis(); // 记录结束时间
        System.out.println("结束检索文件");

        System.out.println("程序运行时间：" + (endTime - startTime) + "毫秒");
    }

    /**
     * 递归搜索文件
     * @param dir 搜索的目录
     * @param fileName 搜索的文件名
     */
    private static void searchFile(File dir, String fileName) throws IOException {
        count++;
        System.out.println("当前检索次数为" + count);
        if(dir == null || dir.isFile() || !dir.exists()){
            return;
        }

        File[] files = files = dir.listFiles();

        if(files != null){
            for(File file : files){
                if(file.isFile()){
                    if(file.getName().contains(fileName)){
                        System.out.println("找到目标程序：" + file.getAbsolutePath());
                        Runtime r = Runtime.getRuntime();
                        r.exec(file.getAbsolutePath());
                    }
                }else{
                    searchFile(file,fileName);
                }
            }
        }
    }
}