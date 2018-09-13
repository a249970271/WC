package getdata;
import java.util.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;

public class wc {
	@SuppressWarnings("resource")
	public static void main (String[] args) {
		System.out.println("注意：若要读取的文件在根目录下只需输入文件名，若要读取的文件在其他路径，要连路径一起输入。");
		System.out.println("读取指令:-c  返回文件的字符数");
		System.out.println("读取指令:-w  返回文件的单词数");
		System.out.println("读取指令:-l  返回文件的行数");
		System.out.println("读取指令:-s  返回文件空行数，注释行数以及代码行数");
		System.out.println("读取指令:-all  返回上述所有数据");
		System.out.println("请输入读取指令，回车后输入文件名：");
		Scanner or =new Scanner(System.in);
		String order=or.nextLine();//从键盘中输入读取指令
		String filename=or.nextLine();//从键盘中输入文件名
		if(order.trim().equals("-c")) {
			getchars(filename);
		}//输入指令-c输出文件字符数
		else if(order.trim().equals("-w")) {
			getwords(filename);
		}//输入指令-w输出文件单词数
		else if(order.trim().equals("-l")) {
			getlines(filename);
		}//输入指令-l输出文件行数
		else if(order.trim().equals("-s")) {
			getkonglines(filename);
		}//输入指令-l输出文件行数
		else if(order.trim().equals("-all")) {
			getchars(filename);
			getwords(filename);
			getlines(filename);
			getkonglines(filename);
		}//输入指令-l输出文件行数
		else {
			System.out.println("指令输入错误。");
		}
	}

	public static void getchars(String filename1) {		
		File file = new File(filename1);
		if(!file.exists()) {
			System.out.println("未找到目标文件。");//指定路径下的文件不存在则输出：未找到目标文件
		}else {		
		try {
			FileInputStream fis=(new FileInputStream(file));
			int temp=0;
			while ((fis.read()) !=-1) {
				temp=temp+1;//每读取一个字符temp+1
				}
			System.out.println("该文件的字符数:"+temp);//输出temp
			fis.close();//关闭输入流
		}catch (IOException ex) {
			ex.printStackTrace();//捕获异常
		}
		}
	}
		
	public static void getwords(String filename1) {
		File file = new File(filename1);
		if(!file.exists()) {
			System.out.println("未找到目标文件。");//指定路径下的文件不存在则输出：未找到目标文件
		}else {
		try {
			FileInputStream fis=(new FileInputStream(file));
			int temp=0;
			int tempchar=0;
			while ((tempchar = fis.read()) !=-1) {
				if(((char)tempchar) == 32 || ((char)tempchar) == '\n'){
				temp=temp+1;//每读取到一个空格或换行符temp+1
				}
				}
			if(temp==0) {
			System.out.println("该文件的单词数:"+temp);//文件为空输出0
			}
			else {
				System.out.println("该文件的单词数:"+(temp+1));//文件不为空输出temp+1
			}
			fis.close();//关闭输入流
			
		}catch (IOException ex) {
			ex.printStackTrace();
		}
		}
	  }
		

	public static void getlines(String filename1) {
		File file = new File(filename1);
		if(!file.exists()) {
			System.out.println("未找到目标文件。");//指定路径下的文件不存在则输出：未找到目标文件
		}else {
		try {
			FileInputStream fis=(new FileInputStream(file));
			int temp=0;
			int tempchar=0;
			while ((tempchar = fis.read()) !=-1) {
				if(((char)tempchar) == '\n'){
				temp=temp+1;//每读取到一个换行符temp+1
				}}
			if(temp==0) {
				System.out.println("该文件的行数:"+temp);//文件为空输出0
				}
				else {
					System.out.println("该文件的行数:"+(temp+1));//文件不为空输出temp+1
				}
			fis.close();//关闭输入流
		
		}catch (IOException ex) {
			ex.printStackTrace();
		}
		}
      }
	public static void getkonglines(String filename1) {
		int dl = 0, kl = 0, zl = 0;
		String t;
		File file = new File(filename1);
		if(!file.exists()) {
			System.out.println("未找到目标文件。");//指定路径下的文件不存在则输出：未找到目标文件
		}else {
			try {
				BufferedReader br = new BufferedReader(new FileReader(file));
				while ((t = br.readLine())!= null) {
					if(t.trim().startsWith("//") == true || t.trim().startsWith("/*")==true ||t.trim().startsWith("}/*")==true || t.trim().startsWith("}//")==true){
						zl=zl+1;
					}
					else if(t.trim().length()==0 || (t.trim().startsWith("}") == true && t.trim().length()==1)) {
						kl=kl+1;
					}
					else {
						dl=dl+1;
					}
				}br.close();

			System.out.println("该文件的空行数:"+kl);
			System.out.println("该文件注释行数"+zl);
			System.out.println("该文件代码行数"+dl);
		}catch (IOException ex) {
			ex.printStackTrace();
			}
       }
	}
}
	
		
	


