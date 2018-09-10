package getdata;
import java.util.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.Reader;
import java.io.IOException;
import java.io.InputStreamReader;

public class wc {
	@SuppressWarnings("resource")
	public static void main (String[] args) {
		System.out.println("注意：若要读取的文件在根目录下只需输入文件名，若要读取的文件在其他路径，要连路径一起输入。");
		System.out.println("读取指令:-c  返回文件的字符数");
		System.out.println("读取指令:-w  返回文件的单词数");
		System.out.println("读取指令:-l  返回文件的行数");
		System.out.println("特殊指令:-s  后接文件条件，递归处理目录下符合条件的文件");
		System.out.println("请按序输入读取指令以及文件名：");
		Scanner or =new Scanner(System.in);
		String order=or.nextLine();//从键盘中输入读取指令
		String filename=or.nextLine();//从键盘中输入文件名
		if(order.trim().equals("-s")) {
			System.out.println("请按序输入读取指令以及文件名条件，格式举例：*.c");
			Scanner sp =new Scanner(System.in);
			String uper=sp.nextLine();//从键盘中输入读取指令
			String tiao=sp.nextLine();//从键盘中输入文件条件
		}
		if(order.trim().equals("-c")) {
			getchars(filename);
		}//输入指令-c输出文件字符数
		else if(order.trim().equals("-w")) {
			getwords(filename);
		}//输入指令-w输出文件单词数
		else if(order.trim().equals("-l")) {
			getlines(filename);
		}//输入指令-l输出文件行数
		else {
			System.out.println("指令输入错误。");
		}
		
	}

	public static void getchars(String filename1) {
		File file = new File(filename1);
		if(!file.exists()) {
			file.mkdirs();////指定路径下的文件要是不存在就创建
		}
		Reader reader = null;
		
		try {
			reader = new InputStreamReader(new FileInputStream(file));
			int temp=0;
			while ((reader.read()) !=-1) {
				temp=temp+1;//每读取一个字符temp+1
				}
			System.out.println("该文件的字符数:"+temp);//输出temp
			reader.close();//关闭输入流
		}catch (IOException ex) {
			ex.printStackTrace();
		}
	}
		
	public static void getwords(String filename1) {
			File file = new File(filename1);
			if(!file.exists()) {
				file.mkdirs();////指定路径下的文件要是不存在就创建
			}
			Reader reader = null;
			
			try {
				reader = new InputStreamReader(new FileInputStream(file));
				int temp=0;
				int tempchar=0;
				while ((tempchar = reader.read()) !=-1) {
					if(((char)tempchar) == 32 || ((char)tempchar) == '\n'){
					temp=temp+1;//每读取到一个空格temp+1
					}
					}
				if(temp==0) {
				System.out.println("该文件的单词数:"+temp);//文件为空输出0
				}
				else {
					System.out.println("该文件的单词数:"+(temp+1));//文件不为空输出temp+1
				}
				reader.close();//关闭输入流
			
			}catch (IOException ex) {
				ex.printStackTrace();
	   }
	
}
	public static void getlines(String filename1) {
		File file = new File(filename1);
		if(!file.exists()) {
			file.mkdirs();////指定路径下的文件要是不存在就创建
		}
		Reader reader = null;
		
		try {
			reader = new InputStreamReader(new FileInputStream(file));
			int temp=0;
			int tempchar=0;
			while ((tempchar = reader.read()) !=-1) {
				if(((char)tempchar) == '\n'){
				temp=temp+1;//每读取到一个换行符temp+1
				}}
			if(temp==0) {
				System.out.println("该文件的行数:"+temp);//文件为空输出0
				}
				else {
					System.out.println("该文件的行数:"+(temp+1));//文件不为空输出temp+1
				}
			reader.close();//关闭输入流
		
		}catch (IOException ex) {
			ex.printStackTrace();
   }

}
	}
	
		
	


